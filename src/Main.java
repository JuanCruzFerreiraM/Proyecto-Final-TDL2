import game.components.Monster;
import game.components.RumbleGame;
import game.monsters.EvilBeast;
import game.monsters.IceBeast;
import game.monsters.Spartan;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import entregable.monstruos.Seth;
import entregable.monstruos.VolcanoBeast;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new Spartan("Spartan 1"),
                new VolcanoBeast("Volcano 1"),
                new Seth("Seth 1"),
                new IceBeast("Ice Beast 1"),
                new Spartan("Spartan 5"),
                new Spartan("Spartan 6"),
                new VolcanoBeast("Volcano 2"),
                new Seth("Seth 2"),
                new Spartan("Spartan 9"),
                new Spartan("Spartan 10"),
                new IceBeast("Ice Beast 2"),
                new Spartan("Spartan 24"),
                new Spartan("Spartan 224"),
                new Spartan("Spartan 34"),
                new Spartan("Spartan 44"),
                new Spartan("Spartan 64"),
                new Spartan("Spartan 15"));

        // TODO ordenar el listado de monstruos que recibe el jugador uno
        Collections.sort(monstersOne, new ComparadorVida());
        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(
                new Spartan("Spartan A"),
                new Spartan("Spartan B"),
                new VolcanoBeast("Volcano A"),
                new VolcanoBeast("Volcano B"),
                new Seth("Seth A"),
                new IceBeast("Ice Beast A"));
                

        // TODO ordenar el listado de monstruos que recibe el jugador dos
        Collections.sort(monstersTwo, new ComparadorNombre());
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        rumbleGame.startGame();
    }
}