package pl.springacademy.aspectmailsender.aspect;

import java.util.Optional;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import pl.springacademy.aspectmailsender.model.Movie;
import pl.springacademy.aspectmailsender.service.MailSenderService;

@Aspect
@Configuration
@RequiredArgsConstructor
public class MailNotificationAspect {

    private final MailSenderService mailSenderService;

    @AfterReturning(value = "@annotation(pl.springacademy.aspectmailsender.aspect.MailNotification)", returning = "newMovie")
    public void sendMail(final Optional<Movie> newMovie){
        mailSenderService.sendNotificationEmail(newMovie.get());
    }
}
