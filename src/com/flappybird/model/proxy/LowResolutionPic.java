package com.flappybird.model.proxy;

import javax.swing.ImageIcon;

public class LowResolutionPic implements IImage {

    private final String src;
    private RealImage realImage;
    
    public LowResolutionPic(String src) {
        this.src = src;
    }
    @Override
    public ImageIcon loadImage() {
        if(realImage == null) {
            this.realImage = new RealImage(src);
        }
        
        return this.realImage.loadImage();
    }
    
}
