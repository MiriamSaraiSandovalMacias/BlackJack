public enum Suite {
    HEARTS("Corazones", "♥"),
    DIAMONDS("Diamantes", "♦"),
    CLUBS("Tréboles", "♣"),
    SPADES("Picas", "♠");

    private final String suiteName;
    private final String suiteSymbol;

    Suite(String suiteName, String suiteSymbol) {
        this.suiteName = suiteName;
        this.suiteSymbol = suiteSymbol;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public String getSuiteSymbol() {
        return suiteSymbol;
    }
}
