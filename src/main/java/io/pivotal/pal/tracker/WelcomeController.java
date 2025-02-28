package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String _welcomeMessage;

    public WelcomeController(@Value("${welcome.message}") String message){
        _welcomeMessage = message;
    }

    @GetMapping("/")
    public String sayHello() {
        return _welcomeMessage;
    }
}
