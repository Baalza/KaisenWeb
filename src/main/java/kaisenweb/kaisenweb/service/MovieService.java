package kaisenweb.kaisenweb.service;

import java.util.*;

import javax.imageio.ImageIO;

import kaisenweb.kaisenweb.config.KaisenConfigProperties;
import kaisenweb.kaisenweb.model.MovieMapper;
import kaisenweb.kaisenweb.utils.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import kaisenweb.kaisenweb.model.Genre;
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

    public Movie movieDetail(String id) {//@RequestParam("query") String query
    String backdrop_path="";
    String poster_path="";
    String title = "";
    String release = "";
    String description = "";
    String runtime = "";
    String tagline = "";
    Movie movie = new Movie();
    
        String grid = webClient
                .get()
                .uri("/movie/"+id+"?api_key=" + configProperties.apiKey() + "&language=it-It")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
        if (!data.get("backdrop_path").isJsonNull()) {
        backdrop_path = data.get("backdrop_path").getAsString();

        try {
            URL url = new URL("https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces" + backdrop_path);
            BufferedImage image = ImageIO.read(url);
            // ... Resto del codice ...
            float scaleFactor = 0.2f; // Fattore di scala (0 = nero, 1 = nessuna modifica, >1 = più chiaro)
            float offset = 0; // Valore offset
            RescaleOp op = new RescaleOp(scaleFactor, offset, null);
            BufferedImage darker = op.filter(image, null);

            // Salva l'immagine su disco
            //File output = new File(backdrop_path);
            //ImageIO.write(darker, "jpg", output);
            // Scrive l'immagine in un array di byte
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(darker, "jpg", baos);
            byte[] imageData = baos.toByteArray();
            String imageDataString = Base64.getEncoder().encodeToString(imageData);
            backdrop_path="data:image/gif;base64,"+imageDataString;
            movie.setBackdropPath(backdrop_path);
        } catch (MalformedURLException e) {
            System.out.println("L'URL non è formattato correttamente: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Errore durante la lettura dell'immagine: " + e.getMessage());
        }
    }
    if (!data.get("poster_path").isJsonNull()) {
        poster_path = data.get("poster_path").getAsString();
        movie.setPosterPath(poster_path);
    }
    if (!data.get("title").isJsonNull()) {
        title = data.get("title").getAsString();
        movie.setTitle(title);
    }else if (!data.get("original_title").isJsonNull()) {
        title = data.get("original_title").getAsString();
        movie.setTitle(title);
        movie.setOriginalTitle(title);
    }
    if (!data.get("original_title").isJsonNull()) {
        title = data.get("original_title").getAsString();
        movie.setOriginalTitle(title);
    }
    if (!data.get("release_date").isJsonNull()) {
        release = data.get("release_date").getAsString();
        movie.setReleaseDate(release);
    }
    if (!data.get("overview").isJsonNull()) {
        description = data.get("overview").getAsString();
        movie.setOverview(description);
    }
    if (!data.get("runtime").isJsonNull()) {
        runtime = data.get("runtime").getAsString()+"m";
        movie.setRuntime(runtime);
    }
    if (!data.get("genres").getAsJsonArray().isEmpty()) {
        for(int i=0; i<data.get("genres").getAsJsonArray().size(); i++){
            Genre genre = new Genre();
            genre.setId(Integer.parseInt(data.get("genres").getAsJsonArray().get(i).getAsJsonObject().get("id").getAsString()));
            if(i<data.get("genres").getAsJsonArray().size()-1){
            genre.setName(data.get("genres").getAsJsonArray().get(i).getAsJsonObject().get("name").getAsString().concat(", "));
        }else{
            genre.setName(data.get("genres").getAsJsonArray().get(i).getAsJsonObject().get("name").getAsString());
        }
            movie.getGenres().add(genre);
        }
       System.out.println(data.get("genres").getAsJsonArray());
       for(int i=0; i<movie.getGenres().size();i++){
        System.out.println(movie.getGenres().get(i));
       }
    }


    // TODO PER TAG LINE
    if (!data.get("tagline").getAsString().isEmpty()) {
        tagline = data.get("tagline").getAsString();
        movie.setTagline(tagline);
    }else{
    String grid2 = webClient
                .get()
                .uri("/movie/"+id+"?api_key=" + configProperties.apiKey() + "&language=en-EN")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonObject data2 = new Gson().fromJson(grid2.trim(), JsonObject.class);
        if (!data2.get("tagline").getAsString().isEmpty()) {
        tagline = data2.get("tagline").getAsString();
        movie.setTagline(tagline);
        }
        
    }
    return movie;
}

}

