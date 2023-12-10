import java.util.Comparator;

import game.components.Monster;

public class ComparadorVida implements Comparator<Monster> {
    public int compare(Monster m1, Monster m2) {
        return m1.getLife() - m2.getLife();
    }
}
