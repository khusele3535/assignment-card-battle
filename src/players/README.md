# 🧑‍🎤 `players/` — Тоглогчийн систем

Хоёр төрлийн тоглогч: **бодит хүн** (консолоос оролт авна) ба **AI** (өөрөө шийднэ). Хоёулаа адил **Player** эцгээс inheritance авна.

---

## 📐 Бүтэц

```
players/
├── Player.java         # abstract class — нийтлэг төлөв, method
├── HumanPlayer.java    # Console-оос оролт
└── AIPlayer.java       # Өөрөө шийднэ
```

---

## 🟢 Core: `abstract class Player`

```java
public abstract class Player {
    // TODO: Талбарууд (protected эсвэл private + getter/setter)
    //   - String name
    //   - int hp            // анх 30
    //   - int maxHp         // 30
    //   - int mana          // анх 3
    //   - int maxMana       // анх 3, max 10 хүртэл өсөх
    //   - Deck deck         // 20 картны багц
    //   - List<Card> hand   // гарт буй картууд (max 7)
    //   - List<CreatureCard> battlefield  // 🟡 Stretch — талбарт буй амьтад
    //   - int nextAttackBonus  // BuffCard-ийн нөлөө
    
    // TODO: Constructor — нэр + deck авна, анхны 5 карт татах
    
    // TODO: drawCard() — deck-ээс 1 карт hand-д нэмэх (max 7-оос хэтрэхгүй)
    
    // TODO: playCard(int handIndex, Player opponent)
    //   - hand.get(handIndex)-ийг авах
    //   - manaCost шалгах — хүрэлцэхгүй бол throw InsufficientManaException
    //   - mana -= manaCost
    //   - card.play(this, opponent) дуудах
    //   - hand-аас хасах
    
    // TODO: takeDamage(int amount)
    //   - hp = Math.max(0, hp - amount)
    //   - сөрөг оролт → IllegalArgumentException
    
    // TODO: heal(int amount) — maxHp-аас хэтрэхгүй
    
    // TODO: startTurn() — maxMana += 1 (max 10-аас хэтрэхгүй), mana = maxMana, drawCard()
    
    // TODO: endTurn() — 🟡 battlefield дахь creature-ууд дайсан руу дайрна
    
    // TODO: isAlive() → boolean  (hp > 0)
    
    // TODO: abstract chooseCard(Player opponent) → int  
    //   Human/AI өөрсдийн аргаар hand-аас index сонгоно
}
```

---

## 🟢 Core: `HumanPlayer extends Player`

```java
public class HumanPlayer extends Player {
    // TODO: Constructor — super() дуудах
    
    // TODO: chooseCard() override —
    //   - hand-ыг консолоор хэвлэх (0, 1, 2, ... indexтэй)
    //   - Scanner-ээс int авах
    //   - -1 оруулбал "pass turn" (жишээ convention)
    //   - буруу оролт → дахин асуух (loop хүртэл зөв болтол)
}
```

**UX Note:** Оролт буруу үед "Error" гэж хэлэхгүй. **Эелдэг** байгаарай:
- ❌ `"Error: Invalid index"`
- ✅ `"Тоо 0-ээс 6 хооронд оруулна уу (эсвэл -1 дарвал ээлж дуусах)"`

---

## 🟡 Stretch: `AIPlayer extends Player`

```java
public class AIPlayer extends Player {
    // TODO: Constructor
    
    // TODO: chooseCard() override —
    //   🟢 Core үед: random сонголт (Math.random() * hand.size())
    //   🔴 Bonus: стратегийн логик — 
    //         - HP бага бол HealCard эрэмбэ
    //         - Мана хангалттай бол хамгийн their damage-тай AttackCard
    //         - BuffCard + AttackCard combo
}
```

---

## 💥 Exception: `InsufficientManaException`

```java
public class InsufficientManaException extends RuntimeException {
    public InsufficientManaException(String message) {
        super(message);
    }
}
```

**UX Note:** Exception-ийн message нь **эцсийн тоглогчид харагдахгүй** ёстой. Game loop эдгээрийг **catch хийж**, эелдэг мессеж харуулна:

```java
try {
    player.playCard(index, opponent);
} catch (InsufficientManaException ex) {
    renderer.showError("Мана хүрэлцэхгүй ээ, өөр карт сонгоно уу.");
}
```

---

## 📋 Checklist

**Core:**
- [ ] `Player` abstract class — шууд `new Player(...)` боломжгүй
- [ ] `HumanPlayer`, `AIPlayer` нь `Player`-аас extends
- [ ] `drawCard`, `playCard`, `takeDamage`, `heal` method ажиллаж байгаа
- [ ] `InsufficientManaException` throw хийгдэж байгаа
- [ ] Мана ээлж бүрт +1 өсөх, max 10

**Stretch:**
- [ ] `battlefield` list байгаа, creature-ууд ээлж бүр довтолно
- [ ] `nextAttackBonus` нь BuffCard-тай зөв холбогдсон

**Bonus:**
- [ ] AI нь стратегийн логиктой (random биш)
