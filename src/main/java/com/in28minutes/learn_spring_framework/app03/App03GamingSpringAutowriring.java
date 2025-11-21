package com.in28minutes.learn_spring_framework.app03;

import com.in28minutes.learn_spring_framework.app03.game.GameRunner;
import com.in28minutes.learn_spring_framework.app03.game.GamingConsole;
import com.in28minutes.learn_spring_framework.app03.game.MarioGame;
import com.in28minutes.learn_spring_framework.app03.game.PacmanGame;
import com.in28minutes.learn_spring_framework.app03.game.SuperContraGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.app03.game")
public class App03GamingSpringAutowriring {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App03GamingSpringAutowriring.class)) {
            GameRunner game = (GameRunner) context.getBean("gameRunner");
            game.run();
        }
    }
}
