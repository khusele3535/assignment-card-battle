package cards;

public abstract class Card {
    private String name;
    private int manaCost;

    public Card(String name, int manaCost) {
        this.name = name;
        this.manaCost = manaCost;
    }

    public abstract void play();

    public String getName() { return name; }
    public int getManaCost() { return manaCost; }
}
