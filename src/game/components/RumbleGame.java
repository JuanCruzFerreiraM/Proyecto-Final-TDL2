package game.components;

import game.random.RandomGenerator;
import java.awt.*;
import javax.swing.*;

import entregable.excepciones.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class RumbleGame {

    private static RumbleGame instance = new RumbleGame();
    private Player playerOne;
    private Player playerTwo;
    private boolean loopGame = true;
    private int round = 0;
    private SegundaEvaluacionUI segundaEvaluacionUI;
    private String result;

    public static RumbleGame getInstance() {
        return instance;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    private RumbleGame() {

    }

    public void init() {
        playerOne = new Player(1L);
        playerTwo = new Player(2L);

        Castle castleOne = new Castle();
        Castle castleTwo = new Castle();

        Path westPath = new Path();
        Path eastPath = new Path();

        castleOne.setEastPath(eastPath);
        castleOne.setWestPath(westPath);

        castleTwo.setEastPath(eastPath);
        castleTwo.setWestPath(westPath);

        playerOne.setCastle(castleOne);
        playerTwo.setCastle(castleTwo);

        segundaEvaluacionUI = new SegundaEvaluacionUI();
        segundaEvaluacionUI.init().setVisible(true);

        PathBox box15 = new PathBox(segundaEvaluacionUI.getButton(0), "Noroeste");
        PathBox box27 = new PathBox(segundaEvaluacionUI.getButton(2), "Oeste");
        PathBox box39 = new PathBox(segundaEvaluacionUI.getButton(4), "Suroeste");

        box15.setNorthBox(null);
        box15.setSouthBox(box27);

        box27.setNorthBox(box15);
        box27.setSouthBox(box39);

        box39.setNorthBox(box27);
        box39.setSouthBox(null);

        westPath.getPathBoxes().add(box15);
        westPath.getPathBoxes().add(box27);
        westPath.getPathBoxes().add(box39);

        PathBox box17 = new PathBox(segundaEvaluacionUI.getButton(1), "Noreste");
        PathBox box29 = new PathBox(segundaEvaluacionUI.getButton(3), "Este");
        PathBox box41 = new PathBox(segundaEvaluacionUI.getButton(5), "Sureste");

        box17.setNorthBox(null);
        box17.setSouthBox(box29);

        box29.setNorthBox(box17);
        box29.setSouthBox(box41);

        box41.setNorthBox(box29);
        box41.setSouthBox(null);

        eastPath.getPathBoxes().add(box17);
        eastPath.getPathBoxes().add(box29);
        eastPath.getPathBoxes().add(box41);

        castleOne.setLifeLabel(segundaEvaluacionUI.getVidasPlayerOneLabel());
        castleTwo.setLifeLabel(segundaEvaluacionUI.getVidasPlayerTwoLabel());
    }

    public void nextRound() throws DrawException {
        System.out.println();
        System.out.println();
        System.out.println("Siguiente Ronda numero: " + round);
        int jugador = RandomGenerator.getInstance().nextPlayer();
        System.out.println("Mueve primero el Jugador numero " + jugador);
        if (jugador == 1) {
            playerOne.nextRound();
            playerTwo.nextRound();
        } else {
            playerTwo.nextRound();
            playerOne.nextRound();
        }
        segundaEvaluacionUI.refresh();
        round++;
        if (playerOne.getCastle().getCastleLife() <= 0) {
            System.out.println("****         Ganador el Jugador Azul!!!         ****");
            loopGame = false;
            this.result = "El jugador Azul ha ganado.";

        }
        if (playerTwo.getCastle().getCastleLife() <= 0) {
            System.out.println("****         Ganador el Jugador Rojo!!!         ****");
            loopGame = false;
            this.result = "El jugador Rojo ha ganado.";
        }
        if (!playerOne.getCastle().getEastPath().haveMonster(playerOne.getId())
                && !playerOne.getCastle().getEastPath().haveMonster(playerTwo.getId())
                && !playerOne.getCastle().getWestPath().haveMonster(playerOne.getId())
                && !playerOne.getCastle().getWestPath().haveMonster(playerTwo.getId())
                && playerOne.getCastle().getCastleLife() > 0
                && playerTwo.getCastle().getCastleLife() > 0
                && !playerOne.getIterator().hasNext()
                && !playerTwo.getIterator().hasNext()) {
            loopGame = false;
            throw new DrawException();
        }

        if (round == 100) {
            loopGame = false;
        }
    }

    private void popOutWindowCreator (String result){
        JDialog popOutWindow = new JDialog(segundaEvaluacionUI, true);
        popOutWindow.setLayout(new GridBagLayout());
        popOutWindow.setSize(500, 300);
        popOutWindow.setTitle("Resultado");
        popOutWindow.setUndecorated(true);
        popOutWindow.setLocationRelativeTo(segundaEvaluacionUI);
        GridBagConstraints c = new GridBagConstraints();
        // Configuración de Labels
        JLabel endGameMessage = new JLabel("Fin del Juego");
        endGameMessage.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 5;
        c.ipady = 6;
        c.insets = new Insets(5, 10, 10, 10);
        endGameMessage.setHorizontalAlignment(JLabel.CENTER);
        popOutWindow.add(endGameMessage, c);
        JLabel winMessage = new JLabel(result);
        winMessage.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 5;
        c.ipady = 6;
        c.insets = new Insets(10, 10, 10, 10);
        winMessage.setHorizontalAlignment(JLabel.CENTER);
        popOutWindow.add(winMessage, c);
        //Botón que permite cerrar la ventana pop-out
        JButton closeButton = new JButton("Cerrar");
        closeButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                popOutWindow.dispose();
            }
        });
        closeButton.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                closeButton.setBackground(new Color(190, 190, 190));
            }

            public void mouseExited(MouseEvent e) {
                closeButton.setBackground(new Color(202, 202, 202));
            }
        });
        c.gridx = 1;
        c.gridy = 2;
        c.ipady = 10;
        c.insets = new Insets(20, 10, 10, 10);
        closeButton.setBackground(new Color(202, 202, 202));
        closeButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        closeButton.setBorder(null);
        closeButton.setFocusable(false);
        popOutWindow.add(closeButton,c);
        // Se visualiza la ventana pop-out
        popOutWindow.setVisible(true);
    }

    public void startGame() {
        while (loopGame) {
            try {
                Thread.sleep(1500);
                this.nextRound();
            } catch (DrawException d) {
                this.result = "Ha ocurrido un empate.";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // TODO: Colocar una ventana modal con un mensaje que indique el resultado
        popOutWindowCreator(result);
        System.exit(0);
    }
}
