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
@RequestMapping("/search")
@AllArgsConstructor
public class SearchingController {
    
    @RequestMapping(value="/movie",params="query")
    //@ResponseBody
        public  ModelAndView searchMovie() {//@RequestParam("query") String query
        ModelAndView mav = new ModelAndView("search.html");
       
        return mav;
        }
        @RequestMapping(value="/tv",params="query")
    //@ResponseBody
        public  ModelAndView searchTv() {//@RequestParam("query") String query
        ModelAndView mav = new ModelAndView("search.html");
       
        return mav;
        }
        @RequestMapping(value="/collection",params="query")
        //@ResponseBody
            public  ModelAndView searchCollection() {//@RequestParam("query") String query
            ModelAndView mav = new ModelAndView("search.html");
           
            return mav;
            }
        
     
}
