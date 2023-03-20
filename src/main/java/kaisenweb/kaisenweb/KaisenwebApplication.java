package kaisenweb.kaisenweb;




import kaisenweb.kaisenweb.config.KaisenConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;


@SpringBootApplication
@EnableConfigurationProperties(KaisenConfigProperties.class)


public class KaisenwebApplication {
	
	public static void main(String[] args) { SpringApplication.run(KaisenwebApplication.class, args);
		
	}
		

	

}

