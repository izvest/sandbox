import java.util.Random;
import java.util.ArrayList;

public class Deck{
 
 ArrayList<Card> deck = new ArrayList<Card>();
 
 // Sekoittaa pakan
 public void shuffle() {
  Random rnd = new Random();
  int index = 0;
  int randomIndex = 0;
  for (int i = 0; i < deckSize(); i++) {
   index = i;
   randomIndex = rnd.nextInt(deckSize());
   Card tmp = (Card)deck.get(randomIndex);
   deck.set(randomIndex, deck.get(index));
   deck.set(index, tmp);
  }
 }
 
 // Luo 52 kortin pakan ja sekoittaa sen
 public ArrayList<Card> fullShuffle() {
   for (int i = deckSize(); i > 0; i--) {
    deck.remove(deckSize() - 1); 
   }
   for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 13; j++) {
     deck.add(new Card(i, j));
    }
   }
   shuffle();
   return deck;
 }
 
 // Konstruktori
 public Deck() {
  fullShuffle();
 }
 
 // Nostaa kortin, kertoo sen tiedot ja palauttaa arvon kokonaislukuna
 public int drawCard() {
  Card card = (Card)deck.get(deckSize() - 1);
  deck.remove(deckSize() - 1);
  System.out.println("You got " + card.getName() + " of " + card.getLand());
  System.out.println("-------------------------");
  return card.getValue();
  }
 
 public int dealerDrawCard() {
  Card card = (Card)deck.get(deckSize() - 1);
  deck.remove(deckSize() - 1);
  System.out.println("Dealer got " + card.getName() + " of " + card.getLand());
  System.out.println("-------------------------");
  return card.getValue();
 }
 
 // Palauttaa korttipakan koon
 public int deckSize() {
  return deck.size();
 }
}
 




class Card{

 // Maat esitettyina niiden englanninkielisten alkukirjainten mukaan
 String [] lands = {"Spades", "Clubs", "Diamonds", "Hearts"};
 
 // Korttien numero/kirjain
 String [] letters = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
 String land = "0";
 int value = 0;
 String name = "0";
 
 // Konstruktori
 public Card(int landIndex, int valueIndex) {
  land = lands[landIndex];
  name = letters[valueIndex];
  if (valueIndex < 8) {
   value = Integer.parseInt(letters[valueIndex]); 
 }
  else if (valueIndex >= 8 && valueIndex < 12) {
   value = 10;
  }
  else {
   value = 11;
  }
 }
 
 // kortin maa
 public String getLand() {
  return land;
 }
 
  // kortin nimi
  public String getName() {
  return name;
 }
 
  // kortin arvo (Blackjackissa)
  public int getValue() {
  return value;
 }
}