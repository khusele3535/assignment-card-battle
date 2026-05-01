# 🎴 Бие Даалт — Card Battle Game

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![JUnit](https://img.shields.io/badge/JUnit-5-green?logo=junit5)
![Project](https://img.shields.io/badge/Бие%20даалт-3--4%20долоо%20хоног-purple)
![UI/UX](https://img.shields.io/badge/UI%2FUX-Deliverable-ff69b4)
![Auto-Grader](https://img.shields.io/badge/Auto--Grader-40%25-blue)
![AI Detection](https://img.shields.io/badge/AI%20Detection-Enabled-red)

> ⚔️ Нэг тулаан, нэг карт — гэвч дор хаяж **7 класс**, таны хийсэн **wireframe**, таны зохиосон **персона**. Энэ бол таны OOP-ийн төгсгөлийн **бие даалт**: Hearthstone, Pokemon TCG, Slay the Spire-аас урам авсан жижиг консолоос хамаарсан карт-тулааны тоглоом. Та эндээс **класс, inheritance, polymorphism, abstraction, exception, collection, file I/O** — бүхний хамтарч ажиллах бодит жишээг **өөрийн тоглоомоор** гаргаж ирнэ.

> 🎨 Та UI/UX мэргэжлийн оюутан. Кодоо сайхан бичих нь хагас ажил. Нөгөө хагас нь **wireframe, персона, UX writing, user testing** — тоглоомоо хэрэглэгчидэд хэрэглэхэд таатай болгох.

---

## 🎯 Зорилго

Энэ бие даалтаар та дараах зүйлсийг **нотлон харуулна**:

**OOP тал:**
- 🏗️ Олон класс хоорондоо ажиллах дизайн (**7+ класс**)
- 🧬 `abstract class`, `extends`, `@Override` — inheritance
- 🎭 Polymorphism — `Card.play()` нь `AttackCard`, `HealCard`, `CreatureCard` дээр өөр өөрөөр ажиллах
- 🔒 Encapsulation — `private` талбар, validation бүхий setter
- 📦 Collections — `List<Card>`, `Map<String, Integer>`, `enum`
- 💥 Exception handling — `IllegalArgumentException`, `InsufficientManaException` гэх мэт
- 💾 File I/O — тоглоомын төлөвийг хадгалах, унших

**UI/UX тал:**
- 🖊️ **5+ wireframe screen** — цаасаар, Figma, Excalidraw — аль ч хэрэгслээр
- 👤 **2 персона** — "хэн чиний тоглоомыг тоглох вэ?"
- ✍️ **UX writing audit** — тоглоомын бүх string-г эелдэг, ойлгомжтой болгох
- 🧪 **User test report** — 3 бодит хүнээр тоглуулж, ажигласан зүйлээ бичих

---

## 📋 Шаардлага (түвшнээр)

### 🟢 Core (60 оноо) — Заавал хийх

- [ ] **Тоглох боломжтой** тоглоом: бодит хүн (console) vs AI (random эсвэл энгийн стратеги)
- [ ] 3 төрлийн карт: **AttackCard**, **HealCard**, **BuffCard**
- [ ] `abstract class Card` — бүгдийн эх класс
- [ ] Хамгийн багадаа **4 класс** зөв `extends`-тэй
- [ ] Player-т 30 HP, ээлж бүрт +1 мана (max 10)
- [ ] Win condition — нэг тал 0 HP болвол тоглоом дуусна
- [ ] `Deck` класс — `shuffle()`, `draw()` method
- [ ] Консол дээр тоглоом ойлгомжтой харагдах (HP, мана, гарт буй картууд)

### 🟡 Stretch (30 оноо) — Дундаж түвшин

- [ ] **CreatureCard** — тулааны талбарт үлдэж, ээлж бүрт довтолно
- [ ] **Rarity систем** — COMMON / RARE / LEGENDARY (power-д нөлөөлнө)
- [ ] **Save/Load** — тоглоомын төлөвийг файлд хадгалах, буцааж унших
- [ ] **10+ өвөрмөц карт** тоглоомд байх
- [ ] Карт бүр сонирхолтой **нэр + тайлбартай** ("Blazing Fireball", "AttackCard1" биш)

### 🔴 Bonus (10 оноо) — Мастер түвшин

- [ ] **AI-ийн стратеги** — random биш, мана, HP-г харгалзан шийдэх
- [ ] **ASCII анимаци** — карт тоглогдох үед 2-3 кадр бүхий харагдацтай
- [ ] **Localization** — МН/EN сонголттой (`Messages.mn`, `Messages.en`)
- [ ] Өөрийн онцлог механик — combo, chain, ёс-заншил, story mode — өөрөө бодож оруулах

---

## 📅 Хугацааны төлөвлөгөө (3 долоо хоног)

> Энэ бол **санал** — өөрийн хурдаараа явж болно. Гэхдээ **долоо хоног бүрт commit** заавал шаардагдана (dev-log.md).

### 📆 Долоо хоног 1 — Design phase

**Гаралт:**
- `docs/wireframes/` — 5+ wireframe (картны нэг кадр, тулааны дэлгэц, main menu, game over, card played animation)
- `docs/personas/README.md` — 2 target персона
- `docs/ux-audit/README.md` — эхний draft (нэр томъёоны журам)
- `CONTRIBUTING.md` — class diagram (ASCII эсвэл линк)
- `docs/dev-log/README.md` — Week 1 reflection (200+ үг)

**Код:** хоосон скелет файлууд бэлэн.

### 📆 Долоо хоног 2 — Core implementation

**Гаралт:**
- `Card` (abstract), `AttackCard`, `HealCard`, `BuffCard` хийгдсэн
- `Player`, `HumanPlayer`, `AIPlayer` ажиллаж байгаа
- `Deck`, `Game` — үндсэн turn loop ажиллаж, энгийн тоглоом тоглох боломжтой
- `dev-log` Week 2 нэмэгдсэн

### 📆 Долоо хоног 3 — Polish + UX

**Гаралт:**
- Stretch (creature, save/load, 10+ карт) оруулсан
- `ConsoleRenderer` — HP bar, мана крисстал, карт ASCII layout гоёмсог
- **User test report** — 3 хүнд тоглуулж үзсэн, 3 сайжруулалт хийсэн
- UX writing audit **эцсийн** хувилбар
- `dev-log` Week 3 + final reflection

---

## 🎨 UI/UX Deliverables (гол хөрөнгө оруулалт — 20 оноо)

Эдгээрийг **код бичихээс өмнө** бодож эхлээрэй. UI/UX оюутны хувьд энэ бол таны давуу тал.

| Даалтын нэр | Хавтас | Формат |
|-------------|--------|--------|
| 🖼️ **5+ Wireframe** | `docs/wireframes/` | PNG / JPG / PDF (cаазаар, Figma, Excalidraw) |
| 👥 **2 Персона** | `docs/personas/README.md` | Markdown (template README-д) |
| ✍️ **UX Writing Audit** | `docs/ux-audit/README.md` | Markdown (string жагсаалт + review) |
| 🧪 **User Test Report** | `docs/user-test-report/README.md` | Markdown (3 хүн, 1 нүүртэй findings) |

Дэлгэрэнгүй: [`docs/wireframes/README.md`](docs/wireframes/README.md)

---

## 📐 Архитектурын санал (заавал биш)

Та өөрийн бүтцээр хийж болно — гэхдээ auto-grader зарим классын нэрийг шалгадаг (`Card`, `AttackCard`, `HealCard`, `BuffCard`, `Player`, `Deck`, `Rarity`). Дараах бүтэц санал болгож байна:

```
src/
├── cards/       — Card (abstract), AttackCard, HealCard, BuffCard, CreatureCard, Rarity (enum)
├── players/     — Player (abstract), HumanPlayer, AIPlayer
├── game/        — Game, Deck, Turn, Battlefield
└── io/          — ConsoleRenderer, GameSaver, InputReader
```

Хавтас бүрт `README.md` бий — дотор нь тухайн компонентын spec, TODO жагсаалт бичсэн.

---

## 🏗️ Хавтасны бүтэц

```
assignment-card-battle/
├── README.md                          # Энэ файл
├── .gitignore
├── src/
│   ├── cards/README.md                # Карт системийн spec
│   ├── players/README.md              # Player системийн spec
│   ├── game/README.md                 # Game loop spec
│   └── io/README.md                   # I/O + persistence spec
├── tests/
│   └── CardBattleTest.java            # Auto-grader тестүүд
├── scripts/
│   ├── run_tests.sh
│   └── ai_detector.py
├── .github/workflows/grade.yml        # CI pipeline
└── docs/
    ├── wireframes/README.md           # UI/UX гол deliverable заавар
    ├── personas/README.md             # (ТА бүтээнэ)
    ├── ux-audit/README.md             # (ТА бүтээнэ)
    ├── user-test-report/README.md     # (ТА бүтээнэ)
    └── dev-log/README.md              # (ТА бүтээнэ — 3 долоо хоногийн dev log)
```

---

## ✅ Үнэлгээний шалгуур (100 оноо)

| Хэсэг | Оноо | Тайлбар |
|-------|------|---------|
| 🧑‍💻 **Code correctness + OOP** | **40** | Auto-grader (class structure, inheritance, method signatures) |
| 🎨 **UI/UX quality** | **20** | Wireframe (10) + UX writing audit (5) + user test report (5) — **гараар шалгана** |
| ✨ **Creativity & polish** | **15** | Картны санаа, тоглоомын flavor, нэмэлт механик — **гараар** |
| 🧪 **Testing (өөрийн)** | **10** | Та 3+ тест нэмж бичсэн байх (`tests/MyOwnTests.java`) |
| 📐 **Code quality** | **10** | Нэрлэх, бүтэц, давтагдалгүй код, AI-ийн ул мөр байхгүй |
| 📚 **Documentation** | **5** | `dev-log`, commit message, readme завсрын тайлбар |

**Auto-grader = нийт оноо биш.** Нийт 60/100 нь **гараар** шалгагдах зүйл (UI/UX + creativity + дотоод тест + quality + docs). UI/UX оюутны хувьд энд таны давуу тал илрэх болно.

---

## 🔄 Submission workflow

1. **Fork** — `UEFA-OPP/assignment-card-battle` repo-г өөр дээрээ fork хийнэ
2. **Clone + branch** — `git checkout -b card-battle/<таны-нэр>`
3. **Долоо хоног бүр commit** — `docs/dev-log/README.md`-д тухайн долоо хоногийн reflection заавал байх
4. **Эцсийн PR** — base: `UEFA-OPP/assignment-card-battle:main`, head: таны branch
5. PR title: `<Нэр> - <бүлэг> - Card Battle` — жишээ: `Bat-Erdene - SE401 - Card Battle`
6. PR body-д wireframe Figma URL (байвал), демо гаралтын screenshot, short pitch (3 өгүүлбэр)

---

## 🏆 Inspiration

- [Hearthstone](https://hearthstone.blizzard.com/) — картны класс, мана, hero power
- [Slay the Spire](https://www.megacrit.com/) — single-player, deck-building
- [Balatro](https://www.playbalatro.com/) — энгийн механикаас өнгийн комбо
- [Pokemon TCG](https://tcg.pokemon.com/) — type strengths/weaknesses
- [Magic: The Gathering](https://magic.wizards.com/) — manacost, keyword abilities

> Санаа хулгайлж болно — гэхдээ **UX-аа өөрөө бодоорой**. Эдгээр нь юуг сайн хийсэн, юуг муу хийсэн гэдгийг сайн ажиглаарай (тэр нь UX audit-д тань орно).

---

## 📚 Материал

- [UEFA-OPP-resources](https://github.com/UEFA-OPP/UEFA-OPP-resources) — теорийн материал
- [week-08-inheritance](https://github.com/UEFA-OPP/UEFA-OPP-resources/tree/main/docs/week-08-inheritance)
- [week-09-polymorphism](https://github.com/UEFA-OPP/UEFA-OPP-resources/tree/main/docs/week-09-polymorphism)
- [week-13-exceptions](https://github.com/UEFA-OPP/UEFA-OPP-resources/tree/main/docs/week-13-exceptions)
- [week-14-io](https://github.com/UEFA-OPP/UEFA-OPP-resources/tree/main/docs/week-14-io)

---

## ⚠️ AI Policy

| Зөвшөөрөгдсөн | Хориотой |
|---------------|----------|
| ✅ Концепци тайлбар авах ("abstract class гэж юу вэ?") | ❌ Код үүсгүүлэх ("Fireball-ийн play() method бичээд өг") |
| ✅ Error message орчуулга асуух | ❌ Бүхэл файл хуулж буулгах |
| ✅ Wireframe-ын санаанд reference хайх | ❌ UX writing-ыг AI-гаар орлуулах |

- **AI detector** auto-grader-т ажиллана. `HIGH` түвшинд 50% хасагдана
- **`dev-log/README.md`** — долоо хоног бүрийн reflection заавал байх: юу сурсан, юу бэрхшээлтэй байсан, яаж шийдсэн
- Dev-log бичгийн хэв маяг нь таны кодын стилийг баталгаажуулна. AI-гаар бичвэрийг нь "өөрчлүүлэх" хэрэггүй — цэвэр өөрийн үгээр бичээрэй

---

## 🛠️ Шаардлага

- **Java 17+** (`java -version`)
- **Python 3.11+** (AI detector + scripts)
- **Bash** (тест ажиллуулах)
- **Git** (commit, push, PR)
- **Figma / Excalidraw / Paper + камер** (wireframe-д)

---

## 📞 Асуулт

Багшаасаа Discord / classroom channel-аар асуу. **Долоо хоног бүрийн хугацаанд бүх асуулт хариултай байна** — тиймээс хугацаандаа бууж эхэл. Амжилт, дайчин! ⚔️🎴
