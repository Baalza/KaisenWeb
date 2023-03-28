package kaisenweb.kaisenweb.controller;

import kaisenweb.kaisenweb.utils.ObjectMapperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kaisenweb.kaisenweb.service.TvService;
import lombok.AllArgsConstructor;
import kaisenweb.kaisenweb.model.BackMapper;
import kaisenweb.kaisenweb.model.Movie;
import kaisenweb.kaisenweb.model.MovieMapper;
import kaisenweb.kaisenweb.model.TrailerMapper;
import kaisenweb.kaisenweb.service.MovieService;
import java.util.*;

@RestController
@AllArgsConstructor
public class LoadController {
    private final MovieService movieService;
    private final TvService tvService;
    private final ObjectMapperService objectMapperService;

    @GetMapping("/Popolari")
    public String popolari() {
        List<MovieMapper> popMovie = movieService.popularMovie();
        List<MovieMapper> popTv = tvService.popularTV();
        popMovie.addAll(popTv);
        Collections.shuffle(popMovie);
        return objectMapperService.getJsonFromObject(popMovie);
    }

    @GetMapping("/Trendingt")
    public String trendingT() {
        List<MovieMapper> trendingTodayMovie = movieService.trendingTodayMovie();
        List<MovieMapper> trendingTodayTv = tvService.trendingTodayTv();
        trendingTodayMovie.addAll(trendingTodayTv);
        Collections.shuffle(trendingTodayMovie);
        return objectMapperService.getJsonFromObject(trendingTodayMovie);
    }

    @GetMapping("/Trending")
    public String trendingWeek() {
        List<MovieMapper> trendingWeekMovie = movieService.trendingWeekMovie();
        List<MovieMapper> trendingWeekTv = tvService.trendingWeekTv();
        trendingWeekMovie.addAll(trendingWeekTv);
        Collections.shuffle(trendingWeekMovie);
        return objectMapperService.getJsonFromObject(trendingWeekMovie);
    }

    @GetMapping("/Upcoming")
    public String upComing() {
        List<MovieMapper> upComing = movieService.upComingMovie();
        return objectMapperService.getJsonFromObject(upComing);
    }

    @GetMapping("/Cinema")
    public String Cinema() {
        List<MovieMapper> cinemaMovies = movieService.cinemaMovie();
        return objectMapperService.getJsonFromObject(cinemaMovies);
    }

    @GetMapping("/Av")
    public String average() {
        List<MovieMapper> topRatedMovies = movieService.topRatedMovies();
        List<MovieMapper> topRatedTvSeries = tvService.averageTv();
        topRatedMovies.addAll(topRatedTvSeries);
        Collections.shuffle(topRatedMovies);
        return objectMapperService.getJsonFromObject(topRatedMovies);
    }


    @GetMapping("/Trailerinarrivo")
    public String arrivo() {

        List<TrailerMapper> trailerMapper = new ArrayList<>();
        List<Movie> usciteTrailer = new ArrayList<>();
        usciteTrailer = movieService.upComingTrailer();

        for (Movie movie : usciteTrailer) {
            trailerMapper.add(new TrailerMapper(movie.getId(), movie.getTitle(), movie.getBackdropPath(), movie.getTrailer()));

        }


        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(trailerMapper);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;
    }

    @GetMapping("/Trailercinema")
    public String cinema() {

        List<TrailerMapper> trailerMapper = new ArrayList<>();
        List<Movie> usciteTrailer = new ArrayList<>();
        usciteTrailer = movieService.cinemaTrailer();

        for (Movie movie : usciteTrailer) {
            trailerMapper.add(new TrailerMapper(movie.getId(), movie.getTitle(), movie.getBackdropPath(), movie.getTrailer()));

        }


        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(trailerMapper);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;
    }

    @GetMapping("/Trailerpopolari")
    public String pop() {

        List<TrailerMapper> trailerMapper = new ArrayList<>();
        List<Movie> usciteTrailer = new ArrayList<>();
        usciteTrailer = movieService.popolariTrailer();

        for (Movie movie : usciteTrailer) {
            trailerMapper.add(new TrailerMapper(movie.getId(), movie.getTitle(), movie.getBackdropPath(), movie.getTrailer()));

        }


        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(trailerMapper);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;
    }

    @GetMapping("/Backdrop")
    public String BackDrop() {
        List<BackMapper> movieMapper = new ArrayList<>();
        List<String> back = movieService.trendingBack();
        for (String str : back)
            movieMapper.add(new BackMapper(str));

        return objectMapperService.getJsonFromObject(movieMapper);
    }
}