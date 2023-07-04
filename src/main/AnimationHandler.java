package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class AnimationHandler {
    private int animationTick, animationIndex, animationSpeed = 30;
    private BufferedImage[] idleAnimation;
    private BufferedImage[] walkingAnimation;

    public AnimationHandler() {
        idleAnimation = new BufferedImage[4];
        walkingAnimation = new BufferedImage[5];
        createIdleAnimation();
        createWalkAnimation();
    }
    public void createIdleAnimation() {
        try (InputStream idle =  getClass().getResourceAsStream("/Idle_KG_1.png")){
            BufferedImage idleImg = ImageIO.read(idle);
            for (int i = 0; i < idleAnimation.length; i++) {
                idleAnimation[i] = idleImg.getSubimage(30+i*100, 0, 40, 64);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void createWalkAnimation() {
        try (InputStream is =  getClass().getResourceAsStream("/Idle_KG_1.png"))
        {
            BufferedImage walkImg = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getIdle() {
        return idleAnimation[animationIndex%4];
    }
    public BufferedImage getWalk() {
        return walkingAnimation[animationIndex%5];
    }

    public void updateAnimationTick() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
        }
        if (animationIndex == 12) {
            animationIndex = 0;
        }
    }
}
