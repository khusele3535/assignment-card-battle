package players;

import cards.Card;
import game.Deck;
import io.InputReader;

public class HumanPlayer extends Player {
    private InputReader input = new InputReader();

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void takeTurn(Player opponent, Deck deck) {
        boolean turnEnded = false;

        while (!turnEnded) {
            System.out.println("\n--- ТАНЫ ЭЭЛЖ (Мана: " + this.mana + ") ---");
            for (int i = 0; i < hand.size(); i++) {
                Card c = hand.get(i);
                System.out.println((i + 1) + ". " + c.getName() + " (Мана: " + c.getManaCost() + ")");
            }
            System.out.println("0. Ээлжээ дуусгах");

            int choice = input.getIntInput("Карт сонгоно уу: ");

            if (choice == 0) {
                turnEnded = true;
            } else if (choice > 0 && choice <= hand.size()) {
                Card selected = hand.get(choice - 1);
                if (this.mana >= selected.getManaCost()) {
                    this.mana -= selected.getManaCost();
                    selected.play(this, opponent);
                    hand.remove(choice - 1); // Карт ашигласан тул гараас хасна
                } else {
                    System.out.println("⚠️ Мана хүрэлцэхгүй байна!");
                }
            }

            if (opponent.getHealth() <= 0) break;
        }
    }
}
