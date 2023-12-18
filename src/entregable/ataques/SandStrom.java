package entregable.ataques;

import game.types.Type;
import game.components.Monster;
import game.random.RandomGenerator;

public class SandStrom implements Sand, Storm {
    @Override
    public int damage(Monster monster) {
        double dmg = 0;
        int x = 5;
        if (monster.getTypes().contains(Type.DEMON)) {
            x += 2;
        }
        for (int i = 0; i < x; i++) {
            dmg += RandomGenerator.getInstance().calculateDamage(50, 150);
        }
        return (int) dmg;
    }
}
