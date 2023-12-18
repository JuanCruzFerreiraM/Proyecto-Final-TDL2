package entregable.ataques;


import game.attacks.Sword;
import game.components.Monster;
import game.types.Type;

public class Poisson implements Plant{

  @Override
  public int damage(Monster monster){
    if ((monster.getTypes().contains(Type.SWORD))||(monster.getTypes().contains(Type.BEAST))) {
      //Si porta una espada es un ser vivo y el veneno le afecta.
      int damage = monster.getLife()/2;
       return damage;
    }
    return 150;
}

}