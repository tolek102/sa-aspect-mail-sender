package pl.springacademy.aspectmailsender.service;

import org.springframework.stereotype.Service;

import pl.springacademy.aspectmailsender.model.Movie;

@Service
public class MailSenderService {

    public void sendNotificationEmail(final Movie movie) {
        System.out.println("MailSenderService");
        System.out.println("movie = " + movie);
    }
}
