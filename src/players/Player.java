package players;

import cards.Card;
import game.Deck; // Багшийн Deck-ийг энд импортлоно
import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private String name;
    private int health;
    private int mana;
    private List<Card> hand = new ArrayList<>();

    // Заавар ёсоор: Зөвхөн 1 аргумент (name) хүлээж авдаг байх ёстой
    public Player(String name) {
        this.name = name;
        this.health = 30; // Үндсэн HP 30
        this.mana = 1;    // Эхлэх мана 1
    }

    // БАГШИЙН СУУРЬ АЛДААГ ЗАССАН НЬ: takeTurn нь Deck хүлээж авдаг байх ёстой
    public abstract void takeTurn(Player opponent, Deck deck);

    public void takeDamage(int amount) {
        this.health = Math.max(0, this.health - amount);
    }

    public void heal(int amount) {
        this.health = Math.min(30, this.health + amount);
    }

    // Энд 'useMana' метод байхгүй байсан тул нэмж өгөв
    public void useMana(int amount) {
        this.mana -= amount;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
    public List<Card> getHand() { return hand; }
}
