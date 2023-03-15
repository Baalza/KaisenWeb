package kaisenweb.kaisenweb;


import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KaisenwebApplication {

	public static void main(String[] args) { SpringApplication.run(KaisenwebApplication.class, args);
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
	}

}
