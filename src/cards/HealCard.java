package cards;
import players.Player;

public class HealCard extends Card {
    private int healAmount;

    public HealCard(String name, int manaCost, int healAmount) {
        super(name, manaCost);
        this.healAmount = healAmount;
    }

    @Override
    public void play(Player owner, Player opponent) {
        System.out.println(owner.getName() + " " + getName() + " ашиглаж " + healAmount + " HP нөхлөө!");
        owner.heal(this.healAmount);
    }
}
