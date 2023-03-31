package kaisenweb.kaisenweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class SearchResult {
    private Integer id;
    private String title="";
    private String posterPath="";
    private String description="";
    private String release="";
}
