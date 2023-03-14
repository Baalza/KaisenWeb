package kaisenweb.kaisenweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class KaisenwebApplication {//foo

	public static void main(String[] args) {
		SpringApplication.run(KaisenwebApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "index";
	}

}
