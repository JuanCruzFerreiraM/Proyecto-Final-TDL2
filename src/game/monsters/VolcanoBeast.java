package game.monsters;

import game.attacks.RockAndRoll;
import game.components.Monster;
import game.components.PathBox;
import game.types.Type;
import game.attacks.Flare;
import game.attacks.Attack;

import java.util.Arrays;
import java.util.List;

public class VolcanoBeast extends Monster {
    private List<Attack> skills = Arrays.asList(new RockAndRoll(), new Flare());
    public VolcanoBeast(String name) {
        this.life = 500;
        this.monsterName = name;
        this.activeSkill = skills.get(0);
        this.types = Arrays.asList(Type.ROCK, Type.FIRE);
    }
    
    @Override
    public void attack(Monster enemy) {
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
      super.move(oldPathBox, newPathBox);
      if(activeSkill instanceof RockAndRoll){
        this.addLife(20, null);
        this.activeSkill = skills.get(1);
        } else {
            this.activeSkill = skills.get(0);
        }
      }

}