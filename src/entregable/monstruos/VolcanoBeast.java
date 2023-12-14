package entregable.monstruos;

import game.components.Monster;
import game.components.PathBox;
import game.random.RandomGenerator;
import game.types.Type;
import game.attacks.Attack;

import java.util.Arrays;
import java.util.List;

import entregable.ataques.Flare;
import entregable.ataques.RockAndRoll;

public class VolcanoBeast extends Monster {
    private List<Attack> skills = Arrays.asList(new RockAndRoll(), new Flare());
    public VolcanoBeast(String name) {
        this.life = 600;
        this.monsterName = name;
        this.activeSkill = skills.get(RandomGenerator.getInstance().calculateDamage(0, 1));
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

      @Override
      public void onDamageReceive(Integer damage, Monster monster) {
          if (monster.getTypes().contains(Type.SWORD)) {
            this.life = this.life - ((int) (damage/1.5)); //Como si fuera de lava derrite la espada del monstruo.
            System.out.println("Funciona");
        } else {
            this.life = this.life - damage;
          }
          if (this.life < 0) {
              this.life = 0;
          }
          System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
      }
}