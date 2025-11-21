package com.in28minutes.learn_spring_framework.app02;

import com.in28minutes.learn_spring_framework.app02.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02GamingSpringBeans {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GameConfiguration.class)) {
//            MarioGame marioGame = (MarioGame) context.getBean("marioGame");
//            SuperContraGame superContraGame = (SuperContraGame) context.getBean("superContraGame");
//            PacmanGame pacmanGame = (PacmanGame) context.getBean("pacmanGame");
            GameRunner game = (GameRunner) context.getBean("gameRunner");
            game.run();
        }
    }
}
