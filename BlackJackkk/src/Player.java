import java.util.ArrayList;

public class Player {
    private final String name;
    private final ArrayList<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void showHand() {
        System.out.print("Mano de "+name);
        for (Card card : cards) {
            System.out.print(card.getCardName() + " ");
        }
        System.out.println();
    }

    public int getHandScore() {
        int score = 0;
        for (Card card : cards) {
            score += card.getCardValue();
        }
        return score;
    }

    public String getName() {
        return name;
    }
}

