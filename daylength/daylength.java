package daylength;

import java.util.Calendar;
import java.lang.Math;

public class Daylength {
	
	public static Calendar C = Calendar.getInstance();
	
	private static double DAY = C.get(Calendar.DAY_OF_YEAR); //today is n:th day of year
	private static double DIY = C.getActualMaximum(Calendar.DAY_OF_YEAR); //days in this year
	private static double D = 2.0*Math.PI*(0-170.0)/DIY;

	public static void giveLength(int lat, int lon) {
		double length = 12.0 + 14*Math.cos(D)*(lat/90.0);
		int hour = (int)length;
		int min = (int)(6*(length-hour))*10;
		System.out.println("Päivän pituus noin: "+hour+"h "+min+"min "+length);
		System.out.println(D);
	}
	
}