package players;
import java.util.ArrayList;
import cards.Card;

public abstract class Player {
    protected int health = 30;
    protected int mana = 1;
    protected ArrayList<Card> hand = new ArrayList<>();

    public abstract void takeTurn();

    public int getHealth() { return health; }
    public int getMana() { return mana; }
}
