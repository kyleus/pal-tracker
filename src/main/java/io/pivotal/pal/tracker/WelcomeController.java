package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;

@RestController
public class WelcomeController {

    private final String welcomeMessage;

    public WelcomeController(@Value("${welcome.message:NOT SET}") String message) {
        this.welcomeMessage = message;
    }

    @GetMapping("/")
    public String sayHello() {
        return welcomeMessage;
    }
}
