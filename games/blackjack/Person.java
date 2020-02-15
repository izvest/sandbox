public class Person {

	String name;
	int hand;
	boolean play;
	boolean more;
	char nextCard;
	double wins;
	double rounds;
	int ties;
	
	public Person(String name){
		this.name = name;
		if (this.name != "Dealer"){
			System.out.println("Hello, " + this.name);
		}
	}
}