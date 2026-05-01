# 🖥️ `io/` — Input / Output + Persistence

Тоглогч кодыг **хардаггүй** — тоглогч зөвхөн **консолын output** + **өөрийн оруулсан зүйл**-ийг хардаг. Тиймээс I/O хэсэг бол таны UI/UX-ын ШУУД туршилт.

---

## 📐 Бүтэц

```
io/
├── ConsoleRenderer.java   # Тоглоомын төлөвийг дэлгэцэд зурах
├── InputReader.java       # Scanner wrapper + validation
└── GameSaver.java         # 🟡 Stretch — save/load
```

---

## 🟢 Core: `ConsoleRenderer`

Энэ бол таны **UI layer**. Картнууд, HP bar, мана крисстал, тоглоомын төлөвийг сайхан харагдуулах үүрэгтэй.

```java
public class ConsoleRenderer {
    // TODO: render(Game game) — дэлгэцийг цэвэрлэх + шинэ төлөв зурах
    
    // TODO: renderPlayer(Player p) —
    //   "Bat-Erdene  HP: ██████░░░░ 18/30  Мана: ◆◆◆◆◇ 4/5"
    
    // TODO: renderHand(List<Card> hand) —
    //   Нэг картыг ASCII box шиг зурах:
    //   ┌──────────────┐
    //   │ 🔥 Fireball  │
    //   │ Мана: 3      │
    //   │ Damage: 4    │
    //   │ [COMMON]     │
    //   └──────────────┘
    
    // TODO: renderBattlefield(Battlefield bf) — 🟡 Stretch
    
    // TODO: showError(String friendlyMessage) — улаан өнгөөр
    
    // TODO: showAnnouncement(String) — тод өнгөөр (шинэ ээлж, wow moment)
}
```

**ASCII reference:**

- HP bar: `█` (дүүрэн), `░` (хоосон). Жишээ: `██████░░░░ 6/10`
- Мана: `◆` (дүүрэн), `◇` (хоосон). Жишээ: `◆◆◆◇◇ 3/5`
- Тоглоомын баннер:
  ```
  ╔════════════════════════════╗
  ║   ⚔️  CARD BATTLE  ⚔️      ║
  ║   Turn 5 — Bat's move      ║
  ╚════════════════════════════╝
  ```

---

## 🟢 Core: `InputReader`

```java
public class InputReader {
    // TODO: private Scanner scanner
    
    // TODO: readInt(String prompt, int min, int max) → int
    //   - prompt-ыг хэвлэх
    //   - int авах, хамрагдах мужид байна уу шалгах
    //   - буруу бол дахин асуух (while loop)
    //   - catch NumberFormatException
    
    // TODO: readString(String prompt) → String
    
    // TODO: readYesNo(String prompt) → boolean
    //   - "y", "yes", "тийм", "т" → true
    //   - "n", "no", "үгүй", "ү" → false
    //   - UX: олон хариултыг дэмжих
}
```

**UX Note:** `readInt` нь **хэзээ ч крашдаж болохгүй**. `NumberFormatException`-ыг catch хийж, эелдэгээр дахин асуух:

```java
// ❌ Муу
int x = scanner.nextInt(); // "abc" оруулбал крашдана

// ✅ Сайн
while (true) {
    System.out.print("Тоо оруулна уу (0-6): ");
    String raw = scanner.nextLine();
    try {
        int x = Integer.parseInt(raw.trim());
        if (x >= 0 && x <= 6) return x;
        System.out.println("0-6 хооронд байх ёстой шүү ээ.");
    } catch (NumberFormatException e) {
        System.out.println("Тоо оруулна уу — 0-6 хооронд.");
    }
}
```

---

## 🟡 Stretch: `GameSaver`

Тоглоомын төлөвийг файлд хадгалж, дараа нь үргэлжлүүлэх боломжтой. Lab 14-тэй төстэй.

```java
public class GameSaver {
    // TODO: save(Game game, String filepath) throws IOException
    //   Format-ыг өөрөө сонгох:
    //     - Text/CSV/JSON шиг хүний уншихуйц (preferred debug-д)
    //     - Жишээ формат:
    //         TURN=5
    //         P1=Bat,hp=18,mana=4,maxMana=5,deck=Fireball;Heal;Goblin;...
    //         P2=Tuya,hp=22,...
    
    // TODO: load(String filepath) → Game throws IOException
    //   - Файлыг задлан, Player, Card, Deck үүсгэх
    //   - Файл байхгүй → FileNotFoundException catch хийх
    //   - Файл гэмтсэн → тодорхой сэржилттэй exception (e.g., CorruptSaveException)
}
```

**UX Note:** Save file-д ямар нэг энгийн header нэм: `# Card Battle Save v1`. Дараагийн version гарахад version шалгах боломжтой.

---

## ✍️ UX Writing Guidelines (ЗААВАЛ УНШИХ)

Тоглоом дахь **бүх string-ийг хэн нэгэн унших** гэдгийг бод. Дараах зарчмыг баримтал:

### 1. Хэрэглэгч рүү чиглэсэн
- ❌ `"Error 401: InsufficientManaException thrown at playCard()"`
- ✅ `"Мана хүрэлцэхгүй ээ, өөр карт сонгоно уу."`

### 2. Активлаг (active voice)
- ❌ `"Card has been played."`
- ✅ `"Чи Fireball тоглолоо."`

### 3. Эх хэлээр
Монгол тоглоомын хувьд **монгол** гол хэл. Англи нь зөвхөн карт нэр (эсвэл орчуулахгүй) дотор байж болно.

### 4. Тусламж хэрэгтэй газар
- Шинэ ээлжийн эхэнд "Эхний удаа тоглож байна уу? `?` дарвал тусламж гарна" гэх нэмэлт
- Эхний карт тоглох үед "Анх удаа карт тоглож байна — ээлж дуусмагц `-1` дарна"

### 5. Тонарыг тогтоо
Таны тоглоом нь **дайчин** уу, **хөгжилтэй** үү, **шидэт** үү? Сонгосон тонар бүх string-д нийцсэн байх ёстой:

| Tone | Damage-ын мессеж |
|------|------------------|
| 🗡️ Dramatic | "Галын бөмбөг дайсны зүрхэн дээр тусч, 4 хохирол учруулав!" |
| 😊 Friendly | "Сайн унш! 4 damage өглөө." |
| 🧊 Minimal | "4 damage." |

---

## 📋 Checklist

**Core:**
- [ ] `ConsoleRenderer` класс байгаа, HP bar + мана зурна
- [ ] `InputReader` буруу оролтод краш хийхгүй
- [ ] Error message бүгд эелдэг, тоглогч ойлгомжтой

**Stretch:**
- [ ] `GameSaver.save()` + `load()` ажиллаж, тоглоомыг буцаан авах боломжтой
- [ ] Save file-т version header бий

**Bonus:**
- [ ] Tone бүрэн зөв, таны UX writing audit-тай тохирсон
- [ ] Help text ("?") оюутан хэрэгтэй газар нэмсэн
