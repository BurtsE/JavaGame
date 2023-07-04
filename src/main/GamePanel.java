package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float x = 50, y = 50;
    private AnimationHandler animationHandler;

    public GamePanel() {
        animationHandler = new AnimationHandler();
        setPanelSize();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }


    public void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }
    public void changeX(int value) {
        x += value;
    }
    public void changeY(int value) {
        y += value;
    }
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        animationHandler.updateAnimationTick();
        g.drawImage(animationHandler.getIdle(), (int)x, (int)y, null);
    }



    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        super.processComponentKeyEvent(e);
        //  System.out.println("repaint");
    }
}
