package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    private final int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;
    private final int movingSpeed = 10;
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamePanel.changeY(-5);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeY(5);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeX(-5);
                gamePanel.updateAction(2);
                gamePanel.setPlayerDirection(LEFT);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeX(5);
                gamePanel.updateAction(2);
                gamePanel.setPlayerDirection(RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamePanel.changeY(-movingSpeed);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeY(movingSpeed);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeX(-movingSpeed);
                gamePanel.updateAction(1);
                System.out.println("It's a");
                break;
            case KeyEvent.VK_D:
                gamePanel.changeX(movingSpeed);
                gamePanel.updateAction(1);
                System.out.println("It's d");
                break;
        }
    }
}
