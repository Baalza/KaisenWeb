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
import kaisenweb.kaisenweb.service.MovieService;

@Controller
@AllArgsConstructor
public class HomeController {
private final MovieService movieService;
private final TvService tvService;

     @GetMapping("/")
    public String loadpage(){
        return "index";
    }
   
}