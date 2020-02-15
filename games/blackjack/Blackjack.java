import java.util.Scanner;

public class Blackjack {
	
	public static void main (String[] args){
	
	  Scanner input = new Scanner(System.in);
	  System.out.println("Your name?");
	  Person player = new Person(input.nextLine());
	  Deck deck = new Deck();
	  deck.fullShuffle();
	  
	  player.play = true;
	  
	  while (player.play == true){
	     
	   player.hand = 0;
	   player.more = true;
	   player.nextCard = 'y';
	   player.rounds += 1;
	   
	   //Pelaajan peli
	   System.out.println("Shufflin' deck...");
	   player.hand += deck.drawCard(); //pelaajalle 1. kortti
	   while (player.more == true) {
	    if (player.hand < 21 && player.nextCard == 'y'){
	     System.out.println("Your hand: " + player.hand);
	     System.out.println("Another card? [y/n]");
	     player.nextCard = input.next().charAt(0);
	     if (player.nextCard == 'y'){
	      player.hand += deck.drawCard(); //pelaajalle X. kortti
	     }
	    }
	    else {
	     player.more = false; //ei enaa uutta korttia
	    }
	   }
	   
	   if (player.hand <= 21){  //jatketaan pelia
		
		 //Jakajan peli
		 Person dealer = new Person("Dealer");
		   
		 dealer.play = true;
		 dealer.hand = 0;
		   
		 while (dealer.play == true){
		     
		  dealer.more = true;
		    
		  dealer.hand += deck.dealerDrawCard(); //jakajalle 1. kortti
		  while (dealer.more == true) {
		   if (dealer.hand < 17){
		    dealer.hand += deck.dealerDrawCard(); //pelaajalle X. kortti
		   }
		   else {
		    dealer.more = false; //ei enaa uutta korttia
		   }
		  }
		  dealer.play = false;
		 } 
		  
	    if (player.hand > dealer.hand && dealer.hand  <= 21){
	     System.out.println("Your hand: " + player.hand);
	     System.out.println("Dealers hand: " + dealer.hand);
	     System.out.println("You got a bigger hand than the dealer. You win.");
	     player.wins += 1.0;
	    
	    }
	    else if (dealer.hand  > 21){
	     System.out.println("Your hand: " + player.hand);
	     System.out.println("Dealer's hand: " + dealer.hand);
	     System.out.println("Dealer's hand was too big. You win.");
	     player.wins += 1.0;
	    }
	    else if (player.hand == dealer.hand){
	     System.out.println("Your hand: " + player.hand);
	     System.out.println("Dealer's hand: " + dealer.hand);
	     System.out.println("It's a tie.");
	     player.ties += 1;
	    }
	    else if (player.hand < dealer.hand){
		 System.out.println("Your hand: " + player.hand);
		 System.out.println("Dealer's hand: " + dealer.hand);
		 System.out.println("Your hand was smaller. Dealer wins.");
		}
	    else {
	     System.out.println("Your hand was too big. Dealer wins.");
	    }
	   }
	  else{ //kasi yli 21
	   System.out.println("You lost.");
	  }
	  System.out.println("Play again? [y/n]");
	  char jatko = input.next().charAt(0);
	  if (jatko == 'n'){
	   player.play = false; //lopetaa pelin
	  }
	 }
	 System.out.println("You won " + (int)((player.wins/player.rounds)*100) + "% of your games.");
	 System.out.println("You also had " + player.ties + " ties.");
	 input.close();
	 System.out.println("Thanks for playing!");
	 }
	}