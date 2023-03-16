package kaisenweb.kaisenweb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kaisenweb.kaisenweb.service.TvService;
import lombok.AllArgsConstructor;
import kaisenweb.kaisenweb.service.MovieService;

@Controller
@AllArgsConstructor
public class HomeController {
private final MovieService movieService;
private final TvService tvService;

    @GetMapping("/home")
    public ModelAndView addWork() {
    Map <Integer, String> popMovie = new HashMap<Integer, String>();
    Map <Integer, String> popTv = new HashMap<Integer, String>();
    Map <Integer, String> trending = new HashMap<Integer, String>();
    Map <Integer, String> upComing = new HashMap<Integer, String>();
    Map <Integer, String> cinema = new HashMap<Integer, String>();
    Map <Integer, String> avMovie = new HashMap<Integer, String>();
    Map <Integer, String> avTv = new HashMap<Integer, String>();
    popMovie = movieService.popularMovie();
    popTv = tvService.popularTV();
    popMovie.putAll(popTv);
    
    List<Map.Entry<Integer, String>> list = new ArrayList<>(popMovie.entrySet());
    Collections.shuffle(list);

    HashMap<Integer, String> shuffledMap = new LinkedHashMap<>();
    for(Map.Entry<Integer, String> entry : list){
        shuffledMap.put(entry.getKey(), entry.getValue());
    }
    trending = movieService.trending();
    upComing = movieService.upComingMovie();
    cinema = movieService.cinemaMovie();
    avMovie = movieService.averageMovie();
    avTv = tvService.averageTv();
    avMovie.putAll(avTv);
    List<Map.Entry<Integer, String>> list2 = new ArrayList<>(avMovie.entrySet());
    Collections.shuffle(list2);
    HashMap<Integer, String> shuffledMap2 = new LinkedHashMap<>();
    for(Map.Entry<Integer, String> entry : list2){
        shuffledMap2.put(entry.getKey(), entry.getValue());
    }
    //System.out.println("lalala"+shuffledMap2.size());
    ModelAndView mav = new ModelAndView("index.html");
		//RestTemplate restTemplate = new RestTemplate();
        //String grid = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-It&page=1", String.class);
        System.out.println(shuffledMap.size());
        mav.addObject("MovieTv", shuffledMap);
        mav.addObject("trending", trending);
        mav.addObject("upComing", upComing);
        mav.addObject("cinema", cinema);
        mav.addObject("av", shuffledMap2);
        //web client
    
		return mav;
}
}