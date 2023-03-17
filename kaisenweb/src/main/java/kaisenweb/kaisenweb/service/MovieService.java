package kaisenweb.kaisenweb.service;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kaisenweb.kaisenweb.model.Movie;

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
		for(int i = 0 ; i<temp.size(); i++){
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
    .uri("https://api.themoviedb.org/3/movie/top_rated?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-IT&page=1")
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
public List<Movie> upComingTrailer() {
    
    List<Movie> list = new ArrayList<>();
    String prov ="https://api.themoviedb.org/3/movie/";
    String call ="/videos?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-IT";
    String youtube = "https://www.youtube.com/watch?v=";
    //Map <Integer, String> popMovie = new HashMap<Integer, String>();
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/movie/upcoming?page=1&api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-IT&region=IT")
    .retrieve()
    .bodyToMono(String.class)
    .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		JsonArray temp = data .get("results").getAsJsonArray();
		for(int i = 0 ; i<10; i++){
            Movie movie = new Movie();
            String url = "";
            String back="";
			JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
			String title = object.getAsJsonObject().get("title").getAsString();
            if(!object.getAsJsonObject().get("backdrop_path").isJsonNull()){
            back = object.getAsJsonObject().get("backdrop_path").getAsString();
            movie.setId(Integer.parseInt(idFilm));
            movie.setTitle(title);
            movie.setBackdropPath(back);
            //System.out.println(idFilm);
            url = prov.concat(idFilm).concat(call);
            //url = prov.append(idFilm).append(call).toString();
            //System.out.println("url finale"+url);
            String grid2 = WebClient.create()
            .get()
            .uri(url)
            .retrieve()
            .bodyToMono(String.class)
            .block();
            JsonObject data2 = new Gson().fromJson(grid2.trim(), JsonObject.class);
		    JsonArray temp2 = data2 .get("results").getAsJsonArray();
            if(!temp2.isEmpty()){
                youtube = "https://www.youtube.com/embed/";
                JsonElement el = temp2.get(0);
                JsonObject obj = el.getAsJsonObject();
                String video = obj.getAsJsonObject().get("key").getAsString();
                youtube = youtube.concat(video);
                movie.setTrailer(youtube.toString());
                list.add(movie);
            } else{
                temp.remove(i);
                i--;
            }
        }else{
            temp.remove(i);
                i--;
        }  
        }
		return list;
}
public List<Movie> cinemaTrailer() {
    
    List<Movie> list = new ArrayList<>();
    String prov ="https://api.themoviedb.org/3/movie/";
    String call ="/videos?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-IT";
    String youtube = "https://www.youtube.com/watch?v=";
    //Map <Integer, String> popMovie = new HashMap<Integer, String>();
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/movie/now_playing?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-IT&page=1&region=IT")
    .retrieve()
    .bodyToMono(String.class)
    .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		JsonArray temp = data .get("results").getAsJsonArray();
		for(int i = 0 ; i<10; i++){
            Movie movie = new Movie();
            String url = "";
            String back="";
			JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
			String title = object.getAsJsonObject().get("title").getAsString();
            if(!object.getAsJsonObject().get("backdrop_path").isJsonNull()){
            back = object.getAsJsonObject().get("backdrop_path").getAsString();
            movie.setId(Integer.parseInt(idFilm));
            movie.setTitle(title);
            movie.setBackdropPath(back);
            //System.out.println(idFilm);
            url = prov.concat(idFilm).concat(call);
            //url = prov.append(idFilm).append(call).toString();
            //System.out.println("url finale"+url);
            String grid2 = WebClient.create()
            .get()
            .uri(url)
            .retrieve()
            .bodyToMono(String.class)
            .block();
            JsonObject data2 = new Gson().fromJson(grid2.trim(), JsonObject.class);
		    JsonArray temp2 = data2 .get("results").getAsJsonArray();
            if(!temp2.isEmpty()){
                youtube = "https://www.youtube.com/embed/";
                JsonElement el = temp2.get(0);
                JsonObject obj = el.getAsJsonObject();
                String video = obj.getAsJsonObject().get("key").getAsString();
                youtube = youtube.concat(video);
                movie.setTrailer(youtube.toString());
                list.add(movie);
            } else{
                temp.remove(i);
                i--;
            }
        }else{
            temp.remove(i);
                i--;
        }  
        }
		return list;
}
public List<Movie> popolariTrailer() {
    
    List<Movie> list = new ArrayList<>();
    String prov ="https://api.themoviedb.org/3/movie/";
    String call ="/videos?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-IT";
    String youtube = "https://www.youtube.com/watch?v=";
    //Map <Integer, String> popMovie = new HashMap<Integer, String>();
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/movie/popular?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-It&page=1")
    .retrieve()
    .bodyToMono(String.class)
    .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		JsonArray temp = data .get("results").getAsJsonArray();
		for(int i = 0 ; i<10; i++){
            Movie movie = new Movie();
            String url = "";
            String back="";
			JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
			String title = object.getAsJsonObject().get("title").getAsString();
            if(!object.getAsJsonObject().get("backdrop_path").isJsonNull()){
            back = object.getAsJsonObject().get("backdrop_path").getAsString();
            movie.setId(Integer.parseInt(idFilm));
            movie.setTitle(title);
            movie.setBackdropPath(back);
            //System.out.println(idFilm);
            url = prov.concat(idFilm).concat(call);
            //url = prov.append(idFilm).append(call).toString();
            //System.out.println("url finale"+url);
            String grid2 = WebClient.create()
            .get()
            .uri(url)
            .retrieve()
            .bodyToMono(String.class)
            .block();
            JsonObject data2 = new Gson().fromJson(grid2.trim(), JsonObject.class);
		    JsonArray temp2 = data2 .get("results").getAsJsonArray();
            if(!temp2.isEmpty()){
                youtube = "https://www.youtube.com/embed/";
                JsonElement el = temp2.get(0);
                JsonObject obj = el.getAsJsonObject();
                String video = obj.getAsJsonObject().get("key").getAsString();
                youtube = youtube.concat(video);
                movie.setTrailer(youtube.toString());
                list.add(movie);
            } else{
                temp.remove(i);
                i--;
            }
        }else{
            temp.remove(i);
                i--;
        }  
        }
		return list;
}
}

