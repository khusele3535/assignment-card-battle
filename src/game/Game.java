package game;

import players.Player;
import players.HumanPlayer;
import players.AIPlayer;
import io.ConsoleRenderer;
import io.InputReader;
import io.GameSaver;

public class Game {
    private Player human;
    private Player ai;
    private Deck deck;
    private boolean isGameOver = false;
    private ConsoleRenderer renderer = new ConsoleRenderer();
    private InputReader input = new InputReader();
    private GameSaver saver = new GameSaver();

    public void showMainMenu() {
        System.out.println("\n========================================");
        System.out.println("      ⚔️ NOMADIC CARD BATTLE ⚔️        ");
        System.out.println("========================================");
        System.out.println("  1. Шинэ тоглоом (New Game)");
        System.out.println("  2. Тоглоом хадгалах (Save Game)");
        System.out.println("  3. Гарах (Exit)");
        System.out.println("========================================");

        int choice = input.getIntInput("Сонголтоо оруулна уу: ");

        switch (choice) {
            case 1:
                initGame();
                start();
                break;
            case 2:
                System.out.println("⚠️ Тоглоом эхлээгүй байна!");
                showMainMenu();
                break;
            case 3:
                System.out.println("Баяртай!");
                System.exit(0);
                break;
            default:
                showMainMenu();
        }
    }

    private void initGame() {
        deck = new Deck();
        human = new HumanPlayer("Баатар (Та)");
        ai = new AIPlayer("Мангас (AI)");

        for (int i = 0; i < 3; i++) {
            human.drawCard(deck);
            ai.drawCard(deck);
        }
    }

    public void start() {
        while (!isGameOver) {
            printStatus();
            human.addMana();
            human.drawCard(deck);
            human.takeTurn(ai, deck);

            System.out.print("Тоглоомыг хадгалах уу? (y/n): ");

            checkWinCondition();
            if (isGameOver) break;

            System.out.println("\n--- AI-ИЙН ЭЭЛЖ ---");
            ai.addMana();
            ai.drawCard(deck);
            ai.takeTurn(human, deck);
            checkWinCondition();
        }
    }

    private void printStatus() {
        renderer.printBattleState(human, ai);
    }

    private void checkWinCondition() {
        if (human.getHealth() <= 0) {
            System.out.println("\n💀 ТА ЯЛАГДЛАА...");
            isGameOver = true;
        } else if (ai.getHealth() <= 0) {
            System.out.println("\n🎉 БАЯР ХҮРГЭЕ! ТА ЯЛАЛТ БАЙГУУЛЛАА!");
            isGameOver = true;
        }
    }
}
