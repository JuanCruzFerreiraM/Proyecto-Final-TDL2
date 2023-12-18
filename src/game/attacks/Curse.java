package game.attacks;
import game.types.Type;
import game.components.Monster;

public class Curse implements Demon {

    @Override
    public int damage(Monster monster) {
        if (monster.getTypes().contains(Type.LIGHT)){
            return 500;
        }
        return 400;
    }
}
