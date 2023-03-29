package kaisenweb.kaisenweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kaisenweb.kaisenweb.model.TotalResultMapper;
import kaisenweb.kaisenweb.service.SearchService;
import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
public class LoadSearchController {
    private final SearchService searchService;
    
    @GetMapping("/NumRes")
    public String  numRes(@RequestParam("query") String query) {
   System.out.println("query "+query);
    List <Integer> list = new ArrayList<>();
    list.add(Integer.parseInt(searchService.searchResults(query, "movie")));
    list.add(Integer.parseInt(searchService.searchResults(query, "tv")));
    list.add(Integer.parseInt(searchService.searchResults(query, "collection")));
    TotalResultMapper totalResultMapper = new TotalResultMapper(list.get(0),list.get(1),list.get(2));
    
      ObjectMapper mapper = new ObjectMapper();
      String json = "";
      try {
          json = mapper.writeValueAsString(totalResultMapper);
      } catch (JsonProcessingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
      
		return json;
}
@GetMapping("/NumPage")
    public String  numPage(@RequestParam("query") String query) {
   System.out.println("query "+query);
    List <Integer> list = new ArrayList<>();
    list.add(Integer.parseInt(searchService.searchPage(query, "movie")));
    list.add(Integer.parseInt(searchService.searchPage(query, "tv")));
    list.add(Integer.parseInt(searchService.searchPage(query, "collection")));
    TotalResultMapper totalResultMapper = new TotalResultMapper(list.get(0),list.get(1),list.get(2));
    
      ObjectMapper mapper = new ObjectMapper();
      String json = "";
      try {
          json = mapper.writeValueAsString(totalResultMapper);
      } catch (JsonProcessingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
      
		return json;
}
}
