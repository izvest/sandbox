import java.lang.Thread;
import java.util.List;
import java.util.ArrayList;

public class primefinder{

	public static void main (String[] args){

		List<Integer> primes = new ArrayList<Integer>();
      	primes.add(1);
		boolean found;
		
		for (int i = 2; i < 1000; i++){
			found = true;
          	inner:
			for (int x : primes){
				if (x != 1 && i%x == 0){
					found = false;
					break inner;
				}
				if(x > i/2){
					break inner;
				}
			}
			if (found == true){
				System.out.println("Found: " + i);
				primes.add(i);
				//Thread.sleep(500);
			}
		}
		System.out.println(primes);
	}
}