package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 0.01f, yDir = 0.01f;
    private int frames = 0;
    private long lastCheck = 0;
    private Font buttonFont;
    private Font regularFont;
    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void changeXDelta(int value) {
        this.xDelta += value;

    }
    public void changeYDelta(int value) {
        this.yDelta += value;

    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        frames++;

        if (System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS " + frames);
            frames = 0;
        }
        updateRectangle();

        g.fillRect((int)xDelta,(int)yDelta,100,100);

        g.drawRect((int)xDelta,(int)yDelta,300,300);

        repaint();
        // этот квадрат будет текстом и будет бегать за курсором
        // и соединяться с другим текстом в бэкграунде!!!


    }

    private void updateRectangle() {
        xDelta += xDir;
        if (xDelta > 1328 || xDelta < 0) xDir *= -1;
        yDelta += yDir;
        if (yDelta > 628  || yDelta < 0) yDir *= -1;
    }
}
