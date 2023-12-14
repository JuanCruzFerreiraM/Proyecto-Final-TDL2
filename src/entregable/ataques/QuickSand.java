package entregable.ataques;

import game.components.Monster;

public class QuickSand implements Sand {
    @Override
    public int damage(Monster monster) {
        double depth = Math.random();
        if (depth < 0.15) {
            return (int) (0.15 * 400);
        } else {
            return (int) (depth * 400);
        }
    }
}
