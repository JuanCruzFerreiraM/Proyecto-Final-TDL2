import game.components.Monster;
import game.components.RumbleGame;
import game.monsters.EvilBeast;
import game.monsters.IceBeast;
import game.monsters.Seth;
import game.monsters.Spartan;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new Seth("seth1"),
                new Seth("seth2"),
                new Seth("seth3"),
                new Seth("seth4"),
                new Seth("seth5"));

        // TODO ordenar el listado de monstruos que recibe el jugador uno
        Collections.sort(monstersOne, new ComparadorVida());
        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(new Spartan("Spartan A"),
                new Spartan("Spartan B"));

        // TODO ordenar el listado de monstruos que recibe el jugador dos
        Collections.sort(monstersTwo, new ComparadorNombre());
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        rumbleGame.startGame();
    }
}