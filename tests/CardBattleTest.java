import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Card Battle — Auto-grader тестүүд.
 *
 * Энэ тестүүд зөвхөн **бүтэц**-ыг шалгана (reflection-оор): класс байна уу,
 * inheritance зөв уу, abstract method зөв тодорхойлогдсон уу гэх мэт.
 *
 * Тоглоомын **бодит** ажиллагаа, UI/UX, creativity — гараар шалгагдана.
 */
@DisplayName("Card Battle Auto-Grader")
public class CardBattleTest {

    // ==================== 🟢 CORE (8 тест) ====================

    @Test
    @Tag("core")
    @DisplayName("Card класс байгаа, abstract эсэх")
    void cardIsAbstract() throws Exception {
        Class<?> card = Class.forName("Card");
        assertTrue(Modifier.isAbstract(card.getModifiers()),
            "Card класс abstract байх ёстой");
    }

    @Test
    @Tag("core")
    @DisplayName("Card-д play() abstract method байна")
    void cardHasAbstractPlay() throws Exception {
        Class<?> card = Class.forName("Card");
        boolean hasAbstractPlay = false;
        for (Method m : card.getDeclaredMethods()) {
            if (m.getName().equals("play") && Modifier.isAbstract(m.getModifiers())) {
                hasAbstractPlay = true;
                break;
            }
        }
        assertTrue(hasAbstractPlay, "Card-д abstract play() method байх ёстой");
    }

    @Test
    @Tag("core")
    @DisplayName("AttackCard нь Card-аас extends")
    void attackCardExtendsCard() throws Exception {
        Class<?> attack = Class.forName("AttackCard");
        Class<?> card = Class.forName("Card");
        assertEquals(card, attack.getSuperclass(),
            "AttackCard нь Card-аас шууд extends хийсэн байх ёстой");
    }

    @Test
    @Tag("core")
    @DisplayName("HealCard нь Card-аас extends")
    void healCardExtendsCard() throws Exception {
        Class<?> heal = Class.forName("HealCard");
        Class<?> card = Class.forName("Card");
        assertEquals(card, heal.getSuperclass(),
            "HealCard нь Card-аас шууд extends хийсэн байх ёстой");
    }

    @Test
    @Tag("core")
    @DisplayName("BuffCard нь Card-аас extends")
    void buffCardExtendsCard() throws Exception {
        Class<?> buff = Class.forName("BuffCard");
        Class<?> card = Class.forName("Card");
        assertEquals(card, buff.getSuperclass(),
            "BuffCard нь Card-аас шууд extends хийсэн байх ёстой");
    }

    @Test
    @Tag("core")
    @DisplayName("Rarity enum 3 утгатай (COMMON, RARE, LEGENDARY)")
    void rarityEnumExists() throws Exception {
        Class<?> rarity = Class.forName("Rarity");
        assertTrue(rarity.isEnum(), "Rarity нь enum байх ёстой");
        Object[] values = rarity.getEnumConstants();
        assertTrue(values.length >= 3,
            "Rarity enum-д дор хаяж 3 утга байх ёстой");

        boolean hasCommon = false, hasRare = false, hasLegendary = false;
        for (Object v : values) {
            String name = v.toString();
            if (name.equals("COMMON")) hasCommon = true;
            if (name.equals("RARE")) hasRare = true;
            if (name.equals("LEGENDARY")) hasLegendary = true;
        }
        assertTrue(hasCommon, "COMMON утга байх ёстой");
        assertTrue(hasRare, "RARE утга байх ёстой");
        assertTrue(hasLegendary, "LEGENDARY утга байх ёстой");
    }

    @Test
    @Tag("core")
    @DisplayName("Player abstract класс байна")
    void playerIsAbstract() throws Exception {
        Class<?> player = Class.forName("Player");
        assertTrue(Modifier.isAbstract(player.getModifiers()),
            "Player класс abstract байх ёстой");
    }

    @Test
    @Tag("core")
    @DisplayName("Deck класс shuffle() + draw() method-той")
    void deckHasMethods() throws Exception {
        Class<?> deck = Class.forName("Deck");
        boolean hasShuffle = false, hasDraw = false;
        for (Method m : deck.getDeclaredMethods()) {
            if (m.getName().equals("shuffle")) hasShuffle = true;
            if (m.getName().equals("draw")) hasDraw = true;
        }
        assertTrue(hasShuffle, "Deck-д shuffle() method байх ёстой");
        assertTrue(hasDraw, "Deck-д draw() method байх ёстой");
    }

    // ==================== 🟡 STRETCH (4 тест) ====================

    @Test
    @Tag("stretch")
    @DisplayName("CreatureCard нь Card-аас extends")
    void creatureCardExtendsCard() throws Exception {
        Class<?> creature = Class.forName("CreatureCard");
        Class<?> card = Class.forName("Card");
        assertEquals(card, creature.getSuperclass(),
            "CreatureCard нь Card-аас extends хийсэн байх ёстой");
    }

    @Test
    @Tag("stretch")
    @DisplayName("AIPlayer нь Player-аас extends")
    void aiPlayerExtendsPlayer() throws Exception {
        Class<?> ai = Class.forName("AIPlayer");
        Class<?> player = Class.forName("Player");
        assertEquals(player, ai.getSuperclass(),
            "AIPlayer нь Player-аас extends хийсэн байх ёстой");
    }

    @Test
    @Tag("stretch")
    @DisplayName("GameSaver класс save() + load() method-той")
    void gameSaverExists() throws Exception {
        Class<?> saver = Class.forName("GameSaver");
        boolean hasSave = false, hasLoad = false;
        for (Method m : saver.getDeclaredMethods()) {
            if (m.getName().equals("save")) hasSave = true;
            if (m.getName().equals("load")) hasLoad = true;
        }
        assertTrue(hasSave, "GameSaver-т save() method байх ёстой");
        assertTrue(hasLoad, "GameSaver-т load() method байх ёстой");
    }

    @Test
    @Tag("stretch")
    @DisplayName("Олон картны subclass тоглоомд байна (4+)")
    void hasMultipleCardSubclasses() throws Exception {
        Class<?> card = Class.forName("Card");
        int subclassCount = 0;
        String[] candidates = {
            "AttackCard", "HealCard", "BuffCard", "CreatureCard",
            "SpellCard", "MinionCard", "TrapCard", "WeaponCard"
        };
        for (String name : candidates) {
            try {
                Class<?> c = Class.forName(name);
                if (card.isAssignableFrom(c) && !c.equals(card)) {
                    subclassCount++;
                }
            } catch (ClassNotFoundException ignored) {
                // Зарим нь хэрэгтэй биш
            }
        }
        assertTrue(subclassCount >= 4,
            "Дор хаяж 4 өөр Card subclass байх ёстой (одоо " + subclassCount + ")");
    }

    // ==================== 🔴 BONUS (2 тест) ====================

    @Test
    @Tag("bonus")
    @DisplayName("ConsoleRenderer класс байна")
    void consoleRendererExists() {
        try {
            Class<?> renderer = Class.forName("ConsoleRenderer");
            assertNotNull(renderer);
        } catch (ClassNotFoundException e) {
            fail("ConsoleRenderer класс үүсгэсэн байх ёстой (io/ хавтас)");
        }
    }

    @Test
    @Tag("bonus")
    @DisplayName("Method нэршил camelCase — reflection-оор шалгах")
    void methodsUseCamelCase() throws Exception {
        String[] classNames = {"Card", "Player", "Deck"};
        int totalMethods = 0;
        int wellNamed = 0;
        for (String cn : classNames) {
            try {
                Class<?> c = Class.forName(cn);
                for (Method m : c.getDeclaredMethods()) {
                    String n = m.getName();
                    // Synthetic method-ийг hide хийх
                    if (m.isSynthetic()) continue;
                    totalMethods++;
                    // camelCase: эхний үсэг жижиг, _ байхгүй
                    if (!n.isEmpty()
                            && Character.isLowerCase(n.charAt(0))
                            && !n.contains("_")) {
                        wellNamed++;
                    }
                }
            } catch (ClassNotFoundException ignored) {
                // Энэ bonus — заавал бүгд байх албагүй
            }
        }
        assertTrue(totalMethods > 0, "Ямар нэг method байх ёстой");
        // 95%+ camelCase байх
        double ratio = (double) wellNamed / totalMethods;
        assertTrue(ratio >= 0.95,
            "Method-уудын дор хаяж 95% нь camelCase байх ёстой (одоо "
                + String.format("%.0f%%", ratio * 100) + ")");
    }
}
