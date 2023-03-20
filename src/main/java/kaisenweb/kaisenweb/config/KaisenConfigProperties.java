package kaisenweb.kaisenweb.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Value
@Slf4j
@AllArgsConstructor
@ConfigurationProperties("themoviedb")
public class KaisenConfigProperties{
    String apiUrl;
    String apiVersion;
    String apiKey;
    String region;
    String language;
}