package com.in28minutes.learn_spring_framework.app02;

import com.in28minutes.learn_spring_framework.app02.game.*;
import org.springframework.context.annotation.Bean;

public class GameConfiguration {
    @Bean
    public GamingConsole marioGame() {
        return new MarioGame();
    }

    @Bean
    public GamingConsole superContraGame() {
        return new SuperContraGame();
    }

    @Bean
    public GamingConsole pacmanGame() {
        return new PacmanGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole pacmanGame) {
        return new GameRunner(pacmanGame);
    }
}
