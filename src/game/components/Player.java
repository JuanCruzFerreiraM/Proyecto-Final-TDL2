package game.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player {
    private Castle castle;
    private List<Monster> monsters = new ArrayList<>();
    private Iterator<Monster> monsterIterator;
    private Long id;

    public Player(Long id) {
        this.id = id;
    }

    public Castle getCastle() {
        return castle;
    }

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
        this.monsterIterator = monsters.iterator();
        this.monsters.forEach(monster -> monster.setPlayer(this));

    }

    public void nextRound() {
        this.castle.nextRound(id, monsterIterator);
    }

    public Long getId() {
        return id;
    }
}
