package entregable.ataques;

import game.attacks.Fire;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;


public class Flare implements Fire {

    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(150, 300);
      if (monster.getTypes().contains(Type.FIRE)){
        return damage;
      }else if (monster.getTypes().contains(Type.COLD)){
       //Hace 1.5 porque los derrite.
        return (int) (damage * 1.5);
      }
        //Suma 50 porque los quema
      return damage + 50;
      }
    }

