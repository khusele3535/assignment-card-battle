package players;

import cards.Card;
import cards.InsufficientManaException;
import game.Deck;

public class AIPlayer extends Player {

    public AIPlayer(String name) {
        super(name);
    }

    @Override
    public void takeTurn(Player opponent, Deck deck) {
        // Private хандалтыг getHand() болон getMana() ашиглан засав
        for (int i = 0; i < getHand().size(); i++) {
            Card card = getHand().get(i);
            if (card.getManaCost() <= this.getMana()) {
                card.play(this, opponent);
                this.useMana(card.getManaCost());
                getHand().remove(i);
                return;
            }
        }
        System.out.println(">>> AI skipped turn.");
    }
}
