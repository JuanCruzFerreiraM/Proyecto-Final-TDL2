package entregable.ataques;
import game.types.Type;
import game.components.Monster;

public class SandStrom implements Sand, Storm {
    @Override
    public int damage(Monster monster) {
        double dmgPorcent = 0;
        int x=5;
        if(monster.getTypes().contains(Type.DEMON)){
            x+=2;
        }
        for (int i = 0; i < x; i++) {
            dmgPorcent += Math.random() / 5;
        }
        return (int) dmgPorcent * 400;
    }
}
