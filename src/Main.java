import game.components.Monster;
import game.components.RumbleGame;
import game.monsters.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import entregable.comparadores.*;
import entregable.monstruos.*;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new Spartan("Spartan1"), new EvilBeast("EvilBeast1"),
                new IceBeast("IceBeast1"), new Seth("Seth1"), new VolcanoBeast("VolcanoBeast1"));

        // TODO ordenar el listado de monstruos que recibe el jugador uno
        Collections.sort(monstersOne, new ComparadorVida());
        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(new Spartan("Spartan1"), new EvilBeast("EvilBeast1"),
                new IceBeast("IceBeast1"), new Seth("Seth1"), new VolcanoBeast("VolcanoBeast1"));
        // TODO ordenar el listado de monstruos que recibe el jugador dos
        Collections.sort(monstersTwo, new ComparadorNombre());
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        rumbleGame.startGame();
    }
}