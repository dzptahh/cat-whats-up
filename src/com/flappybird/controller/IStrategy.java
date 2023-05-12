package com.flappybird.controller;

import com.flappybird.model.Cat;
import java.awt.event.KeyEvent;

public interface IStrategy {

    public void controller(Cat bird, KeyEvent kevent);
    public void controllerReleased(Cat bird, KeyEvent kevent);
}
