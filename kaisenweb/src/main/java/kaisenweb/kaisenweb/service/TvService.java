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
public class TvService {

    public Map<Integer,String> popularTV() {
    Map <Integer, String> popTv = new HashMap<Integer, String>();
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/tv/popular?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-IT&page=1")
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
            String idTv = object.getAsJsonObject().get("id").getAsString();
            if(!object.getAsJsonObject().get("poster_path").isJsonNull()){

            
			String posterTv = object.getAsJsonObject().get("poster_path").getAsString();
            id.add(idTv);
			poster.add(posterTv);
            popTv.put(Integer.parseInt(idTv),posterTv.toString());
            }else{
            temp.remove(i);
            i--;
            }
        }

       
        
		return popTv;
    }

public Map<Integer,String> averageTv() {
    Map <Integer, String> popTv = new HashMap<Integer, String>();
    String grid = WebClient.create()
    .get()
    .uri("https://api.themoviedb.org/3/tv/top_rated?language=it-IT&page=1&api_key=dfcc7abe68d35aa410d4654be1b250b4")
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
            String idTv = object.getAsJsonObject().get("id").getAsString();
			String posterTv = object.getAsJsonObject().get("poster_path").getAsString();
            id.add(idTv);
			poster.add(posterTv);
            popTv.put(Integer.parseInt(idTv),posterTv.toString());
            
        }
        
		return popTv;
}
}
