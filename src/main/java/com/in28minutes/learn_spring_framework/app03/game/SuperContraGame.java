package com.in28minutes.learn_spring_framework.app03.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {
    public void up() {
        System.out.println("Up up");
    }

    public void down() {
        System.out.println("Down down");
    }

    public void left() {
        System.out.println("Left left");
    }

    public void right() {
        System.out.println("Right right");
    }
}
