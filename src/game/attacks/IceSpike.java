package game.attacks;

import game.components.Monster;
import game.random.RandomGenerator;

public class IceSpike implements Cold {

    @Override
    public int damage(Monster monster) {
        return RandomGenerator.getInstance().calculateDamage(0, 200);
    }
}
