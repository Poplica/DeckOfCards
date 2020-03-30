import org.junit.jupiter.api.Test;

public class Tests {

    /**
     * Shuffle cards in the deck:
     * Randomly mix the cards in the card deck, and return a whole deck of cards with a mixed order
     */
    @Test
    public void ShuffleDeckTest() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        Deck deck = new Deck(suits);
        deck.initDeck();
        System.out.println(deck);

        // Shuffle
        deck.shuffle();
        System.out.println(deck);
    }

    /**
     * Get a card from the top of the deck:
     * Get one card from top of the card deck, return a card, and if there is no card left in the deck,
     * return error or exception
     */
    @Test
    public void DrawCardTest() {
//        Deck deck = new Deck();

    }

    @Test

    @Test
    public void DetermineWinnersTest() {

    }
}
