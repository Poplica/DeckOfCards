import java.util.*;

public class Deck {
    private List<Card> deck;
    private List<String> suits;

    public Deck(String[] suits) {
        this.deck = new ArrayList<>();
        this.suits = Arrays.asList(suits);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public List<String> getSuits() {
        return suits;
    }

    public void setSuits(String[] suits) {
        this.suits = Arrays.asList(suits);
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
    public Card drawCard() throws Exception {
        if (deck.isEmpty())
            throw new Exception();

        return deck.remove(0);
    }

    // Sorts deck by given priority of suit then rank
    public void sortDeck(String[] suitOrderPriority) {
        List<String> arrSuits = Arrays.asList(suitOrderPriority);
        deck.sort((a, b) -> {
            if (!a.getSuit().equals(b.getSuit())) {
                return arrSuits.indexOf(a.getSuit()) - arrSuits.indexOf(b.getSuit());
            } else {
                return a.getRank() - b.getRank();
            }
        });
    }

    // Shuffles the deck
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
