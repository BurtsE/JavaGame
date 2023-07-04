package main;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class AnimationHandler {
    private int animationTick, animationIndex, animationSpeed = 10;
    private BufferedImage[] idleAnimation;
    private BufferedImage[] walkingAnimation;

    public void rotatePlayer() {
        for (int i = 0; i < walkingAnimation.length; i++) {
            BufferedImage image = walkingAnimation[i];
            int width = image.getWidth();
            int height = image.getHeight();
            //BufferedImage for mirror image
            BufferedImage res = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            //create mirror image pixel by pixel
            for(int y = 0; y < height; y++){
                for(int lx = 0, rx = width - 1; lx < width; lx++, rx--){
                    int p = image.getRGB(lx, y);
                    res.setRGB(rx, y, p);
                }
            }
            walkingAnimation[i] = res;
        }
        for (int i = 0; i < idleAnimation.length; i++) {
            BufferedImage image = idleAnimation[i];
            int width = image.getWidth();
            int height = image.getHeight();
            BufferedImage res = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for(int y = 0; y < height; y++){
                for(int lx = 0, rx = width - 1; lx < width; lx++, rx--){
                    int p = image.getRGB(lx, y);
                    res.setRGB(rx, y, p);
                }
            }
            idleAnimation[i] = res;
        }
    }
    public AnimationHandler() {
        idleAnimation = new BufferedImage[4];
        walkingAnimation = new BufferedImage[7];
        createIdleAnimation();
        createWalkAnimation();
    }
    public void createIdleAnimation() {
        try (InputStream idle =  getClass().getResourceAsStream("/Idle_KG_1.png")){
            BufferedImage idleImg = ImageIO.read(idle);
            for (int i = 0; i < idleAnimation.length; i++) {
                idleAnimation[i] = idleImg.getSubimage(i*100, 0, 100, 64);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void createWalkAnimation() {
        try (InputStream is =  getClass().getResourceAsStream("/Walking_KG_1.png"))
        {
            BufferedImage walkImg = ImageIO.read(is);
            for (int i = 0; i < walkingAnimation.length; i++) {
                walkingAnimation[i] = walkImg.getSubimage(i*100, 0, 100, 64);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private BufferedImage getIdle() {
        return idleAnimation[animationIndex%4];
    }
    private BufferedImage getWalk() {
        return walkingAnimation[animationIndex%5];
    }

    public BufferedImage animate(int action) {
        return switch (action) {
            case 1 -> getIdle();
            case 2 -> getWalk();
            default -> getIdle();
        };
    }
    public void updateAnimationTick() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
        }
        if (animationIndex == (idleAnimation.length-1) * (walkingAnimation.length)-1) {
            animationIndex = 0;
        }
    }
}
