public class Card {
    private final Suite suite;
    private final Figure figure;
    private boolean isTaken = false;

    public Card(Suite suite, Figure figure) {
        this.suite = suite;
        this.figure = figure;
    }

    public String getCardName() {
        return figure.getFigureName() + suite.getSuiteSymbol();
    }

    public int getCardValue() {
        return figure.getFigureValue();
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void take() {
        isTaken = true;
    }
}
