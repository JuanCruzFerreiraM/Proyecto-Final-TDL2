package entregable.ataques;

import game.components.Monster;

public class Poisson implements Plant{

  @Override
  public int damage(Monster monster){
    if (monster.getLife() >= 600){
      int damage = monster.getLife()/2;
      return damage;
    }
    return 150;
}

}