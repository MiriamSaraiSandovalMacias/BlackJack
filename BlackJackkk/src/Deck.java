import java.util.Random;

public class Deck {
    private final Card[] cards;
    private int currentCardIndex = 0;

    public Deck() {
        cards = new Card[52];
        int index = 0;
        for (Suite suite : Suite.values()) {
            for (Figure figure : Figure.values()) {
                cards[index] = new Card(suite, figure);
                index++;
            }
        }
        shuffle();
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int randomIndex = random.nextInt(cards.length);
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }

    public Card drawCard() {
        if (currentCardIndex < cards.length) {
            Card drawnCard = cards[currentCardIndex++];
            drawnCard.take();
            return drawnCard;
        } else {
            System.out.println("No hay más cartas en el mazo.");
            return null;
        }
    }
}
