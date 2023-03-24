package kaisenweb.kaisenweb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("themoviedb")
public record KaisenConfigProperties(
    String apiUrl,
    String apiVersion,
    String apiKey){
}