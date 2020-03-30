import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Deck {
    private Stack<Card> deck;

    public Deck() {
        this.deck = new Stack<>();
    }

    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public int getSize() {
        return this.deck.size();
    }

    // Draws card on top of deck
    // If deck is empty, throw exception
    public Card drawCard() throws EmptyStackException {
        if (deck.isEmpty())
            throw new EmptyStackException();

        return deck.pop();
    }
}
