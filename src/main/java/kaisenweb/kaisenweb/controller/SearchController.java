package kaisenweb.kaisenweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public class SearchController {
    
    @GetMapping("/search")
    @ResponseBody
    public  ModelAndView search(@RequestParam String query) {
        ModelAndView mav = new ModelAndView("search.html");
        System.out.println(query);
        return mav;
        }
}
