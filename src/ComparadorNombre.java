import java.util.Comparator;

import game.components.Monster;

public class ComparadorNombre implements Comparator<Monster> {
    public int compare(Monster m1, Monster m2) {
        return m1.toString().compareTo(m2.toString());
    }
}
