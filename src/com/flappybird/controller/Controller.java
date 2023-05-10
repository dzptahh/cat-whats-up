package com.flappybird.controller;

import com.flappybird.model.Cat;
import java.awt.event.KeyEvent;

public class Controller implements IStrategy {

    @Override
    public void controller(Cat bird, KeyEvent kevent) {
    }

    @Override
    public void controllerReleased(Cat bird, KeyEvent kevent) {
        if(kevent.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.jump();
        }
    }
}
