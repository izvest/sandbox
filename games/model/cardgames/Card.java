public class Card{

    private ESuite suite;
    private EValue value;
    
    public Card(ESuite suite, EValue value) {
        this.suite = suite;
        this.value = value;
    }
    
    public String getSuite() {
        return suite.getName();
    }
    
    public String getName() {
        return value.getName() + " of " + suite.getName();
    }
    
    public int getValue() {
        return value.getValue();
    }

    public void setValue(int i){
        value.setValue(i);
    }
}