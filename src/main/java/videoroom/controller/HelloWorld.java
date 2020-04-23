package videoroom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/")
    public String index() {
        System.out.println("Welcome!");
        return "Hello World!";
    }
}
