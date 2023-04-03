package kaisenweb.kaisenweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kaisenweb.kaisenweb.model.SearchResult;
import kaisenweb.kaisenweb.model.TotalResultMapper;
import kaisenweb.kaisenweb.service.SearchService;
import kaisenweb.kaisenweb.utils.ObjectMapperService;
import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
public class LoadSearchController {
    private final SearchService searchService;
    private final ObjectMapperService objectMapperService;
    
    @GetMapping("/NumRes")
    public String  numRes(@RequestParam("query") String query) {
   
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
@GetMapping("/LoadEntity")
    public String  loadEntity(@RequestParam("query") String query,@RequestParam("category") String category,@RequestParam(required=false,name="page") String page) {
        List <SearchResult> list = new ArrayList<>();
        list = searchService.searchEntity(query, category, page);

        System.out.println(list.get(0).getType());
        return objectMapperService.getJsonFromObject(list);
}
}
