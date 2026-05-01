package cards;

import players.Player;

public class BuffCard extends Card {
    private String effect;

    public BuffCard(String name, int manaCost, String effect) {
        super(name, manaCost);
        this.effect = effect;
    }

    @Override
    public void play(Player owner, Player opponent) {
        System.out.println(owner.getName() + " " + getName() + " ашиглаж " + effect + " эффект идэвхжүүллээ!");
        // Одоогоор BuffCard зөвхөн текст хэвлэнэ, логикийг нь Week 3-т гүйцээнэ
    }
}
