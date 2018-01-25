import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class primefinder{

	public static void main (String[] args) throws InterruptedException{
      
      	long startTime = System.nanoTime();

		List<Integer> primes = new ArrayList<Integer>();
		boolean found;
      	int sample = 10000;
		
		for (int i = 2; i <= sample; i++){
			found = true;
          	inner:
			for (int x : primes){
				if (i%x == 0){
					found = false;
					break inner;
				}
				if(x > (int)Math.sqrt(i)){
					break inner;
				}
			}
			if (found == true){
				primes.add(i);
			}
		}
      
      	long endTime = System.nanoTime();
      	long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
      
		//System.out.println(primes);
      	System.out.println("Primes found: " + primes.size() + " out of " + sample);
      	System.out.println("Runtime: " + duration + "ms");
	}
}