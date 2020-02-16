public enum ESex{

    FEMALE(0),
    MALE(1),
    OTHER(2);

    private int value;

    ESex(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}