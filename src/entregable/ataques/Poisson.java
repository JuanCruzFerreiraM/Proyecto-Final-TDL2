package entregable.ataques;


import game.attacks.Sword;
import game.components.Monster;
import game.types.Type;

public class Poisson implements Plant{

  @Override
  public int damage(Monster monster){
    if (monster.getTypes().contains(Type.SWORD)) {
      //Si porta una espada es un ser vivo y el veneno le afecta.
       return monster.getLife() - 300;
    } else if (monster.getLife() >= 600){
      int damage = monster.getLife()/2;
      return damage;
    }  

    return 150;
}

}