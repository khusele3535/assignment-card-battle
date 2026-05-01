package io;

import players.Player;
import java.io.*;
import java.util.Scanner;

public class GameSaver {
    private static final String SAVE_FILE = "savegame.txt";

    public void saveGame(Player human, Player ai) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_FILE))) {
            writer.println(human.getName() + "," + human.getHealth() + "," + human.getMana());
            writer.println(ai.getName() + "," + ai.getHealth() + "," + ai.getMana());
            System.out.println("💾 Тоглоомыг амжилттай хадгаллаа!");
        } catch (IOException e) {
            System.out.println("❌ Хадгалахад алдаа гарлаа: " + e.getMessage());
        }
    }

    public boolean loadGame(Player human, Player ai) {
        File file = new File(SAVE_FILE);
        if (!file.exists()) {
            System.out.println("⚠️ Хадгалсан файл олдсонгүй!");
            return false;
        }

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                String[] humanData = scanner.nextLine().split(",");
                System.out.println("📂 Хадгалсан өгөгдлийг ачааллаа: " + humanData[0]);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
}
