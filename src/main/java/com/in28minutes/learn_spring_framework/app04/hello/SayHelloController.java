package com.in28minutes.learn_spring_framework.app04.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJSP() {
        return "sayHelloJSP";
    }
}
