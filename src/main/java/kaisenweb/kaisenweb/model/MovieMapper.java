package kaisenweb.kaisenweb.model;

import kaisenweb.kaisenweb.utils.Type;

public record MovieMapper(
        Integer id,
        String poster_path,
        Type type) {
    
}
