package pl.springacademy.aspectmailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SaAspectMailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaAspectMailSenderApplication.class, args);
    }
}
