package game.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SegundaEvaluacionUI extends JFrame {

    private List<JPanel> panelList = new ArrayList<>();

    private List<JButton> buttons = new ArrayList<>();

    private JLabel label1;

    private JLabel label2;

    public SegundaEvaluacionUI init() {
        this.initPanels();
        this.addButtons();
        setContentPane(new BackgroundPanel());
        setTitle("Segunda Evaluacion");
        setSize(600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(20,3);
        panelList.forEach(SegundaEvaluacionUI.this::add);

        setLayout(gridLayout);
        setLocationRelativeTo(null);
        return this;
    }

    public JButton getButton(int index) {
        return buttons.get(index);
    }

    private void addButtons() {
        JButton button15 = new JButton();
        panelList.get(15).setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelList.get(15).add(button15);
        button15.setText("15");
        button15.setVisible(false);
        buttons.add(button15);

        JButton button17 = new JButton();
        panelList.get(17).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(17).add(button17);
        button17.setText("17");
        button17.setVisible(false);
        buttons.add(button17);

        JButton button27 = new JButton();
        panelList.get(27).setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelList.get(27).add(button27);
        button27.setText("27");
        button27.setVisible(false);
        buttons.add(button27);

        JButton button29 = new JButton();
        panelList.get(29).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(29).add(button29);
        button29.setText("29");
        button29.setVisible(false);
        buttons.add(button29);

        JButton button39 = new JButton();
        panelList.get(39).setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelList.get(39).add(button39);
        button39.setText("39");
        button39.setVisible(false);
        buttons.add(button39);

        JButton button41 = new JButton();
        panelList.get(41).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(41).add(button41);
        button41.setText("41");
        button41.setVisible(false);
        buttons.add(button41);

        label1 = new JLabel();
        label1.setText("Vidas: 3");
        label1.setForeground(Color.RED);
        label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        panelList.get(0).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(0).add(label1);

        label2 = new JLabel();
        label2.setText("Vidas: 3");
        label2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label2.setForeground(Color.BLUE);
        panelList.get(57).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(57).add(label2);
    }

    public JLabel getVidasPlayerOneLabel() {
        return label1;
    }

    public JLabel getVidasPlayerTwoLabel() {
        return label2;
    }

    public void refresh() {
        this.revalidate();
        this.repaint();
    }

    private void initPanels() {
        for(int i=0; i < 60; i++) {
            JPanel panel = new JPanel();
            panel.setOpaque(true);
            panel.setBackground(new Color(0,0,0,0));
//            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelList.add(panel);
        }
    }
}
