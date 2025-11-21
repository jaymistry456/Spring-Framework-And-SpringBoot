package com.in28minutes.learn_spring_framework.app03.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private GamingConsole game;

    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole gamingConsole) {
        this.game = gamingConsole;
    }

    public void run() {
        this.game.up();
        this.game.down();
        this.game.left();
        this.game.right();
    }
}
