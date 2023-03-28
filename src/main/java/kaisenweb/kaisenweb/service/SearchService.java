package kaisenweb.kaisenweb.service;

import kaisenweb.kaisenweb.config.KaisenConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.google.gson.Gson;
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
    public  String searchResults(String query, String category) {//@RequestParam("query") String query
    StringBuilder url = new StringBuilder(configProperties.apiUrl()+"/search/");
        String url2 = "&language=it-IT";
    url.append(category).append("?api_key=").append(configProperties.apiKey()).append("&query=").append(query).append(url2);
    log.debug("SEARCH SERVICE: " + url);
    String grid = WebClient.create()
    .get()
    .uri(url.toString())
    .retrieve()
    .bodyToMono(String.class)
    .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		String res = data.get("total_results").getAsString();
        System.out.println(res);
        return res;
    }
}