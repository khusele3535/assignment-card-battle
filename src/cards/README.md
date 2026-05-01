# 🎴 `cards/` — Картны систем

Энэ бол тоглоомын зүрх. Бүх төрлийн карт эндээс үүсэх ёстой — **abstract class** + түүний хүүхдүүд.

---

## 📐 Бүтэц

```
cards/
├── Card.java             # abstract class — бүх картны эх
├── AttackCard.java       # хохирол өгөх
├── HealCard.java         # өөрийгөө эдгээх
├── BuffCard.java         # дараагийн attack-ын damage-ыг нэмэх
├── CreatureCard.java     # 🟡 Stretch — тулааны талбарт үлдэх амьтан
└── Rarity.java           # enum — COMMON, RARE, LEGENDARY
```

---

## 🟢 Core: `abstract class Card`

```java
public abstract class Card {
    // TODO: Талбарууд (protected эсвэл private + getter)
    //   - String name
    //   - int manaCost
    //   - String description
    //   - Rarity rarity
    
    // TODO: Constructor
    //   public Card(String name, int manaCost, String description, Rarity rarity)
    
    // TODO: Abstract method — бүх child class заавал implement хийх ёстой
    //   public abstract void play(Player self, Player opponent);
    
    // TODO: Getter-ууд (getName, getManaCost, getDescription, getRarity)
    
    // TODO: toString() override — карт нэг мөрөөр сайхан хэвлэгдэх
    //   Жишээ: "🔥 Blazing Fireball (3 мана) — 4 хохирол өгнө [RARE]"
}
```

**Санамж:** `play()` нь abstract — `Card card = new Card(...)` гэж шууд үүсгэж болохгүй. Зөвхөн `AttackCard`, `HealCard` гэх мэт child class-аар үүсгэнэ.

---

## 🟢 Core: `AttackCard extends Card`

```java
public class AttackCard extends Card {
    // TODO: Нэмэлт талбар — int damage
    
    // TODO: Constructor — эцэг Card constructor-ыг super()-ээр дуудах
    //   public AttackCard(String name, int manaCost, String description, Rarity rarity, int damage)
    
    // TODO: play() override —
    //   opponent.takeDamage(damage)
    //   (заавал manaCost-ыг self-ээс хасах — гэхдээ тэр нь Player-ийн playCard method-ын үүрэг)
}
```

**Жишээ карт:**
```java
new AttackCard("🔥 Fireball", 3, "Дайсан руу 4 хохирол", Rarity.COMMON, 4);
new AttackCard("⚡ Lightning Bolt", 2, "3 хохирол, хурдан", Rarity.COMMON, 3);
new AttackCard("💀 Death Strike", 7, "Асар их 10 хохирол", Rarity.LEGENDARY, 10);
```

---

## 🟢 Core: `HealCard extends Card`

```java
public class HealCard extends Card {
    // TODO: int healAmount
    // TODO: Constructor
    // TODO: play() — self.heal(healAmount)
}
```

---

## 🟢 Core: `BuffCard extends Card`

`BuffCard` нь дараагийн **attack card-ын damage-ыг нэмэх** үүрэгтэй. Тиймээс Player-т `nextAttackBonus` гэх талбар нэмэх шаардлагатай (мөн AttackCard.play()-д энэ бонус нэмэгдэнэ, дараа нь `nextAttackBonus = 0` болно).

```java
public class BuffCard extends Card {
    // TODO: int buffAmount
    // TODO: Constructor
    // TODO: play() — self.addAttackBuff(buffAmount)
}
```

**Жишээ:**
```java
new BuffCard("⚔️ Sharpened Blade", 1, "+2 damage дараагийн attack-д", Rarity.COMMON, 2);
```

---

## 🟡 Stretch: `CreatureCard extends Card`

Амьтны карт нь тоглогдсоны дараа **тулааны талбарт үлдэнэ**. Ээлж бүрт тухайн амьтан дайсан руу дайрна. HP-тэй — дайсны attack хүлээж авна.

```java
public class CreatureCard extends Card {
    // TODO: int health
    // TODO: int attackPower
    // TODO: Constructor
    // TODO: play() — self.getBattlefield().add(this); self.battlefield-т нэмэгдэнэ
    // TODO: attack(Player opponent) — opponent.takeDamage(attackPower)
    // TODO: takeDamage(int) — health -= amount, health <= 0 бол талбараас хасах
}
```

**Жишээ:**
```java
new CreatureCard("🐺 Goblin Wolf", 2, "Хурдан амьтан", Rarity.COMMON, /*hp=*/2, /*atk=*/2);
new CreatureCard("🐲 Ancient Dragon", 8, "Домогт луу", Rarity.LEGENDARY, /*hp=*/8, /*atk=*/8);
```

---

## 🎨 Rarity enum

```java
public enum Rarity {
    COMMON,   // Хамгийн түгээмэл
    RARE,     // Ховор
    LEGENDARY // Домогт — тоглоомд 1-2-оос илүү байх нь тэнцэлгүй
}
```

**Дизайн зөвлөгөө:** rarity нь картны **power** + **үнэтэй байдал**-тай харилцан зохицох ёстой. Жишээ нь:
- COMMON Fireball: 3 мана, 4 damage
- RARE Fireball: 3 мана, 5 damage (илүү үр ашигтай)
- LEGENDARY Fireball: 3 мана, 7 damage + AoE

---

## ✍️ UX Note: Картны нэр + тайлбар

> 🔴 **Хамгийн түгээмэл буруу нь:** `new AttackCard("AttackCard1", 3, "Attack", ...)`

Картны **нэр** + **тайлбар** нь таны тоглоомын зан чанар. Тоглогч нь кодыг уншиж байгаа биш — **нэрээ уншиж байгаа**.

| ❌ Муу | ✅ Сайн |
|--------|---------|
| `"Attack1"` | `"🔥 Blazing Fireball"` |
| `"Heal"` | `"🍀 Morning Dew"` |
| `"Buff1"` | `"⚔️ Sharpened Blade"` |
| `"4 damage"` | `"Дайсны зүрх рүү галын бөмбөг илгээнэ — 4 хохирол"` |

Картны нэр бол таны **brand**. Энэ бол UX writing-ын эхний алхам.

---

## 📋 Checklist

**Core:**
- [ ] `Card` класс `abstract` — шууд `new Card(...)` боломжгүй
- [ ] `Card`-д `play()` abstract method байна
- [ ] `AttackCard`, `HealCard`, `BuffCard` нь `Card`-аас extends
- [ ] `Rarity` enum 3 утгатай
- [ ] Constructor нь `super()` дуудна
- [ ] `toString()` override хийгдсэн

**Stretch:**
- [ ] `CreatureCard extends Card`
- [ ] Тоглоомд 10+ өвөрмөц карт байгаа

**Bonus:**
- [ ] Картны нэр/тайлбар хүмүүсэд дэрсэн байх — жишээ: "Blazing Fireball" биш "AttackCard1"
- [ ] Rarity-тай холбоотой балансын логик (LEGENDARY нь тоглоомд 1-2-оос илүү биш)
