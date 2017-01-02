import java.util.Scanner;
import java.lang.Math;
import java.util.Calendar;

public class daylength{

	public static void main(String[] args){
		/*boolean jatkuu = true;
		Scanner sc = new Scanner(System.in);
		while (jatkuu){
			try{
				System.out.print("Syota leveyspiiri: ");
				int lat = sc.nextInt();
				jatkuu = false;
			}catch (Exception e){
				System.out.println("Jokin meni pieleen, yrita uudelleen!");
			}
		}*/
		int lat = 0;
		Calendar calendar = Calendar.getInstance();
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		//int lowDay = 355;
		//int highDay = lowDay - 183;
		double dayLength = 12.0 + Math.sin((2*Math.PI())*((dayOfYear-183)/365));
		System.out.println(dayLength);
	}

}