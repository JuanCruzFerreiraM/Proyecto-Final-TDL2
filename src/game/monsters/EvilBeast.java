package game.monsters;

import game.attacks.Curse;
import game.components.Monster;
import game.types.Type;

import java.util.Arrays;

public class EvilBeast extends Monster {

    public EvilBeast(String name) {
        this.life = 700;
        this.monsterName = name;
        this.activeSkill = new Curse();
        this.types = Arrays.asList(Type.BEAST, Type.DEMON, Type.FIRE);
    }

    @Override
    public void attack(Monster enemy) {
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }
}
