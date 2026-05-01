package cards;

import players.Player;

public class CreatureCard extends Card {
    private int attack;
    private int health;

    public CreatureCard(String name, int manaCost, int attack, int health) {
        super(name, manaCost);
        this.attack = attack;
        this.health = health;
    }

    @Override
    public void play(Player owner, Player opponent) {
        System.out.println(owner.getName() + " '" + getName() + "' хүлэг баатрыг тулаанд дуудлаа! (Attack: " + attack + ")");
        opponent.takeDamage(this.attack);
    }

    public int getAttack() { return attack; }
}
