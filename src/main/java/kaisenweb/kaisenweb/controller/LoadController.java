package kaisenweb.kaisenweb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kaisenweb.kaisenweb.service.TvService;
import lombok.AllArgsConstructor;
import kaisenweb.kaisenweb.model.Movie;
import kaisenweb.kaisenweb.model.MovieMapper;
import kaisenweb.kaisenweb.model.TrailerMapper;
import kaisenweb.kaisenweb.service.MovieService;

@RestController
@AllArgsConstructor
public class LoadController {
    private final MovieService movieService;
private final TvService tvService;
    @GetMapping("/Popolari")
    
    public String  popolari() {
    long start = System.currentTimeMillis();
    Map <Integer, String> popMovie = new HashMap<Integer, String>();
    Map <Integer, String> popTv = new HashMap<Integer, String>();
    
    popMovie = movieService.popularMovie();
    popTv = tvService.popularTV();
    popMovie.putAll(popTv);
    List <MovieMapper> movieMapper = new ArrayList<>();
    List<Map.Entry<Integer, String>> list = new ArrayList<>(popMovie.entrySet());
    Collections.shuffle(list);
        
    Map<Integer, String> shuffledMap = new LinkedHashMap<>();
    for(Map.Entry<Integer, String> entry : list){
        shuffledMap.put(entry.getKey(), entry.getValue());
    }
    for(Map.Entry<Integer, String> entry : shuffledMap.entrySet()){
       movieMapper.add(new MovieMapper(entry.getKey(), entry.getValue()));
    }
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(movieMapper);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
		return json;
}


    @GetMapping("/Trending")
    public String  trending() {
    long start = System.currentTimeMillis();
    List <MovieMapper> movieMapper = new ArrayList<>();
    Map <Integer, String> trending = new HashMap<Integer, String>();
  
    trending = movieService.trending();
    for(Map.Entry<Integer, String> entry : trending.entrySet()){
       movieMapper.add(new MovieMapper(entry.getKey(), entry.getValue()));
    }
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(movieMapper);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
		return json;
}

@GetMapping("/Upcoming")
public String  upComing() {
long start = System.currentTimeMillis();
List <MovieMapper> movieMapper = new ArrayList<>();
Map <Integer, String> upComing = new HashMap<Integer, String>();

upComing = movieService.upComingMovie();
for(Map.Entry<Integer, String> entry : upComing.entrySet()){
   movieMapper.add(new MovieMapper(entry.getKey(), entry.getValue()));
}
    ObjectMapper mapper = new ObjectMapper();
    String json = "";
    try {
        json = mapper.writeValueAsString(movieMapper);
    } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    return json;
}
@GetMapping("/Cinema")
public String  Cinema() {
long start = System.currentTimeMillis();
List <MovieMapper> movieMapper = new ArrayList<>();
Map <Integer, String> cinema = new HashMap<Integer, String>();

cinema = movieService.cinemaMovie();
for(Map.Entry<Integer, String> entry : cinema.entrySet()){
   movieMapper.add(new MovieMapper(entry.getKey(), entry.getValue()));
}
    ObjectMapper mapper = new ObjectMapper();
    String json = "";
    try {
        json = mapper.writeValueAsString(movieMapper);
    } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    return json;
}
@GetMapping("/Av")
    
public String  average() {
long start = System.currentTimeMillis();
Map <Integer, String> avMovie = new HashMap<Integer, String>();
Map <Integer, String> avTv = new HashMap<Integer, String>();

avMovie = movieService.averageMovie();
avTv = tvService.averageTv();
avMovie.putAll(avTv);
List <MovieMapper> movieMapper = new ArrayList<>();
List<Map.Entry<Integer, String>> list = new ArrayList<>(avMovie.entrySet());
Collections.shuffle(list);
    
Map<Integer, String> shuffledMap = new LinkedHashMap<>();
for(Map.Entry<Integer, String> entry : list){
    shuffledMap.put(entry.getKey(), entry.getValue());
}
for(Map.Entry<Integer, String> entry : shuffledMap.entrySet()){
   movieMapper.add(new MovieMapper(entry.getKey(), entry.getValue()));
}
    ObjectMapper mapper = new ObjectMapper();
    String json = "";
    try {
        json = mapper.writeValueAsString(movieMapper);
    } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    return json;
}



@GetMapping("/Trailerinarrivo")
public String  arrivo() {
long start = System.currentTimeMillis();
List <TrailerMapper> trailerMapper = new ArrayList<>();
List <Movie> usciteTrailer = new ArrayList<>();
usciteTrailer = movieService.upComingTrailer();

for(Movie movie : usciteTrailer){
    trailerMapper.add(new TrailerMapper(movie.getId(),movie.getTitle(),movie.getBackdropPath(),movie.getTrailer()));
    
 }
 

    ObjectMapper mapper = new ObjectMapper();
    String json = "";
    try {
        json = mapper.writeValueAsString(trailerMapper);
    } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    return json;
}
@GetMapping("/Trailercinema")
public String  cinema() {
long start = System.currentTimeMillis();
List <TrailerMapper> trailerMapper = new ArrayList<>();
List <Movie> usciteTrailer = new ArrayList<>();
usciteTrailer = movieService.cinemaTrailer();

for(Movie movie : usciteTrailer){
    trailerMapper.add(new TrailerMapper(movie.getId(),movie.getTitle(),movie.getBackdropPath(),movie.getTrailer()));
    
 }
 

    ObjectMapper mapper = new ObjectMapper();
    String json = "";
    try {
        json = mapper.writeValueAsString(trailerMapper);
    } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    return json;
}
@GetMapping("/Trailerpopolari")
public String  pop() {
long start = System.currentTimeMillis();
List <TrailerMapper> trailerMapper = new ArrayList<>();
List <Movie> usciteTrailer = new ArrayList<>();
usciteTrailer = movieService.popolariTrailer();

for(Movie movie : usciteTrailer){
    trailerMapper.add(new TrailerMapper(movie.getId(),movie.getTitle(),movie.getBackdropPath(),movie.getTrailer()));
    
 }
 

    ObjectMapper mapper = new ObjectMapper();
    String json = "";
    try {
        json = mapper.writeValueAsString(trailerMapper);
    } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    return json;
}
}