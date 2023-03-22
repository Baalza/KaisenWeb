package kaisenweb.kaisenweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import kaisenweb.kaisenweb.service.SearchService;
import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
public class LoadSearchController {
    private final SearchService searchService;
    
    @GetMapping("/NumRes")
    public String  popolari() {
    
    List <Integer> list = new ArrayList<>();
    list = searchService.searchResults(null);
    
   
    
        
        
		return "json";
}
}
