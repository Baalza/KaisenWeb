package kaisenweb.kaisenweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kaisenweb.kaisenweb.config.KaisenConfigProperties;
import kaisenweb.kaisenweb.model.MovieMapper;
import kaisenweb.kaisenweb.utils.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Slf4j
@Service
public class TvService {
    private final WebClient webClient;
    private final KaisenConfigProperties configProperties;

    @Autowired
    public TvService(KaisenConfigProperties configProperties) {
        this.configProperties = configProperties;
        this.webClient = WebClient.create(getBaseUrl());
        log.debug("API-KEY = " + configProperties.apiKey());
    }

    private String getBaseUrl() {
        return configProperties.apiUrl() + "/" +
                configProperties.apiVersion() + "/";
    }

    public List<MovieMapper> trendingTodayTv() {
        List<MovieMapper> popMovie = new ArrayList<>();
        String grid = webClient.get()
                .uri("/trending/tv/day?api_key=" + configProperties.apiKey())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();
        for (int i = 0; i < 10; i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            popMovie.add(new MovieMapper(Integer.parseInt(idFilm), posterFilm, Type.TV_SERIES));
        }

        return popMovie;
    }

    public List<MovieMapper> trendingWeekTv() {
        List<MovieMapper> popMovie = new ArrayList<>();
        String grid = webClient.get()
                .uri("/trending/tv/week?api_key=" + configProperties.apiKey())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();
        for (int i = 0; i < 10; i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            popMovie.add(new MovieMapper(Integer.parseInt(idFilm), posterFilm, Type.TV_SERIES));
        }

        return popMovie;
    }

    public List<MovieMapper> popularTV() {
        List<MovieMapper> popTv = new ArrayList<>();
        String grid = webClient.get()
                .uri("/tv/popular?api_key=" + configProperties.apiKey() + "&language=it-It&page=1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();

        for (int i = 0; i < 10; i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idTv = object.getAsJsonObject().get("id").getAsString();
            if (!object.getAsJsonObject().get("poster_path").isJsonNull()) {
                String posterTv = object.getAsJsonObject().get("poster_path").getAsString();

                popTv.add(new MovieMapper(Integer.parseInt(idTv), posterTv, Type.TV_SERIES));
            } else {
                temp.remove(i);
                i--;
            }
        }


        return popTv;
    }

    public List<MovieMapper> averageTv() {
        List<MovieMapper> popTv = new ArrayList<>();
        String grid = webClient.get()
                .uri("/tv/top_rated?api_key=" + configProperties.apiKey() + "&language=it-IT&page=1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();
        for (int i = 0; i < 10; i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idTv = object.getAsJsonObject().get("id").getAsString();
            String posterTv = object.getAsJsonObject().get("poster_path").getAsString();

            popTv.add(new MovieMapper(Integer.parseInt(idTv), posterTv, Type.TV_SERIES));

        }

        return popTv;
    }
}
