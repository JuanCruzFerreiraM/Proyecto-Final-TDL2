package game.monsters;

import game.attacks.Slice;
import game.components.Monster;
import game.types.Type;

import java.util.Arrays;

public class Spartan extends Monster {

    public Spartan(String name) {
        this.life = 500;
        this.activeSkill = new Slice();
        this.monsterName = name;
        this.types = Arrays.asList(Type.SWORD);
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }
}
