package kaisenweb.kaisenweb.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class Movie {
    private Integer id;
    private String originalTitle;
    private String title="";
    private String posterPath;
    private String backdropPath="";
    private String tagline;
    private Long budget;
    private String releaseDate;
    private String overview;
    private String category;
    private Integer runtime;
    private String name;
    private boolean adult;
    private String originalLanguage;
    private Set<Genre> genres;
    private Long revenue;
    private String status;
    private MovieCollection collection;
    private Set<String> productionCountries;
    private Set<Provider> providers;
    private String trailer="";



}
