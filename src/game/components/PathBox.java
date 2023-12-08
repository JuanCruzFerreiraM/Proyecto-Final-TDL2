package game.components;

import javax.swing.*;
import java.awt.*;

public class PathBox {
    private Monster monster;
    private PathBox southBox;
    private PathBox northBox;
    private String name;
    private JButton buttonUI;

    public PathBox(JButton buttonUI, String name) {
        this.buttonUI = buttonUI;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public JButton getButtonUI() {
        return buttonUI;
    }

    public void setButtonUI(JButton buttonUI) {
        this.buttonUI = buttonUI;
    }

    public PathBox getSouthBox() {
        return southBox;
    }

    public void setSouthBox(PathBox southBox) {
        this.southBox = southBox;
    }

    public PathBox getNorthBox() {
        return northBox;
    }

    public void setNorthBox(PathBox northBox) {
        this.northBox = northBox;
    }

    public void update() {
        if(this.monster != null) {
            buttonUI.setVisible(true);
            buttonUI.setText(monster.toString());
            if(monster.getPlayer().getId().equals(1L)) {
                buttonUI.setBackground(new Color(123, 179, 252));
            } else {
                buttonUI.setBackground(new Color(231, 123, 123));
            }
        } else {
            buttonUI.setVisible(false);
            buttonUI.setText("");
            buttonUI.setBackground(Color.WHITE);
        }
    }

}
