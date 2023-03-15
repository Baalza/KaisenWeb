package kaisenweb.kaisenweb;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
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
		RestTemplate restTemplate = new RestTemplate();
        
        String grid = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-It&page=1", String.class);
        //System.out.println(grid.trim());
		
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		JsonArray temp = data .get("results").getAsJsonArray();
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> poster = new ArrayList<String>();
		/*for(JsonElement element : temp){
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
			String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            id.add(idFilm);
			poster.add(posterFilm);
        }*/
		//first 10 popular film
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
		return mav;
}
}