import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    /**
     * Shuffle cards in the deck: randomly mix the cards in the card deck,
     * and return a whole deck of cards with a mixed order
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
     * Get a card from the top of the deck: get one card from top of the card deck, return a card
     */
    @Test
    public void DrawCardTest() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        Deck deck = new Deck(suits);

        deck.initDeck();
//        deck.shuffle();
        System.out.println(deck);

        // Draw card
        Card card = deck.drawCard();
        assertTrue(card.getSuit().equals("Clubs") && card.getRank() == 0);
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

    /**
     * Sort cards: take a list of color as parameter and sort the card in that color order.
     * Numbers should be in ascending order.
     */
    @Test
    public void SortCardsTest() {
        String[] suits = {"Red","Green","Yellow"};
        Deck deck = new Deck(suits);

        deck.addCard(new Card("Red", 1));
        deck.addCard(new Card("Green", 5));
        deck.addCard(new Card("Red", 0));
        deck.addCard(new Card("Yellow", 3));
        deck.addCard(new Card("Green", 2));

        String[] newSuitOrderPriority = {"Yellow","Green","Red"};
        deck.sortDeck(newSuitOrderPriority);
        System.out.println(deck);
    }

    @Test
    public void DetermineWinnersTest() {

    }
}
