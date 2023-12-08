package game.attacks;

import game.components.Monster;

public interface Attack {
    int damage(Monster monster);
}
