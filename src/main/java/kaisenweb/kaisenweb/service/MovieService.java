package kaisenweb.kaisenweb.service;

import java.util.*;

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

import kaisenweb.kaisenweb.model.Movie;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class MovieService {

    private final WebClient webClient;
    private final KaisenConfigProperties configProperties;
    private final Gson gson;

    @Autowired
    public MovieService(KaisenConfigProperties configProperties) {
        this.configProperties = configProperties;
        this.webClient = WebClient.create(getBaseUrl());
        gson = new Gson();
        log.debug("API-KEY = " + configProperties.apiKey());
    }

    private String getBaseUrl() {
        return configProperties.apiUrl() + "/" +
                configProperties.apiVersion() + "/";
    }

    public List<MovieMapper> popularMovie() {
        List<MovieMapper> popMovie = new ArrayList<>();
        String grid = webClient.get()
                .uri("/movie/popular?api_key=" + configProperties.apiKey() + "&language=it-It&page=1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();

        for (int i = 0; i < temp.size() / 2; i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            popMovie.add(new MovieMapper(Integer.parseInt(idFilm), posterFilm, Type.MOVIE));
        }
        return popMovie;
    }

    public List<MovieMapper> trendingTodayMovie() {
        List<MovieMapper> popMovie = new ArrayList<>();
        String grid = webClient.get()
                .uri("/trending/movie/day?api_key=" + configProperties.apiKey() + "&language=it-IT&region=IT")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();
        for (int i = 0; i < temp.size() / 2; i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            popMovie.add(new MovieMapper(Integer.parseInt(idFilm), posterFilm, Type.MOVIE));
        }

        return popMovie;
    }

    public List<MovieMapper> trendingWeekMovie() {
        List<MovieMapper> popMovie = new ArrayList<>();
        String grid = webClient.get()
                .uri("/trending/movie/week?api_key=" + configProperties.apiKey() + "&language=it-IT&region=IT")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();
        for (int i = 0; i < temp.size() / 2; i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            popMovie.add(new MovieMapper(Integer.parseInt(idFilm), posterFilm, Type.MOVIE));
        }

        return popMovie;
    }

    public List<MovieMapper> upComingMovie() {
        List<MovieMapper> upComingMovies = new ArrayList<>();
        String grid = webClient.get()
                .uri("/movie/upcoming?&api_key=" + configProperties.apiKey() + "&language=it-IT&region=IT")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();
        
        for (int i = 0; i < temp.size(); i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            
            if (!object.getAsJsonObject().get("poster_path").isJsonNull()) {
                String posterFilm = object.get("poster_path").getAsString();
                upComingMovies.add(new MovieMapper(Integer.parseInt(idFilm), posterFilm, Type.MOVIE));
            }else{
                temp.remove(i);
                i--;
            }

            
        }
        
        return upComingMovies;
    }

    public List<MovieMapper> cinemaMovie() {
        List<MovieMapper> cinemaMovies = new ArrayList<>();
        String grid = webClient.get()
                .uri("/movie/now_playing?api_key=" + configProperties.apiKey() + "&language=it-IT&page=1&region=IT")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();

        for (int i = 0; i < temp.size(); i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            cinemaMovies.add(new MovieMapper(Integer.parseInt(idFilm), posterFilm, Type.MOVIE));

        }

        return cinemaMovies;
    }

    public List<MovieMapper> topRatedMovies() {
        List<MovieMapper> topRatedMovies = new ArrayList<>();
        String grid = webClient.get()
                .uri("/movie/top_rated?api_key=" + configProperties.apiKey() + "&language=it-IT&page=1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();
        for (int i = 0; i < temp.size() / 2; i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            String posterFilm = object.getAsJsonObject().get("poster_path").getAsString();
            topRatedMovies.add(new MovieMapper(Integer.parseInt(idFilm), posterFilm, Type.MOVIE));

        }

        return topRatedMovies;
    }

    public List<Movie> upComingTrailer() {
        List<Movie> list = new ArrayList<>();
        String prov = "https://api.themoviedb.org/3/movie/";
        String call = "/videos?api_key=" + configProperties.apiKey() + "&language=it-IT";
        String youtube;
        String grid = webClient.get()
                .uri("/movie/upcoming?&api_key=" + configProperties.apiKey() + "&language=it-IT&region=IT")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();
        for (int i = 0; i < temp.size() / 2; i++) {
            Movie movie = new Movie();
            String url = "";
            String back = "";
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            String title = object.getAsJsonObject().get("title").getAsString();
            if (!object.getAsJsonObject().get("backdrop_path").isJsonNull()) {
                back = object.getAsJsonObject().get("backdrop_path").getAsString();
                movie.setId(Integer.parseInt(idFilm));
                movie.setTitle(title);
                movie.setBackdropPath(back);
                //System.out.println(idFilm);
                url = prov.concat(idFilm).concat(call);
                //url = prov.append(idFilm).append(call).toString();
                //System.out.println("url finale"+url);
                String grid2 = webClient
                        .get()
                        .uri(url)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
                JsonObject data2 = new Gson().fromJson(grid2.trim(), JsonObject.class);
                JsonArray temp2 = data2.get("results").getAsJsonArray();
                if (!temp2.isEmpty()) {
                    youtube = "//www.youtube.com/embed/";
                    JsonElement el = temp2.get(0);
                    JsonObject obj = el.getAsJsonObject();
                    String video = obj.getAsJsonObject().get("key").getAsString();
                    youtube = youtube.concat(video);
                    movie.setTrailer(youtube);
                    list.add(movie);
                } else {
                    temp.remove(i);
                    i--;
                }
            } else {
                temp.remove(i);
                i--;
            }
        }
        return list;
    }

    public List<Movie> cinemaTrailer() {

        List<Movie> list = new ArrayList<>();
        String prov = "https://api.themoviedb.org/3/movie/";
        String call = "/videos?api_key=" + configProperties.apiKey() + "&language=it-IT";
        String youtube = "//www.youtube.com/watch?v=";
        //Map <Integer, String> popMovie = new HashMap<Integer, String>();
        String grid = webClient
                .get()
                .uri("/movie/now_playing?api_key=" + configProperties.apiKey() + "&language=it-IT&page=1&region=IT")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();
        for (int i = 0; i < temp.size() / 2; i++) {
            Movie movie = new Movie();
            String url = "";
            String back = "";
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            String title = object.getAsJsonObject().get("title").getAsString();
            if (!object.getAsJsonObject().get("backdrop_path").isJsonNull()) {
                back = object.getAsJsonObject().get("backdrop_path").getAsString();
                movie.setId(Integer.parseInt(idFilm));
                movie.setTitle(title);
                movie.setBackdropPath(back);
                //System.out.println(idFilm);
                url = prov.concat(idFilm).concat(call);
                //url = prov.append(idFilm).append(call).toString();
                //System.out.println("url finale"+url);
                String grid2 = webClient
                        .get()
                        .uri(url)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
                JsonObject data2 = new Gson().fromJson(grid2.trim(), JsonObject.class);
                JsonArray temp2 = data2.get("results").getAsJsonArray();
                if (!temp2.isEmpty()) {
                    youtube = "//www.youtube.com/embed/";
                    JsonElement el = temp2.get(0);
                    JsonObject obj = el.getAsJsonObject();
                    String video = obj.getAsJsonObject().get("key").getAsString();
                    youtube = youtube.concat(video);
                    movie.setTrailer(youtube.toString());
                    list.add(movie);
                } else {
                    temp.remove(i);
                    i--;
                }
            } else {
                temp.remove(i);
                i--;
            }
        }
        return list;
    }

    public List<Movie> popolariTrailer() {

        List<Movie> list = new ArrayList<>();
        String prov = "https://api.themoviedb.org/3/movie/";
        String call = "/videos?api_key=" + configProperties.apiKey() + "&language=it-IT";
        String youtube = "//www.youtube.com/watch?v=";
        //Map <Integer, String> popMovie = new HashMap<Integer, String>();
        String grid = webClient
                .get()
                .uri("/movie/popular?api_key=" + configProperties.apiKey() + "&language=it-It&page=1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();
        for (int i = 0; i < temp.size() / 2; i++) {
            Movie movie = new Movie();
            String url = "";
            String back = "";
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String idFilm = object.getAsJsonObject().get("id").getAsString();
            String title = object.getAsJsonObject().get("title").getAsString();
            if (!object.getAsJsonObject().get("backdrop_path").isJsonNull()) {
                back = object.getAsJsonObject().get("backdrop_path").getAsString();
                movie.setId(Integer.parseInt(idFilm));
                movie.setTitle(title);
                movie.setBackdropPath(back);
                //System.out.println(idFilm);
                url = prov.concat(idFilm).concat(call);
                //url = prov.append(idFilm).append(call).toString();
                //System.out.println("url finale"+url);
                String grid2 = webClient
                        .get()
                        .uri(url)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
                JsonObject data2 = new Gson().fromJson(grid2.trim(), JsonObject.class);
                JsonArray temp2 = data2.get("results").getAsJsonArray();
                if (!temp2.isEmpty()) {
                    youtube = "//www.youtube.com/embed/";
                    JsonElement el = temp2.get(0);
                    JsonObject obj = el.getAsJsonObject();
                    String video = obj.getAsJsonObject().get("key").getAsString();
                    youtube = youtube.concat(video);
                    movie.setTrailer(youtube);
                    list.add(movie);
                } else {
                    temp.remove(i);
                    i--;
                }
            } else {
                temp.remove(i);
                i--;
            }
        }
        return list;
    }

    public List<String> trendingBack() {
        List<String> list = new ArrayList<>();
        String grid = webClient
                .get()
                .uri("/trending/all/day?api_key=" + configProperties.apiKey() + "")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        JsonArray temp = data.get("results").getAsJsonArray();

        for (int i = 0; i < temp.size(); i++) {
            JsonElement element = temp.get(i);
            JsonObject object = element.getAsJsonObject();
            String posterFilm = object.getAsJsonObject().get("backdrop_path").getAsString();
            list.add(posterFilm);
        }
        Collections.shuffle(list);
        return list;
    }
}

