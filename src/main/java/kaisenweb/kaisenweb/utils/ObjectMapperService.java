package kaisenweb.kaisenweb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ObjectMapperService {

    ObjectMapper mapper;

    public ObjectMapperService() {
        this.mapper = new ObjectMapper();
    }

    public <T> String getJsonFromObject(T object) {
        String json;
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            json = "{}";
        }
        return json;
    }
}
