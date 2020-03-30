import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

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
        Card card = null;
        try {
            card = deck.drawCard();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Card should've been successfully drawn
        assertTrue(card != null && card.getSuit().equals("Clubs") && card.getRank() == 0);
        System.out.println(deck);
    }

    /**
     * If there is no card left in the deck, return error or exception
     */
    @Test
    public void DrawCardFromEmptyDeckTest() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        Deck deck = new Deck(suits);

        try {
            deck.drawCard();
        } catch (Exception e) {
            // Exception should've been thrown
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

        // Sort with new priority
        String[] newSuitOrderPriority = {"Yellow","Green","Red"};
        deck.sortDeck(newSuitOrderPriority);
        System.out.println(deck);
    }

    /**
     * Determine winners: 2 players play the game. They will draw 3 cards by taking turns.
     * Whoever has the high score wins the game. The points are calculated by color point * number in the card
     * (Color point calculation: red=3, yellow=2, green=1)
     */
    @Test
    public void DetermineWinnersTest() throws Exception {
        String[] suits = {"Red","Green","Yellow"};
        Deck deck = new Deck(suits);
        List<Card> player1 = new ArrayList<>(), player2 = new ArrayList<>();
        deck.initDeck();
        deck.shuffle();

        // Both players take turns drawing 3 cards
        for (int i = 0; i < 3; i++) {
            player1.add(deck.drawCard());
            player2.add(deck.drawCard());
        }

        // Calculate score and print winner
        int score1 = getScore(player1), score2 = getScore(player2);
        System.out.println("Player 1's score: " + score1 + "\nPlayer 2's score: " + score2);
        if (score1 == score2) {
            System.out.println("Draw!");
        } else if (score1 > score2) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

    // Calculates score of given player's hand
    private int getScore(List<Card> player) {
        int score = 0;

        for (Card card : player) {
            if (card.getSuit().equals("Red")) {
                score += card.getRank() * 3;
            } else if (card.getSuit().equals("Yellow")) {
                score += card.getRank() * 2;
            } else { // Green
                score += card.getRank();
            }
        }

        return score;
    }
}
