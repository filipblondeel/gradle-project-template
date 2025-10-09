package com.example.web;

import com.example.HelloWorld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    private final HelloWorld helloWorld;

    public HelloWorldController(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @GetMapping
    public String get(Model model) {
        var greeting = helloWorld.sayHelloTo("Filip");

        model.addAttribute("greeting", greeting);
        return "hello-world";
    }
}
