package game.attacks;

import game.components.Monster;
import game.random.RandomGenerator;

public class Slice implements Sword {

    @Override
    public int damage(Monster monster) {
        return RandomGenerator.getInstance().calculateDamage(100, 500);
    }
}
