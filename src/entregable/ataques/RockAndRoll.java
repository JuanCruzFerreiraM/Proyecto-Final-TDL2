package entregable.ataques;

import game.types.Type;
import game.components.Monster;
import game.random.RandomGenerator;

public class RockAndRoll implements Rock {

    @Override
    public int damage(Monster enemy) {
      int damage = RandomGenerator.getInstance().calculateDamage(200, 300);
      if(enemy.getTypes().contains(Type.PLANT)){
        return damage+200;
      }
        return damage;
      }

    //Se endurece y genera un escudo, subiendo la vida del mismo
    public int Roll(){
      return(20);
    }
}
