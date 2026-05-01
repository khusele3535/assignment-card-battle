package io;

import players.Player;

public class ConsoleRenderer {
    public void printBattleState(Player human, Player ai) {
        System.out.println("\n========================================");
        System.out.println("  ДАЙСАН: " + ai.getName());
        System.out.println("  HP: " + renderHPBar(ai.getHealth(), 30) + " " + ai.getHealth() + "/30");
        System.out.println("----------------------------------------");
        System.out.println("\n       ( ⚔️ ТУЛААНЫ ТАЛБАР ⚔️ )       \n");
        System.out.println("----------------------------------------");
        System.out.println("  ТАНЫ ТӨЛӨВ: " + human.getName());
        System.out.println("  HP: " + renderHPBar(human.getHealth(), 30) + " " + human.getHealth() + "/30");
        System.out.println("  МАНА: " + "💎".repeat(human.getMana()));
        System.out.println("========================================");
    }

    private String renderHPBar(int current, int max) {
        int barLength = 10;
        int filled = (int) ((double) current / max * barLength);
        if (filled < 0) filled = 0;
        return "[" + "#".repeat(filled) + "-".repeat(barLength - filled) + "]";
    }
}
