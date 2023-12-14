package game.attacks;

import game.components.Monster;

public class SandStrom implements Sand, Storm {
    @Override
    public int damage(Monster monster) {
        double dmgPorcent = 0;
        for (int i = 0; i < 5; i++) {
            dmgPorcent += Math.random() / 5;
        }
        return (int) dmgPorcent * 400;
    }
}
