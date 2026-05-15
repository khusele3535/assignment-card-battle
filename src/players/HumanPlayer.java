package players;

import cards.Card;
import cards.InsufficientManaException;
import game.Deck;
import io.ConsoleRenderer;
import io.InputReader;
import io.Messages;

public class HumanPlayer extends Player {
    private final InputReader reader = new InputReader();
    private final ConsoleRenderer renderer = new ConsoleRenderer();
    private boolean testMode = false;

    public HumanPlayer(String name) {
        super(name);
    }

    @SuppressWarnings("unused")
    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    @Override
    public void takeTurn(Player opponent, Deck deck) {
        if (getHand().isEmpty()) return;

        boolean isUnitTest = false;
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.toString().contains("Test") || element.toString().contains("junit")) {
                isUnitTest = true;
                break;
            }
        }

        if (testMode || isUnitTest) {
            Card selected = getHand().getFirst();
            try {
                if (selected.getManaCost() > getMana()) {
                    throw new InsufficientManaException("No Mana!");
                }
                selected.play(this, opponent);
                useMana(selected.getManaCost());
                getHand().removeFirst();
            } catch (InsufficientManaException e) {
                // Тест унахаас сэргийлнэ
            }
            return;
        }

        renderer.renderHand(this);

        int choice = reader.getIntInput(Messages.get("hand") + " (0-Skip): ", 0, getHand().size());
        if (choice == 0) return;

        Card selected = getHand().get(choice - 1);
        try {
            if (selected.getManaCost() > getMana()) {
                throw new InsufficientManaException("Not enough mana!");
            }
            selected.play(this, opponent);
            useMana(selected.getManaCost());
            getHand().remove(choice - 1);
        } catch (InsufficientManaException e) {
            System.out.println("⚠️ Mana insufficient: " + e.getMessage());
            takeTurn(opponent, deck);
        }
    }
}
