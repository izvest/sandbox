public enum ESuite{

    SPADE(0, "Spades"),
    CLUB(1, "Clubs"),
    DIAMOND(2, "Diamonds"),
    HEART(3, "Hearts");

    private int value;
    private String name;
    
    ESuite(int value, int name) {
        this.value = value;
        this.name = name;
    }
    
    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
    
}