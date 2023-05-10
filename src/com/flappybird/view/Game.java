package com.flappybird.view;
import com.flappybird.controller.Controller;
import com.flappybird.model.Cat;
import com.flappybird.model.Tube;
import com.flappybird.model.TubeColumn;
import com.flappybird.model.proxy.LowResolutionPic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;//package com.flappybird.view;//package com.flappybird.view;
//
//import com.flappybird.controller.Controller;
//import com.flappybird.model.Cat;
//import com.flappybird.model.Tube;
//import com.flappybird.model.TubeColumn;
//import com.flappybird.model.proxy.LowResolutionPic;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//public class Game extends JPanel implements ActionListener {
//
//    private boolean isRunning = false;
//    private LowResolutionPic proxyImage;
//    private Image background;
//    private Cat cat;
//    private TubeColumn tubeColumn;
//    private int score;
//    private int highScore;
//    private JButton startButton;
//
//    private boolean gameOver = false;
//    private JButton restartButton;
//    private JButton exitButton;
//
//    public Game() {
//        proxyImage = new LowResolutionPic("/assets/background.png");
//        background = proxyImage.loadImage().getImage();
//        setFocusable(true);
//        setDoubleBuffered(false);
//        addKeyListener(new GameKeyAdapter());
//        Timer timer = new Timer(15, this);
//        timer.start();
//        createStartButton();
//    }
//
//    private void createStartButton() {
//        startButton = new JButton("Start Game");
//        startButton.setFont(new Font("Arial", Font.BOLD, 20));
//        startButton.setBounds(GameFrame.WIDTH / 2 - 100, GameFrame.HEIGHT / 2 - 25, 200, 50);
//        startButton.addActionListener(this);
//        add(startButton);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == startButton) {
//            startGame();
//        } else if (e.getSource() == restartButton) {
//            restartGame();
//        } else {
//            Toolkit.getDefaultToolkit().sync();
//            if (isRunning) {
//                cat.tick();
//                tubeColumn.tick();
//                checkCollision();
//                score++;
//            }
//            repaint();
//        }
//    }
//
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
//        g2.drawImage(background, 0, 0, null);
//        if (isRunning) {
//            cat.render(g2, this);
//            tubeColumn.render(g2, this);
//            g2.setColor(Color.black);
//            g2.setFont(new Font("Arial", Font.BOLD, 20));
//            g2.drawString("Your score: " + tubeColumn.getPoints(), 10, 20);
//        } else {
//            if (gameOver) {
//                g2.setColor(Color.black);
//                g2.setFont(new Font("Arial", Font.BOLD, 40));
//                g2.drawString("Game Over", GameFrame.WIDTH / 2 - 100, GameFrame.HEIGHT / 2);
//                g2.setColor(Color.black);
//                g2.setFont(new Font("Arial", Font.BOLD, 20));
//                g2.drawString("Press Enter to Restart", GameFrame.WIDTH / 2 - 120, GameFrame.HEIGHT / 2 + 40);
//
//                restartButton = new JButton("Restart");
//                restartButton.setFont(new Font("Arial", Font.BOLD, 16));
//                restartButton.setBounds(GameFrame.WIDTH / 2 - 70, GameFrame.HEIGHT / 2 + 80, 140, 30);
//                restartButton.addActionListener(this);
//                add(restartButton);
//                restartButton.setVisible(true);
//
//                exitButton = new JButton("Exit");
//                exitButton.setFont(new Font("Arial", Font.BOLD, 16));
//                exitButton.setBounds(GameFrame.WIDTH / 2 - 70, GameFrame.HEIGHT / 2 + 120, 140, 30);
//                exitButton.addActionListener(new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        System.exit(0);
//                    }
//                });
//                add(exitButton);
//            } else {
//                g2.setColor(Color.black);
//                g2.setFont(new Font("Arial", Font.BOLD, 20));
//                g2.drawString("Press Enter to Start the Game", GameFrame.WIDTH / 2 - 150, GameFrame.HEIGHT / 2);
//                g2.setColor(Color.black);
//                g2.setFont(new Font("Arial", Font.BOLD, 15));
//                g2.drawString("by Powerpuff Girls", GameFrame.WIDTH - 200, GameFrame.HEIGHT - 50);
//            }
//        }
//        g2.setColor(Color.black);
//        g2.setFont(new Font("Arial", Font.BOLD, 20));
//        g2.drawString("High Score: " + highScore, GameFrame.WIDTH - 160, 20);
//    }
//        private void startGame () {
//            if (!isRunning) {
//                isRunning = true;
//                gameOver = false; // Reset game over state
//                cat = new Cat(GameFrame.WIDTH / 2, GameFrame.HEIGHT / 2);
//                tubeColumn = new TubeColumn();
//                remove(startButton); // Remove the start button from the panel
//                repaint(); // Redraw the panel without the start button
//            }
//        }
//
//    private void restartGame() {
//        if (gameOver) {
//            isRunning = true;
//            gameOver = false;
//            remove(restartButton);
//            remove(exitButton);
//            revalidate();
//            repaint();
//            startGame();
//        }
//    }
//
//    private void endGame() {
//            isRunning = false;
//            gameOver = true;
//            if (tubeColumn.getPoints() > highScore) {
//                highScore = tubeColumn.getPoints();
//            }
//            tubeColumn.setPoints(0);
//        }
//
//        private void checkCollision() {
//            Rectangle rectCat = cat.getBounds();
//            Rectangle rectTube;
//
//            for (int i = 0; i < tubeColumn.getTubes().size(); i++) {
//                Tube tempTube = tubeColumn.getTubes().get(i);
//                rectTube = tempTube.getBounds();
//                if (rectCat.intersects(rectTube)) {
//                    endGame();
//                }
//            }
//        }
//
//        private class GameKeyAdapter extends KeyAdapter {
//            private final Controller controller;
//
//            public GameKeyAdapter() {
//                controller = new Controller();
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                    if (gameOver) {
//                        restartGame();
//                    } else {
//                        startGame();
//                    }
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if (isRunning) {
//                    controller.controllerReleased(cat, e);
//                }
//            }
//        }
//
//}

import com.flappybird.controller.Controller;
import com.flappybird.model.Cat;
import com.flappybird.model.Tube;
import com.flappybird.model.TubeColumn;
import com.flappybird.model.proxy.LowResolutionPic;
import com.flappybird.view.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//public class Game extends JPanel implements ActionListener {
//
//    private boolean isRunning = false;
//    private LowResolutionPic proxyImage;
//    private Image background;
//    private Cat cat;
//    private TubeColumn tubeColumn;
//    private int score;
//    private int highScore;
//    private JButton startButton;
//
//    private boolean gameOver = false;
//    private JButton restartButton;
//    private JButton exitButton;
//
//    public Game() {
//        proxyImage = new LowResolutionPic("/assets/background.png");
//        background = proxyImage.loadImage().getImage();
//        setFocusable(true);
//        setDoubleBuffered(false);
//        addKeyListener(new GameKeyAdapter());
//        Timer timer = new Timer(15, this);
//        timer.start();
//        createStartButton();
//        createRestartButton();
//    }
//
//    private void createStartButton() {
//        startButton =  new JButton("Start Game");
//        startButton.setFont(new Font("Arial", Font.BOLD, 20));
//        startButton.setBounds(GameFrame.WIDTH / 2 - 100, GameFrame.HEIGHT / 2 - 25, 200, 50);
//        startButton.addActionListener(this);
//        add(startButton);
//    }
//
//    private void createRestartButton() {
//        restartButton = new JButton("Restart");
//        restartButton.setFont(new Font("Arial", Font.BOLD, 16));
//        restartButton.setBounds(GameFrame.WIDTH / 2 - 70, GameFrame.HEIGHT / 2 + 80, 140, 30);
//        restartButton.addActionListener(this);
//        restartButton.setVisible(false);
//        add(restartButton);
//    }
//
//    private void createExitButton() {
//        exitButton = new JButton("Exit");
//        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
//        exitButton.setBounds(GameFrame.WIDTH / 2 - 70, GameFrame.HEIGHT / 2 + 120, 140, 30);
//        exitButton.addActionListener(this);
//        exitButton.setVisible(false);
//        add(exitButton);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == startButton) {
//            startGame();
//        } else if (e.getSource() == restartButton) {
//            restartGame();
//        } else {
//            Toolkit.getDefaultToolkit().sync();
//            if (isRunning) {
//                cat.tick();
//                tubeColumn.tick();
//                checkCollision();
//                score++;
//            }
//            repaint();
//        }
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
//        g2.drawImage(background, 0, 0, null);
//        if (isRunning) {
//            cat.render(g2, this);
//            tubeColumn.render(g2, this);
//            g2.setColor(Color.black);
//            g2.setFont(new Font("Arial", Font.BOLD, 20));
//            g2.drawString("Your score: " + tubeColumn.getPoints(), 10, 20);
//        } else {
//            if (gameOver) {
//                g2.setColor(Color.black);
//                g2.setFont(new Font("Arial", Font.BOLD, 40));
//                g2.drawString("Game Over", GameFrame.WIDTH / 2 - 100, GameFrame.HEIGHT / 2);
//                g2.setColor(Color.black);
//                g2.setFont(new Font("Arial", Font.BOLD, 20));
//                g2.drawString("Press Enter to Restart", GameFrame.WIDTH / 2 - 120, GameFrame.HEIGHT / 2 + 40);
//            } else {
//                g2.setColor(Color.black);
//                g2.setFont(new Font("Arial", Font.BOLD, 20));
//                g2.drawString("Press Enter to Start the Game", GameFrame.WIDTH / 2 - 150, GameFrame.HEIGHT / 2);
//                g2.setColor(Color.black);
//                g2.setFont(new Font("Arial", Font.BOLD, 15));
//                g2.drawString("by Powerpuff Girls", GameFrame.WIDTH - 200, GameFrame.HEIGHT - 50);
//            }
//        }
//        g2.setColor(Color.black);
//        g2.setFont(new Font("Arial", Font.BOLD, 20));
//        g2.drawString("High Score: " + highScore, GameFrame.WIDTH - 160, 20);
//    }
//
//    private void startGame() {
//        if (!isRunning) {
//            isRunning = true;
//            gameOver = false; // Reset game over state
//            cat = new Cat(GameFrame.WIDTH / 2, GameFrame.HEIGHT / 2);
//            tubeColumn = new TubeColumn();
//            remove(startButton); // Remove the start button from the panel
//            restartButton.setVisible(false); // Hide the restart button
//            repaint(); // Redraw the panel without the start button
//        }
//    }
//
//    private void restartGame() {
//        startGame();
//        if (gameOver) {
//            isRunning = true;
//            gameOver = false;
//            remove(restartButton);
//            remove(exitButton); // Remove the exit button from the panel
//            revalidate();
//            repaint();
//
//
//            // Add the restart button and exit button to the panel
//            add(restartButton);
//            add(exitButton);
//        }
//    }
//
//
//    private void endGame() {
//        isRunning = false;
//        gameOver = true;
//        if (tubeColumn.getPoints() > highScore) {
//            highScore = tubeColumn.getPoints();
//        }
//        tubeColumn.setPoints(0);
//        restartButton.setVisible(true); // Show the restart button
//    }
//
//    private void checkCollision() {
//        Rectangle rectCat = cat.getBounds();
//        Rectangle rectTube;
//
//        for (int i = 0; i < tubeColumn.getTubes().size(); i++) {
//            Tube tempTube = tubeColumn.getTubes().get(i);
//            rectTube = tempTube.getBounds();
//            if (rectCat.intersects(rectTube)) {
//                endGame();
//            }
//        }
//    }
//
//    private class GameKeyAdapter extends KeyAdapter {
//        private final Controller controller;
//
//        public GameKeyAdapter() {
//            controller = new Controller();
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                if (gameOver) {
//                    restartGame();
//                } else {
//                    startGame();
//                }
//            }
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//            if (isRunning) {
//                controller.controllerReleased(cat, e);
//            }
//        }
//    }
//
//}


import com.flappybird.controller.Controller;
import com.flappybird.model.Cat;
import com.flappybird.model.Tube;
import com.flappybird.model.TubeColumn;
import com.flappybird.model.proxy.LowResolutionPic;
import com.flappybird.view.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel implements ActionListener {

    private boolean isRunning = false;
    private LowResolutionPic proxyImage;
    private Image background;
    private Cat cat;
    private TubeColumn tubeColumn;
    private int score;
    private int highScore;
    private JButton startButton;

    private boolean gameOver = false;
    private JButton restartButton;
    private JButton exitButton;

    public Game() {
        proxyImage = new LowResolutionPic("/assets/bg-crop.png");
        background = proxyImage.loadImage().getImage();
        setFocusable(true);
        setDoubleBuffered(false);
        addKeyListener(new GameKeyAdapter());
        Timer timer = new Timer(15, this);
        timer.start();
        createStartButton();
        createRestartButton();
        createExitButton();
    }

    private void createStartButton() {
        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setBounds(GameFrame.WIDTH / 2 - 100, GameFrame.HEIGHT / 2 - 25, 200, 50);
        startButton.addActionListener(this);
        add(startButton);
    }

    private void createRestartButton() {
        restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.BOLD, 16));
        restartButton.setBounds(GameFrame.WIDTH / 2 - 70, GameFrame.HEIGHT / 2 + 80, 140, 30);
        restartButton.addActionListener(this);
        restartButton.setVisible(false);
        add(restartButton);
    }

    private void createExitButton() {
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setBounds(GameFrame.WIDTH / 2 - 70, GameFrame.HEIGHT / 2 + 120, 140, 30);
        exitButton.addActionListener(this);
        exitButton.setVisible(false);
        add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startGame();
        } else if (e.getSource() == restartButton) {
            restartGame();
        } else if (e.getSource() == exitButton) {
            exitGame();
        } else {
            Toolkit.getDefaultToolkit().sync();
            if (isRunning) {
                cat.tick();
                tubeColumn.tick();
                checkCollision();
                score++;
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background, 0, 0, null);
        if (isRunning) {
            cat.render(g2, this);
            tubeColumn.render(g2, this);
            g2.setColor(Color.black);
            g2.setFont(new Font("Arial", Font.BOLD, 20));
            g2.drawString("Your score: " + tubeColumn.getPoints(), 10, 20);
        } else {
            if (gameOver) {
                g2.setColor(Color.black);
                g2.setFont(new Font("Arial", Font.BOLD, 40));
                g2.drawString("Game Over", GameFrame.WIDTH / 2 - 100, GameFrame.HEIGHT / 2);
                g2.setColor(Color.black);
                g2.setFont(new Font("Arial", Font.BOLD, 20));
                g2.drawString("Press Enter to Restart", GameFrame.WIDTH / 2 - 120, GameFrame.HEIGHT / 2 + 40);
                restartButton.setVisible(true); // Show the restart button
                exitButton.setVisible(true); // Show the exit button
            } else {
                g2.setColor(Color.black);
                g2.setFont(new Font("Arial", Font.BOLD, 20));
                g2.drawString("Press Enter to Start the Game", GameFrame.WIDTH / 2 - 150, GameFrame.HEIGHT / 2);
                g2.setColor(Color.black);
                g2.setFont(new Font("Arial", Font.BOLD, 15));
                g2.drawString("by Powerpuff Girls", GameFrame.WIDTH - 200, GameFrame.HEIGHT - 50);
            }
        }
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("High Score: " + highScore, GameFrame.WIDTH - 160, 20);
    }

    private void startGame() {
        if (!isRunning) {
            isRunning = true;
            gameOver = false; // Reset game over state
            cat = new Cat(GameFrame.WIDTH / 2, GameFrame.HEIGHT / 2);
            tubeColumn = new TubeColumn();
            remove(startButton); // Remove the start button from the panel
            restartButton.setVisible(false); // Hide the restart button
            exitButton.setVisible(false); // Hide the exit button
            repaint(); // Redraw the panel without the start button
        }
    }

    private void restartGame() {
        startGame();
    }

    private void exitGame() {
        System.exit(0);
    }

    private void endGame() {
        isRunning = false;
        gameOver = true;
        if (tubeColumn.getPoints() > highScore) {
            highScore = tubeColumn.getPoints();
        }
        tubeColumn.setPoints(0);
    }

    private void checkCollision() {
        Rectangle rectCat = cat.getBounds();
        Rectangle rectTube;

        for (int i = 0; i < tubeColumn.getTubes().size(); i++) {
            Tube tempTube = tubeColumn.getTubes().get(i);
            rectTube = tempTube.getBounds();
            if (rectCat.intersects(rectTube)) {
                endGame();
            }
        }
    }

    private class GameKeyAdapter extends KeyAdapter {
        private final Controller controller;

        public GameKeyAdapter() {
            controller = new Controller();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (gameOver) {
                    restartGame();
                } else {
                    startGame();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (isRunning) {
                controller.controllerReleased(cat, e);
            }
        }
    }
}





