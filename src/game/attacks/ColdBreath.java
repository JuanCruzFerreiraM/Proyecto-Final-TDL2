package game.attacks;

import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class ColdBreath implements Cold {

    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(90, 150);
        if(monster.getTypes().contains(Type.FIRE)) {
            damage = damage * 2;
        }
        return damage;
    }
}
