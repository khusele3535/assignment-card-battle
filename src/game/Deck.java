package game;

import cards.*;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        for (int i = 0; i < 5; i++) cards.add(new AttackCard("Галт сум", 2, 5));
        for (int i = 0; i < 3; i++) cards.add(new AttackCard("Хүчтэй цохилт", 4, 9));

        for (int i = 0; i < 4; i++) cards.add(new HealCard("Рашаан", 2, 6));

        cards.add(new CreatureCard("Чоно", 3, 4, 4));
        cards.add(new CreatureCard("Бүргэд", 2, 3, 2));
        cards.add(new CreatureCard("Баатар", 5, 8, 10));

        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) return null;
        return cards.remove(0);
    }
}
