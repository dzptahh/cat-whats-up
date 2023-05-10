package com.flappybird.model;

import com.flappybird.model.proxy.LowResolutionPic;
import com.flappybird.view.GameFrame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

//public class Cat extends GameObject {
//
//    private LowResolutionPic lowResolutionPic;
//
//    private Tube[] tube;
//    public Cat(int x, int y){
//        super(x, y);
//        if(lowResolutionPic == null) {
//            lowResolutionPic = new LowResolutionPic("/assets/bird.gif");
//        }
//        this.image = lowResolutionPic.loadImage().getImage();
//        this.width = image.getWidth(null);
//        this.height = image.getHeight(null);
//        this.x -= width;
//        this.y -= height;
//        tube = new Tube[1];
//        tube[0] = new Tube(900, Window.HEIGHT - 60);
//        this.dy = 4;
//    }
//    @Override
//    public void tick() {
//        if(dy < 5) {
//            dy += 2;
//        }
//        this.y += dy;
//        tube[0].tick();
//        checkBorder();
//    }
//    public void jump() {
//        if(dy > 0) {
//            dy = 0;
//        }
//        dy -= 15;
//    }
//
//    private void checkBorder() {
//        if(this.x > Window.WIDTH) {
//            this.x = Window.WIDTH;
//        }
//        if(this.x < 0) {
//            this.x = 0;
//        }
//        if(this.y > Window.HEIGHT - 50) {
//            this.y = Window.HEIGHT - 50;
//        }
//        if(this.y < 0) {
//            this.y = 0;
//        }
//    }
//
//    @Override
//    public void render(Graphics2D g, ImageObserver obs) {
//        g.drawImage(image, x, y, obs);
//        tube[0].render(g, obs);
//    }
//
//
//    public Rectangle getBounds() {
//        return new Rectangle(x, y, width, height);
//    }
//}

public class Cat extends GameObject {

    private Tube[] tubes;
    private LowResolutionPic lowResolutionPic;

    public Cat(int x, int y) {
        super(x, y);
        lowResolutionPic = new LowResolutionPic("/assets/bird.gif");
        this.image = lowResolutionPic.loadImage().getImage();

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);

        this.x -= width;
        this.y -= height;
        this.dy = 5;
        createTheTubes();
    }

    private void createTheTubes() {
        tubes = new Tube[1];
        tubes[0] = new Tube(900, GameFrame.HEIGHT - 60);
    }

    @Override
    public void tick() {
        if (dy < 5) {
            dy += 2;
        }
        this.y += dy;
        tubes[0].tick();
        checkBorder();
    }

    public void jump() {
        if (dy > 0) {
            dy = 0;
        }
        dy -= 15;
    }

    private void checkBorder() {

        if (this.y > GameFrame.HEIGHT - 50) {
            this.y = GameFrame.HEIGHT - 50;
        } else if (this.y < 0) {
            this.y = 0;
        }

        if (this.x > GameFrame.WIDTH) {
            this.x = GameFrame.WIDTH;
        } else if (this.x < 0) {
            this.x = 0;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void render(Graphics2D g, ImageObserver obs) {
        g.drawImage(image, x, y, obs);
        tubes[0].render(g, obs);
    }

}
