package kaisenweb.kaisenweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kaisenweb.kaisenweb.service.SearchService;
import lombok.AllArgsConstructor;
@Controller
@AllArgsConstructor
public class MovieDetailsController {
    
    @GetMapping("/movie/{id}")
    @ResponseBody
        public  ModelAndView searchMovie() {//@RequestParam("query") String query
        ModelAndView mav = new ModelAndView("movieDetails.html");
       
        return mav;
        }
    }