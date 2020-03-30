import java.util.*;

public class Deck {
    private List<Card> deck;
    private String[] suits;

    public Deck(String[] suits) {
        this.deck = new ArrayList<>();
        this.suits = suits;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public String[] getSuits() {
        return suits;
    }

    public void setSuits(String[] suits) {
        this.suits = suits;
    }

    public int getSize() {
        return this.deck.size();
    }

    // Creates a deck with given suits
    public void initDeck() {
        for (int i = 0; i < 10; i++) {
            for (String suit : suits) {
                Card card = new Card(suit, i);
                addCard(card);
            }
        }
    }

    // Adds a card to top of the deck
    public void addCard(Card card) {
        deck.add(card);
    }

    // Draws card on top of deck. If deck is empty, throw exception
    public Card drawCard() throws EmptyStackException {
        if (deck.isEmpty())
            throw new EmptyStackException();

        return deck.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    @Override
    public String toString() {
        String output = "===== DECK CONTENTS =====\n";

        for (Card card : deck) {
            output += card.getRank() + " of " + card.getSuit() + "\n";
        }

        return output;
    }
}
