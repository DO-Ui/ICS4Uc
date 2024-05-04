import java.util.ArrayList;


public class Deck {
    private ArrayList<Cards> deck = {
        Cards.ACE,
        Cards.TWO,
        Cards.THREE,
        Cards.FOUR,
        Cards.FIVE,
        Cards.SIX,
        Cards.SEVEN,
        Cards.EIGHT,
        Cards.NINE,
        Cards.TEN,
        Cards.JACK,
        Cards.QUEEN,
        Cards.KING
    };

    public Deck() {
        
    }

    public Cards draw() {
        return deck.remove(0);
    }

    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int randomIndex = (int) (Math.random() * deck.size());
            Cards temp = deck.get(i);
            deck.set(i, deck.get(randomIndex));
            deck.set(randomIndex, temp);
        }
    }

    public int size() {
        return deck.size();
    }

}
