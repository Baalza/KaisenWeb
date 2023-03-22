package kaisenweb.kaisenweb.service;

import java.math.BigInteger;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
@Controller
public class SearchService {
    
    //@GetMapping("/search")
    @RequestMapping(value="/search", params = {"query"})
    public  void searchResults(@RequestParam("query") String query) {//@RequestParam("query") String query
    List <Integer> list = new ArrayList<>();
    StringBuilder url = new StringBuilder("https://api.themoviedb.org/3/search/movie?api_key=dfcc7abe68d35aa410d4654be1b250b4&query=") ;
    String url2 = "&language=it-IT";
    url.append(query).append(url2);
    String grid = WebClient.create()
    .get()
    .uri(url.toString())
    .retrieve()
    .bodyToMono(String.class)
    .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		String movieRes = data.get("total_results").getAsString();
        list.add(Integer.parseInt(movieRes));

        StringBuilder url3 = new StringBuilder("https://api.themoviedb.org/3/search/tv?api_key=dfcc7abe68d35aa410d4654be1b250b4&query=") ;
        String url4 = "&language=it-IT";
        url3.append(query).append(url4);
        String grid2 = WebClient.create()
        .get()
        .uri(url3.toString())
        .retrieve()
        .bodyToMono(String.class)
        .block();
            JsonObject data2 = new Gson().fromJson(grid2.trim(), JsonObject.class);
            String tvRes = data2.get("total_results").getAsString();
		list.add(Integer.parseInt(tvRes));
        

        StringBuilder url5 = new StringBuilder("https://api.themoviedb.org/3/search/collection?api_key=dfcc7abe68d35aa410d4654be1b250b4&query=") ;
        String url6 = "&language=it-IT";
        url5.append(query).append(url6);
        String grid3 = WebClient.create()
        .get()
        .uri(url5.toString())
        .retrieve()
        .bodyToMono(String.class)
        .block();
            JsonObject data3 = new Gson().fromJson(grid3.trim(), JsonObject.class);
            String coll = data3.get("total_results").getAsString();
            
		list.add(Integer.parseInt(coll));
        System.out.println("Film "+list.get(0)+"Serie "+list.get(1)+"Collezioni "+list.get(2));
        
    }
}