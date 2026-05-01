package cards;

import players.Player;

public abstract class Card {
    private String name;
    private int manaCost;

    public Card(String name, int manaCost) {
        this.name = name;
        this.manaCost = manaCost;
    }

    public abstract void play(Player owner, Player opponent);

    public String getName() { return name; }
    public int getManaCost() { return manaCost; }
}
