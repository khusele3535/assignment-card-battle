package game;

import players.Player;
import players.HumanPlayer;
import players.AIPlayer;
import io.ConsoleRenderer;

public class Game {
    private Player human;
    private Player ai;
    private Deck deck;
    private boolean isGameOver = false;
    private ConsoleRenderer renderer = new ConsoleRenderer();

    public Game() {
        deck = new Deck();
        human = new HumanPlayer("Баатар (Та)");
        ai = new AIPlayer("Мангас (AI)");

        for (int i = 0; i < 3; i++) {
            human.drawCard(deck);
            ai.drawCard(deck);
        }
    }

    public void start() {
        System.out.println("⚔️ NOMADIC CARD BATTLE ЭХЭЛЛЭЭ! ⚔️");

        while (!isGameOver) {
            printStatus();

            human.addMana();
            human.drawCard(deck);
            human.takeTurn(ai, deck);
            checkWinCondition();
            if (isGameOver) break;

            // AI-ийн ээлж
            System.out.println("\n--- AI-ИЙН ЭЭЛЖ ---");
            ai.addMana();
            ai.drawCard(deck);
            ai.takeTurn(human, deck);
            checkWinCondition();

            System.out.println("================================");
        }
    }

    private void printStatus() {
        renderer.printBattleState(human, ai);
    }

    private void checkWinCondition() {
        if (human.getHealth() <= 0) {
            System.out.println("\n💀 ТА ЯЛАГДЛАА... МАНГАС ЯЛАЛТ БАЙГУУЛАВ!");
            isGameOver = true;
        } else if (ai.getHealth() <= 0) {
            System.out.println("\n🎉 БАЯР ХҮРГЭЕ! ТА ЯЛАЛТ БАЙГУУЛЛАА!");
            isGameOver = true;
        }
    }
}
