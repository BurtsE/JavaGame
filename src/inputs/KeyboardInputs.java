package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
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
                System.out.println("It's w");
                gamePanel.changeY(-5);
                break;
            case KeyEvent.VK_S:
                System.out.println("It's s");
                gamePanel.changeY(5);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeX(-5);
                System.out.println("It's a");
                break;
            case KeyEvent.VK_D:
                gamePanel.changeX(5);
                System.out.println("It's d");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
