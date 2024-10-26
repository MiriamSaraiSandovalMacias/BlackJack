import java.util.*;

enum Palo {
    CORAZONES, DIAMANTES, TREBOLES, PICAS;
}
class Carta {
    int valor;
    Palo palo;


    public Carta(int valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }
}

public class BlackJack {

    static Carta[] baraja = new Carta[52];
    static int player = 0;
    static int dealer = 0;


    public static void createDeck() {
        int cardValue;
        int cardCount = 0;


        for (Palo palo : Palo.values()) {
            for (int card = 1; card <= 13; card++) {
                switch (card) {
                    case 10: case 11: case 12:
                        cardValue = 10;
                        break;
                    case 13:
                        cardValue = 11;
                        break;
                    default:
                        cardValue = card;
                        break;
                }

                baraja[cardCount] = new Carta(cardValue, palo);
                cardCount++;
            }
        }
    }


    public static void shuffleDeck() {
        List<Carta> cardList = new ArrayList<>();
        Collections.addAll(cardList, baraja);
        Collections.shuffle(cardList);


        for (int i = 0; i < baraja.length; i++) {
            baraja[i] = cardList.get(i);
        }
    }


    public static Carta drawCard() {
        Random rand = new Random();
        int randomCardIndex = rand.nextInt(52);
        return baraja[randomCardIndex];
    }


    public static void showCardsAndDetermineWinner() {

        Carta playerCard1 = drawCard();
        Carta playerCard2 = drawCard();
        player = playerCard1.valor + playerCard2.valor;

        Carta dealerCard1 = drawCard();
        Carta dealerCard2 = drawCard();
        dealer = dealerCard1.valor + dealerCard2.valor;


        System.out.println("Cartas del jugador: " + playerCard1.valor + " de " + playerCard1.palo + ", "
                + playerCard2.valor + " de " + playerCard2.palo + " (Total: " + player + ")");


        System.out.println("Cartas del dealer: " + dealerCard1.valor + " de " + dealerCard1.palo + ", "
                + dealerCard2.valor + " de " + dealerCard2.palo + " (Total: " + dealer + ")");


        if (player == 21) {
            System.out.println("¡El jugador gana con 21!");
        } else if (player > 21) {
            System.out.println("El jugador se pasó de 21, ¡pierde!");
        } else if (dealer > 21) {
            System.out.println("El dealer se pasó de 21, ¡el jugador gana!");
        } else if (player > dealer) {
            System.out.println("El jugador gana con más puntos que el dealer.");
        } else if (dealer > player) {
            System.out.println("El dealer gana con más puntos que el jugador.");
        } else {
            System.out.println("Es un empate.");
        }
    }

    // Método principal
    public static void main(String[] args) {
        createDeck();
        shuffleDeck();
        showCardsAndDetermineWinner();
    }
}
