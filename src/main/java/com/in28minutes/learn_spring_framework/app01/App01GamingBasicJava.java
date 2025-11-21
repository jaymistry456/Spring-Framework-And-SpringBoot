package com.in28minutes.learn_spring_framework.app01;

import com.in28minutes.learn_spring_framework.app01.game.GameRunner;
import com.in28minutes.learn_spring_framework.app01.game.MarioGame;
import com.in28minutes.learn_spring_framework.app01.game.PacmanGame;
import com.in28minutes.learn_spring_framework.app01.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main (String[] args) {
        MarioGame marioGame = new MarioGame();
        SuperContraGame superContraGame = new SuperContraGame();
        PacmanGame pacmanGame = new PacmanGame();
        GameRunner game = new GameRunner(pacmanGame);
        game.run();
    }
}
