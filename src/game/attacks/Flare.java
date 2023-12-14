package game.attacks;

import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class Flare implements Fire {

    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(150, 300);
      if (monster.getTypes().contains(Type.FIRE)){
        return damage;
      }else{
        //Suma 50 porque los quema
      return damage + 50;
      }
    }
}
