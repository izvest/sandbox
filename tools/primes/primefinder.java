import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Primefinder{

	public static void main (String[] args) throws InterruptedException{
		
		int sample = Integer.parseInt(args[0]);
		
		long startTime = System.nanoTime();
		int count = findA(sample);
		long endTime = (System.nanoTime()- startTime)/1000000;  //divide by 1000000 to get milliseconds
		System.out.println("findA found " + count + " primes in " + endTime + " ms. (" + sample + ")");

		long startTime2 = System.nanoTime();
		int count2 = findB(sample);
		long endTime2 = (System.nanoTime()- startTime2)/1000000;  //divide by 1000000 to get milliseconds
		System.out.println("findB found " + count2 + " primes in " + endTime2 + " ms. (" + sample + ")");
	}

	private static int findA(int range){
		List<Integer> primes = new ArrayList<Integer>();
		boolean found;

		for (int i = 2; i <= range; i++){
			found = true;
			inner:
			for (int x : primes){
				if (i%x == 0){ //is dividable by x?
					found = false;
					break inner;
				}
				if(x*x > i){ //(x*x > i), (x > Math.sqrt(i)) or (x > sqrtA(i))
					break inner;
				}
			}
			if (found == true){
				primes.add(i);
			}
		}
		return primes.size();
	}

	private static int findB(int range){
		ArrayList<Integer> primes = new ArrayList<>();
		primes.add(2);
		
		for (int i = 3; i <= range; i+=2){
			for (int x : primes){
				if (i%x == 0){
					break;
				}
				else if (x*x > i){
					primes.add(i);
					break;
				}
			}	
		}
		return primes.size();
	}
	
	/*public static int sqrtA(int n){ //Trying to make a quicker way to approximate square roots (And failing miserably...)
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
	}*/
}
