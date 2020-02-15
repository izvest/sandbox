package daylength;

import java.util.Calendar;
import java.lang.Math;

public class Daylength {
	
	private static Calendar C = Calendar.getInstance();
	
	private static double day = C.get(Calendar.DAY_OF_YEAR); //today is n:th day of year
	private static double DiY = C.getActualMaximum(Calendar.DAY_OF_YEAR); //days in this year
	private static double D = 2.0*Math.PI*((day-DiY/4)/DiY);

	private double giveLength(int lat) {
		return 12.0 + 12*Math.cos(D)*(lat/66.0);	
	}

	public static void length(int lat) {
		if (giveLength(lat) < 0.0){
			System.out.println("Kaamos");
		}
		else if (giveLength(lat) > 24.0){
			System.out.println("Yoton yo");
		}
		else{System.out.println(giveLength(lat));}
	}
	
}