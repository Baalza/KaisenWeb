package kaisenweb.kaisenweb.controller;

import kaisenweb.kaisenweb.config.KaisenConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final KaisenConfigProperties configProperties;

    @Autowired
    public MovieController(KaisenConfigProperties configProperties) {
        this.configProperties = configProperties;
    }


}
