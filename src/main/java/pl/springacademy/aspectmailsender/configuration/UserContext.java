package pl.springacademy.aspectmailsender.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "example.logged.user.context.data")
public class UserContext {

    private String name;
    private String email;
}
