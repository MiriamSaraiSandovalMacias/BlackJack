public class Blackjack {
    Deck deck;
    Player player;
    Player dealer;

    public Blackjack(String playerName) {
        deck = new Deck();
        player = new Player(playerName);
        dealer = new Player("Dealer");
    }

    public void startGame() {
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        System.out.println("Mano del Jugador: ");
        player.showHand();
        System.out.println("Puntaje del Jugador: " + player.getHandScore());

        System.out.println("Mano del dealer: ");
        dealer.showHand();
        System.out.println("Puntaje del dealer: " + dealer.getHandScore());
    }

    public void getWinner() {
        int playerScore = player.getHandScore();
        int dealerScore = dealer.getHandScore();

        System.out.println("Resultado:");
        if (playerScore > 21) {
            System.out.println(player.getName() + " ha perdido (se pasó de 21).");
        } else if (dealerScore > 21) {
            System.out.println("El Dealer se pasó de 21, " + player.getName() + " gana!");
        } else if (playerScore > dealerScore) {
            System.out.println(player.getName() + " gana con " + playerScore + " puntos.");
        } else if (dealerScore > playerScore) {
            System.out.println("El Dealer gana con " + dealerScore + " puntos.");
        } else {
            System.out.println("Es un empate con " + playerScore + " puntos.");
        }
    }
}
