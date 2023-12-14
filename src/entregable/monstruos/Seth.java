package entregable.monstruos;

import game.components.Monster;
import game.components.PathBox;
import game.random.RandomGenerator;
import game.types.Type;

import java.util.Arrays;
import java.util.List;

import entregable.ataques.QuickSand;
import entregable.ataques.Sand;
import entregable.ataques.SandStrom;

public class Seth extends Monster {

    private List<Sand> skills = Arrays.asList(new QuickSand(), new SandStrom());

    public Seth(String name) {
        this.life = 400;
        this.monsterName = name;
        this.activeSkill = skills.get(RandomGenerator.getInstance().calculateDamage(0, 1));
        this.types = Arrays.asList(Type.SAND, Type.STORM);
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     [" + this + "] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        super.move(oldPathBox, newPathBox);
        if (activeSkill instanceof SandStrom) {
            activeSkill = skills.get(0);
        } else {
            if (Math.random() < 0.3) {
                activeSkill = skills.get(1);
            }
        }
    }
}
