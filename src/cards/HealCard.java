package cards;

public class HealCard extends Card {
    private int healAmount;

    public HealCard(String name, int manaCost, int healAmount) {
        super(name, manaCost);
        this.healAmount = healAmount;
    }

    @Override
    public void play() {
        System.out.println(getName() + " ашиглаж " + healAmount + " HP нөхлөө!");
    }
}
