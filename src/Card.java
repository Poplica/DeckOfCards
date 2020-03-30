public class Card {
    private String suit;
    private int rank;

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }
}
