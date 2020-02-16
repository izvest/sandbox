import java.util.Scanner;

public class Blackjack {
	
	private static Player player;
	private static Deck deck;
	private static boolean play, more = true;
	public static void main(String[] args){
	
		player = new Player("PlayerName");
		deck = new Deck().shuffle();
	  
		while (play){
			player.addCardToHand(deck.drawCard());
			int handValue = 0;
			player.getHand().forEach(card -> handValue += card.getValue());
			if (handValue < 21){
				System.out.println("Your hand: " + player.getHand());
			}
			else {
				more = false;
			}
		}
	}
}