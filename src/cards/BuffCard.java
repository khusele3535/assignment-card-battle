package cards;

public class BuffCard extends Card {
    private String effect;

    public BuffCard(String name, int manaCost, String effect) {
        super(name, manaCost);
        this.effect = effect;
    }

    @Override
    public void play() {
        System.out.println(getName() + " ашиглаж " + effect + " эффект идэвхжүүллээ!");
    }
}
