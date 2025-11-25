package com.in28minutes.learn_spring_framework.app04.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @RequestMapping("/login")
//    public String login(@RequestParam String name, ModelMap model) {
//        logger.debug("The Request param is {}", name);
//        model.put("name", name);
//        return "login";
//    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }
}
