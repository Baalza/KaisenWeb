package kaisenweb.kaisenweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class MovieService {

    public Map<Integer,String> popularMovie() {
    Map <Integer, String> popMovie = new HashMap<Integer, String>();
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/movie/popular?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-It&page=1")
    .retrieve()
    .bodyToMono(String.class)
    .block();
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
            popMovie.put(Integer.parseInt(idFilm),posterFilm.toString());
            
        }
        
		return popMovie;
}
public Map<Integer,String> trending() {
    Map <Integer, String> popMovie = new HashMap<Integer, String>();
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/trending/all/week?api_key=dfcc7abe68d35aa410d4654be1b250b4")
    .retrieve()
    .bodyToMono(String.class)
    .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		JsonArray temp = data .get("results").getAsJsonArray();
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> poster = new ArrayList<String>();
		for(int i = 0 ; i<20; i++){
			JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
			String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            id.add(idFilm);
			poster.add(posterFilm);
            popMovie.put(Integer.parseInt(idFilm),posterFilm.toString());
            
        }
        
		return popMovie;
}
public Map<Integer,String> upComingMovie() {
    Map <Integer, String> popMovie = new HashMap<Integer, String>();
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/movie/upcoming?page=1&api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-IT&region=IT")
    .retrieve()
    .bodyToMono(String.class)
    .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		JsonArray temp = data .get("results").getAsJsonArray();
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> poster = new ArrayList<String>();
		for(int i = 0 ; i<20; i++){
			JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
			String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            id.add(idFilm);
			poster.add(posterFilm);
            popMovie.put(Integer.parseInt(idFilm),posterFilm.toString());
            
        }
        
		return popMovie;
}
public Map<Integer,String> cinemaMovie() {
    Map <Integer, String> popMovie = new HashMap<Integer, String>();
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/movie/now_playing?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-IT&page=1&region=IT")
    .retrieve()
    .bodyToMono(String.class)
    .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		JsonArray temp = data .get("results").getAsJsonArray();
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> poster = new ArrayList<String>();
		for(int i = 0 ; i<20; i++){
			JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
			String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            id.add(idFilm);
			poster.add(posterFilm);
            popMovie.put(Integer.parseInt(idFilm),posterFilm.toString());
            
        }
        
		return popMovie;
}
public Map<Integer,String> averageMovie() {
    Map <Integer, String> popMovie = new HashMap<Integer, String>();
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/discover/movie?language=it-IT&sort_by=vote_average.desc&page=1&api_key=dfcc7abe68d35aa410d4654be1b250b4")
    .retrieve()
    .bodyToMono(String.class)
    .block();
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
            popMovie.put(Integer.parseInt(idFilm),posterFilm.toString());
            
        }
        System.out.println("film av"+popMovie.size());
		return popMovie;
}
}
