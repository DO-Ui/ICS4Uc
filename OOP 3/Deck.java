import java.util.ArrayList;

import javax.smartcardio.Card;

public class Deck {
    private ArrayList<Card> deck = {
        Card.ACE,
        Card.TWO,
        Card.THREE,
        Card.FOUR,
        Card.FIVE,
        Card.SIX,
        Card.SEVEN,
        Card.EIGHT,
        Card.NINE,
        Card.TEN,
        Card.JACK,
        Card.QUEEN,
        Card.KING
    };

    public Deck() {
        
    }

    public Card draw() {
        return deck.remove(0);
    }

    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int randomIndex = (int) (Math.random() * deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(randomIndex));
            deck.set(randomIndex, temp);
        }
    }

    public int size() {
        return deck.size();
    }

}
