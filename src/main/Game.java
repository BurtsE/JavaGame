package main;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS = 120;
    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        //should be called after window is created
        gamePanel.requestFocusInWindow();
        startGameLoop();


    }
    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.run();
    }
    @Override
    public void run() {
        double timePerFrame = 1_000_000_000.0 / FPS;
        long lastFrame= System.nanoTime();
        long now;
        while(true) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                // without sync animation is lagging
                // https://bugs.openjdk.org/browse/JDK-8178091
                Toolkit.getDefaultToolkit().sync();
                lastFrame = now;
            }
        }
    }
}
