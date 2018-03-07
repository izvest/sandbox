import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class primefinder{

	public static void main (String[] args) throws InterruptedException{
      
		long startTime = System.nanoTime();
		List<Integer> primes = new ArrayList<Integer>();
		boolean found;
		int sample = 1000000;
		int tenth = 1;
		
		for (int i = 2; i <= sample; i++){
			found = true;
			inner:
			for (int x : primes){
				if (i%x == 0){ //is dividable by x?
					found = false;
					break inner;
				}
				if(x > Math.sqrt(i)){ //(x*x > i) or (x > sqrtA(i))
					break inner;
				}
			}
			if (found == true){
				primes.add(i);
			}
			if (primes.size() == tenth*1000){ //lap times
				long lapTime = (System.nanoTime()-startTime)/1000000;
				System.out.println(primes.size() + " primes found in " + lapTime + " ms. (" + i + ")");
				tenth *= 10;
			}
		}
      
	long endTime = (System.nanoTime()- startTime)/1000000;  //divide by 1000000 to get milliseconds
	System.out.println(primes.size() + " primes found in " + endTime + " ms. (" + sample + ")");
	}
	
	public static int sqrtA(int n){ //Trying to make a quicker way to approximate square roots (And failing miserably...)
		double epsilon = 1;
		double high = (double)n;
		double low = 0.0;
		double aprx = 0.0;
		
		while (high-low > epsilon){
			aprx = (high+low)/2;
			if (aprx*aprx > n){
				high = aprx;
			}
			else {
				low = aprx;
			}
		}
		return (int)(aprx + epsilon);
	}
}
