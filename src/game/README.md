# ⚔️ `game/` — Тоглоомын loop

Энэ хэсэг нь тоглоомын "оркестр" — Player хоёрын хооронд ээлж солих, win condition шалгах, өдөр тутмын механик.

---

## 📐 Бүтэц

```
game/
├── Game.java          # Main orchestrator — game loop
├── Deck.java          # List<Card> + shuffle, draw
├── Turn.java          # Нэг ээлжийн төлөв
└── Battlefield.java   # 🟡 Stretch — 2 талын creature-ууд
```

---

## 🟢 Core: `Game`

```java
public class Game {
    // TODO: Талбарууд
    //   - Player player1
    //   - Player player2
    //   - int turnNumber
    //   - ConsoleRenderer renderer
    
    // TODO: Constructor(Player p1, Player p2)
    
    // TODO: start() —
    //   while (both players alive) {
    //     currentPlayer.startTurn();
    //     renderer.render(this);
    //     // player-г шийдэх болтол card тоглох үйлдлийг давтах
    //     int choice = currentPlayer.chooseCard(opponent);
    //     if (choice == -1) break; // pass
    //     try {
    //         currentPlayer.playCard(choice, opponent);
    //     } catch (InsufficientManaException e) {
    //         renderer.showError("Мана хүрэлцэхгүй ээ...");
    //     }
    //     currentPlayer.endTurn();
    //     switch currentPlayer;
    //     turnNumber++;
    //   }
    //   declareWinner();
    
    // TODO: declareWinner() — яруу сайхан ASCII баннер
}
```

---

## 🟢 Core: `Deck`

```java
public class Deck {
    // TODO: private List<Card> cards
    
    // TODO: Constructor(List<Card> cards) — зөв 20 картыг хуулж авах
    
    // TODO: shuffle() — Collections.shuffle() ашиглах
    
    // TODO: draw() → Card
    //   - хоосон бол null буцаах (эсвэл тохирох exception)
    //   - эсвэл "fatigue damage" — Hearthstone шиг тоглогч ээлж бүр +1 damage авах
    
    // TODO: size() → int
    
    // TODO: isEmpty() → boolean
}
```

**Дизайн зөвлөгөө:** Deck-ийг "list-ийн wrapper" гэж бод, гэхдээ `List<Card>`-аа шууд `public` болгож болохгүй — **encapsulation**. Зөвхөн `draw()`, `shuffle()`, `size()` method-аар хандана.

---

## 🟡 Stretch: `Turn`

Нэг ээлжийн **snapshot** — хадгалсан эсвэл replay хийхэд хэрэгтэй.

```java
public class Turn {
    // TODO: Талбарууд
    //   - int turnNumber
    //   - String activePlayerName
    //   - List<String> actionsLog  // "Bat played Fireball on Tuya for 4"
    
    // TODO: logAction(String)
    // TODO: toString() — replay-д ашиглах
}
```

---

## 🟡 Stretch: `Battlefield`

CreatureCard-уудыг 2 талд нь хуваан хадгалах.

```java
public class Battlefield {
    // TODO: private List<CreatureCard> player1Creatures
    // TODO: private List<CreatureCard> player2Creatures
    
    // TODO: summon(Player owner, CreatureCard card)
    // TODO: resolveAttacks(Player attacker, Player defender) 
    //   — attacker-ийн creature бүр defender рүү дайрна
    // TODO: removeDead() — health <= 0 creature-уудыг цэвэрлэх
}
```

---

## 🎮 Win condition

Тоглоом дуусах 3 боломжтой нөхцөл:
1. **HP = 0** — хамгийн түгээмэл. Дайсан үхнэ, та хожилт.
2. **Deck хоосон + draw** — optional "fatigue" — картаа барж дууссан тоглогч ээлж бүр нэмэлт damage авна.
3. **Хоёулаа бие биеэ алах** — ижилхэн ээлжинд хоёулаа 0 HP болвол draw.

---

## 📋 Checklist

**Core:**
- [ ] `Game.start()` — тоглоомын loop бүтэн ажилладаг
- [ ] `Deck.shuffle()`, `Deck.draw()` ажиллаж байгаа
- [ ] Win condition зөв илэрдэг, final screen харагддаг

**Stretch:**
- [ ] `Battlefield` класс creature-уудыг зөв handle хийнэ
- [ ] `Turn` object-ыг log эсвэл save-д ашигласан

**Bonus:**
- [ ] Нэг тоглоомыг бүрэн replay хийх боломжтой (Turn log-оос)
