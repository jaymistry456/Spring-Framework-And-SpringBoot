package com.in28minutes.learn_spring_framework.game;

public class GameRunner {
    private GamingConsole game;

    public GameRunner(GamingConsole gamingConsole) {
        this.game = gamingConsole;
    }

    public void run() {
        this.game.up();
        this.game.down();
        this.game.left();
        this.game.right();
    }
}
