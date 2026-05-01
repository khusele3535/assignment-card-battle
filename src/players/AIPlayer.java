package players;

import cards.Card;
import game.Deck;
import java.util.ArrayList;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    @Override
    public void takeTurn(Player opponent, Deck deck) {
        System.out.println("\n" + getName() + " шийдвэр гаргаж байна...");

        if (hand.isEmpty()) {
            drawCard(deck);
        }

        boolean canPlayMore = true;
        while (canPlayMore) {
            Card bestCard = null;
            int bestCardIndex = -1;

            for (int i = 0; i < hand.size(); i++) {
                Card c = hand.get(i);
                if (this.mana >= c.getManaCost()) {
                    if (bestCard == null || c.getManaCost() > bestCard.getManaCost()) {
                        bestCard = c;
                        bestCardIndex = i;
                    }
                }
            }

            if (bestCard != null) {
                this.mana -= bestCard.getManaCost();
                bestCard.play(this, opponent);
                hand.remove(bestCardIndex);

                // Хэрэв өрсөлдөгч ялагдсан бол шууд зогсоно
                if (opponent.getHealth() <= 0) break;
            } else {
                canPlayMore = false; // Тоглох боломжтой карт алга
            }
        }
        System.out.println(getName() + " ээлжээ дуусгалаа.");
    }
}
