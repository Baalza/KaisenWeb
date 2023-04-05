package kaisenweb.kaisenweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kaisenweb.kaisenweb.model.Movie;
import kaisenweb.kaisenweb.model.SearchResult;
import kaisenweb.kaisenweb.model.TotalResultMapper;
import kaisenweb.kaisenweb.service.MovieService;
import kaisenweb.kaisenweb.utils.ObjectMapperService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoadMovieDetailsController {
    private final MovieService movieService;
    private final ObjectMapperService objectMapperService;

    @GetMapping("/movie/details")
    public String  movieDetails(@RequestParam("id") String id) {
        Movie movie = new Movie();
        movie = movieService.movieDetail(id);
    
      
		return objectMapperService.getJsonFromObject(movie);
}
}
