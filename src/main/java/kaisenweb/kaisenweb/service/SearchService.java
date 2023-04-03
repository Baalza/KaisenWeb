package kaisenweb.kaisenweb.service;

import kaisenweb.kaisenweb.config.KaisenConfigProperties;
import kaisenweb.kaisenweb.model.SearchResult;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Slf4j
@Service
public class SearchService {

    private final WebClient webClient;
    private final KaisenConfigProperties configProperties;

    @Autowired
    public SearchService(KaisenConfigProperties configProperties) {
        this.configProperties = configProperties;
        this.webClient = WebClient.create(getBaseUrl());
    }

    private String getBaseUrl() {
        return configProperties.apiUrl() + "/" +
                configProperties.apiVersion() + "/";
    }

    // TODO AGGIUNGERE  NUMERO PAGINE FILM, SERIE TV, COLLEZIONI
    
public String searchResults(String query, String category) {//@RequestParam("query") String query
        StringBuilder url = new StringBuilder("/search/");
        String url2 = "&language=it-IT";
        url.append(category).append("?api_key=").append(configProperties.apiKey()).append("&query=").append(query).append(url2);
        
        String grid = webClient.get()
                .uri(url.toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        String res = data.get("total_results").getAsString();
        
        
        return res;
    }
    public String searchPage(String query, String category) {//@RequestParam("query") String query
        StringBuilder url = new StringBuilder("/search/");
        String url2 = "&language=it-IT";
        url.append(category).append("?api_key=").append(configProperties.apiKey()).append("&query=").append(query).append(url2);
       
        String grid = webClient.get()
                .uri(url.toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        String res = data.get("total_pages").getAsString();
        
        
        return res;
    }
    public List <SearchResult> searchEntity(String query, String category, String page) {//@RequestParam("query") String query
    List  <SearchResult> searchList= new ArrayList();
    StringBuilder url = new StringBuilder("/search/");//https://api.themoviedb.org/3/search/tv?api_key=dfcc7abe68d35aa410d4654be1b250b4&query=Dune&language=it-IT&region=it
    String url2 = "&language=it-IT";
    String poster_path="";
    String title = "";
    String release = "";
    String description = "In questo momento non è presente una descrizione per questo contenuto";
        if(page.equals("null")){
           page="1";
        }
    
    url.append(category).append("?api_key=").append(configProperties.apiKey()).append("&query=").append(query).append("&page=").append(page).append(url2);
    System.out.println("SEARCH SERVICE: " + url);
    String grid = webClient.get()
            .uri(url.toString())
            .retrieve()
            .bodyToMono(String.class)
            .block();
            JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
            JsonArray temp = data.get("results").getAsJsonArray();
            
            for (int i = 0; i < temp.size(); i++) {
                SearchResult entity = new SearchResult();
                
                JsonElement element = temp.get(i);
                JsonObject object = element.getAsJsonObject();
                String idFilm = object.getAsJsonObject().get("id").getAsString();
                if(category.equals("movie")){
                    title = object.getAsJsonObject().get("title").getAsString();
                }else{
                    title = object.getAsJsonObject().get("original_name").getAsString();
                }
                if (!object.getAsJsonObject().get("poster_path").isJsonNull()) {
                     poster_path = object.getAsJsonObject().get("poster_path").getAsString();
                }else{
                     poster_path="";
                }
                if(!object.getAsJsonObject().get("overview").isJsonNull()){
                description = object.getAsJsonObject().get("overview").getAsString();
                }
                if(category.equals("movie")){
                    release = object.getAsJsonObject().get("release_date").getAsString();
                }else if(category.equals("tv")){
                    release = object.getAsJsonObject().get("first_air_date").getAsString();
                }else{
                    release = "";
                }
                
                entity.setId(Integer.parseInt(idFilm));
                entity.setTitle(title);
                entity.setPosterPath(poster_path);
                entity.setDescription(description);
                entity.setRelease(release);
                entity.setType(category);
                System.out.println("ID: "+entity.getId()+" TITLE: "+entity.getTitle()+" POSTER_PATH: "+entity.getPosterPath()+" DESCRIPTION: "+entity.getDescription()+" RELEASE: "+entity.getRelease()+" TYPE: "+entity.getType());
                searchList.add(entity);
            }
    System.out.println("query: "+query+" category: "+category+" page: "+page);
    return searchList;
}
}