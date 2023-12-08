package game.attacks;

import game.components.Monster;

public class Curse implements Demon {

    @Override
    public int damage(Monster monster) {
        return 500;
    }
}
