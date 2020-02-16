import java.util.ArrayList;

public class Player extends Person{

	private ArrayList<Card> hand;
	
	public Person(String name){
        super(name,0,null);
		this.hand = new ArrayList<>();
    }
    
    public void addCardToHand(Card c){
        hand.add(c);
    }

    public Card takeCardFromHand(int index){
        Card c = hand.get(index);
        hand.remove(index);
        return c;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }
}