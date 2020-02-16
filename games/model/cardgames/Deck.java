import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Deck{
 
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        Arrays.asList(ESuits.getValues()).forEach(suit -> {
            Arrays.asList(EValue.getValues()).forEach(value -> {
                if (value != EValues.JOKER){
                    cards.add(new Card(suit, value));
                } 
            });
        });
    }
 
    public void shuffle() {
        Random rnd = new Random();
        for (int i = 0; i < size(); i++) {
            int randomIndex = rnd.nextInt(deckSize());
            Card tmp = (Card)deck.get(randomIndex);
            deck.set(randomIndex, deck.get(i));
            deck.set(i, tmp);
        }
    }
 
    public void fullShuffle() {
        cards = new ArrayList<>();
        Arrays.asList(ESuits.getValues()).forEach(suit -> {
            Arrays.asList(EValue.getValues()).forEach(value -> {
                if (value != EValues.JOKER){
                    cards.add(new Card(suit, value));
                } 
            });
        });
        shuffle();
    }
 
    public Card drawCard() {
        Card card = cards.get(size() - 1);
        deck.remove(size() - 1);
        return card;
    }

    public int size(){
        return cards.size();
    }
 
}