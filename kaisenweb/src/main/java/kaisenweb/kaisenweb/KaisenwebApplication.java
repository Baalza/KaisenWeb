package kaisenweb.kaisenweb;

import kaisenweb.kaisenweb.config.KaisenConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(KaisenConfigProperties.class)
public class KaisenwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaisenwebApplication.class, args);
		/*
		RestTemplate restTemplate = new RestTemplate();
        
        String grid = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=dfcc7abe68d35aa410d4654be1b250b4&language=it-It&page=1", String.class);
        //System.out.println(grid.trim());
		
        JsonObject data = new Gson().fromJson(grid.trim(), JsonObject.class);
		JsonArray temp = data .get("results").getAsJsonArray();
		ArrayList<String> test = new ArrayList<String>();
		for(JsonElement element : temp){
            JsonObject object = element.getAsJsonObject();
            String main = object.getAsJsonObject().get("id").getAsString();
            test.add(main);
        }
		test.stream().forEach(System.out::println);*/
	}

}
