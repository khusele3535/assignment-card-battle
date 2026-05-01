package cards;

public class AttackCard extends Card {
    private int damage;

    public AttackCard(String name, int manaCost, int damage) {
        super(name, manaCost);
        this.damage = damage;
    }

    @Override
    public void play() {
        System.out.println(getName() + " ашиглаж " + damage + " хохирол учрууллаа!");
    }
}
