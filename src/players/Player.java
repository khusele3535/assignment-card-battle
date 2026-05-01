package players;

import cards.Card;
import game.Deck;
import java.util.ArrayList;

public abstract class Player {
    protected String name;
    protected int health = 30;
    protected int mana = 1;
    protected int maxMana = 1;
    protected ArrayList<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) this.health = 0;
    }

    public void heal(int amount) {
        this.health += amount;
        if (this.health > 30) this.health = 30;
    }

    public void addMana() {
        if (maxMana < 10) maxMana++;
        this.mana = maxMana;
    }

    public void drawCard(Deck deck) {
        Card card = deck.drawCard();
        if (card != null && hand.size() < 7) {
            hand.add(card);
            System.out.println(this.name + " шинэ карт сугаллаа.");
        }
    }

    public abstract void takeTurn(Player opponent, Deck deck);

    public int getHealth() { return health; }
    public int getMana() { return mana; }
    public String getName() { return name; }
    public ArrayList<Card> getHand() { return hand; }
}
