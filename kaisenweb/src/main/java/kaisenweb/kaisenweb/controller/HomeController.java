package kaisenweb.kaisenweb.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView addWork() {
    ModelAndView mav = new ModelAndView("index.html");
		//RestTemplate restTemplate = new RestTemplate();
        //String grid = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-It&page=1", String.class);
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/movie/popular?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-It&page=1")
    .retrieve()
    .bodyToMono(String.class)
    .block();
    //System.out.println(json);
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		JsonArray temp = data .get("results").getAsJsonArray();
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> poster = new ArrayList<String>();
		for(int i = 0 ; i<10; i++){
			JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
			String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            id.add(idFilm);
			poster.add(posterFilm);
        }
		id.stream().forEach(System.out::println);
		poster.stream().forEach(System.out::println);
        mav.addObject("poster", poster);
        //web client
    
		return mav;
}
}