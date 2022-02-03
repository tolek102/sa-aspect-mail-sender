package pl.springacademy.aspectmailsender.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.springacademy.aspectmailsender.configuration.UserContext;
import pl.springacademy.aspectmailsender.model.Movie;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailSenderService {

    @Value("${spring.mail.username}")
    private String mailServerUsername;

    private final UserContext userContext;

    private final JavaMailSender emailSender;

    public void sendNotificationEmail(final Movie movie) {

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailServerUsername);
        message.setTo(userContext.getEmail());
        message.setSubject("You just added new movie");
        final String mailMessage = String.format("Hi %s.\nMovie that You just added to service is: %s", userContext.getName(), movie);
        message.setText(mailMessage);
        emailSender.send(message);
    }
}
