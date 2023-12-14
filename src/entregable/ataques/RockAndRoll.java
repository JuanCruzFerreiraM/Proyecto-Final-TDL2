package entregable.ataques;

import game.components.Monster;
import game.random.RandomGenerator;

public class RockAndRoll implements Rock {

    @Override
    public int damage(Monster enemy) {
      int damage = RandomGenerator.getInstance().calculateDamage(200, 300);
        return damage;
      }

    //Se endurece y genera un escudo, subiendo la vida del mismo
    public int Roll(){
      return(20);
    }
}
