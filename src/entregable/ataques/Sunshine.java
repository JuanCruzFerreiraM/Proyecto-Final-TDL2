package entregable.ataques;

import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class Sunshine implements Light{
  @Override
  public int damage(Monster monster){
    int times = RandomGenerator.getInstance().calculateDamage(1, 3);
    int damage = RandomGenerator.getInstance().calculateDamage(80, 110);
    if(monster.getTypes().contains(Type.DEMON)){
      times= times + 1;
    }
    return (damage*times);
  }
}
