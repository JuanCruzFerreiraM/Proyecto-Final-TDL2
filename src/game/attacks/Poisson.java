package game.attacks;

import game.components.Monster;

public class Poisson implements Plant{

  @Override
  public int damage(Monster monster){
    int damage = monster.getLife()/2;
    return damage;
}

}