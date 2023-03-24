package kaisenweb.kaisenweb.service;

import java.math.BigInteger;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class SearchService {
    
    //@GetMapping("/search")
    
    public  String searchResults(String query, String category) {//@RequestParam("query") String query
    StringBuilder url = new StringBuilder("https://api.themoviedb.org/3/search/") ;
    StringBuilder url3 = new StringBuilder ("?api_key=dfcc7abe68d35aa410d4654be1b250b4&query=");
    String url2 = "&language=it-IT";
    url.append(category).append(url3).append(query).append(url2);
    System.out.println(url);
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