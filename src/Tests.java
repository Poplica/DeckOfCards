import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertNull;

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
     * Get one card from top of the card deck, return a card
     */
    @Test
    public void DrawCardTest() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        Deck deck = new Deck(suits);

        deck.initDeck();
//        deck.shuffle();
        System.out.println(deck);

        // Draw card
        deck.drawCard();
        System.out.println(deck);
    }

    /**
     * If there is no card left in the deck, return error or exception
     */
    @Test
    public void DrawCardFromEmptyDeckTest() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        Deck deck = new Deck(suits);

        // Exception should be thrown
        try {
            deck.drawCard();
        } catch (EmptyStackException e) {
            assertNull(e.getMessage());
            System.out.println("Deck is empty!");
        }
        System.out.println(deck);
    }

    @Test
    public void SortCardsTest() {
        String[] suits = {"Red","Green","Yellow"};
    }

    @Test
    public void DetermineWinnersTest() {

    }
}
