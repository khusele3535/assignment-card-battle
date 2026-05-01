package cards;

import players.Player;

public class AttackCard extends Card {
    private int damage;

    public AttackCard(String name, int manaCost, int damage) {
        super(name, manaCost);
        this.damage = damage;
    }

    @Override
    public void play(Player owner, Player opponent) {
        System.out.println(owner.getName() + " -> " + getName() + " ашиглаж " + damage + " хохирол учрууллаа!");
        opponent.takeDamage(this.damage);
    }
}
