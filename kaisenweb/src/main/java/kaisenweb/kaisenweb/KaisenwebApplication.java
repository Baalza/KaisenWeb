package kaisenweb.kaisenweb;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KaisenwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaisenwebApplication.class, args);
	}

}
