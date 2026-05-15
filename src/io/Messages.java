package io;

import java.util.HashMap;
import java.util.Map;

public class Messages {
    private static String currentLang = "EN";
    private static final Map<String, Map<String, String>> langMap = new HashMap<>();

    static {
        Map<String, String> mn = new HashMap<>();
        mn.put("welcome", "⚔️ ТУЛААНД ТАВТАЙ МОРИЛ! ⚔️");
        mn.put("your_turn", "--- ТАНЫ ЭЭЛЖ ---");
        mn.put("enemy_turn", "--- ДАЙСНЫ ЭЭЛЖ ---");
        mn.put("no_mana", "⚠️ Мана хүрэлцэхгүй байна!");
        mn.put("hand", "ТАНЫ ГАРТ БАЙГАА КАРТУУД:");

        Map<String, String> en = new HashMap<>();
        en.put("welcome", "⚔️ WELCOME TO THE BATTLE! ⚔️");
        en.put("your_turn", "--- YOUR TURN ---");
        en.put("enemy_turn", "--- ENEMY TURN ---");
        en.put("no_mana", "⚠️ Not enough Mana!");
        en.put("hand", "YOUR CURRENT HAND:");

        langMap.put("MN", mn);
        langMap.put("EN", en);
    }

    public static void setLanguage(String lang) {
        currentLang = lang;
    }

    public static String get(String key) {
        Map<String, String> lang = langMap.get(currentLang);
        if (lang == null || !lang.containsKey(key)) {
            return langMap.get("EN").get(key);
        }
        return lang.get(key);
    }
}
