package game.components;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JComponent {

    private ImageIcon background = new ImageIcon("assets/background.png");

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, this);
    }
}
