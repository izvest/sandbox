import java.util.Scanner;

public class when_bored{

	public static void main(String[] args){
		boolean jatkuu = true;
		Scanner sc = new Scanner(System.in);
		while (jatkuu){
			try{
				System.out.print("Onko tekmattomia hommia? (1 = on, 0 = ei): ");
				if (sc.nextInt() == 0){System.out.println("Tee ne?"); jatkuu = false; break;}
				System.out.print("Hieno keli ulkona? (1 = on, 0 = ei): ");
				if (sc.nextInt() == 0){System.out.println("Mene ulkoilemaan? Esim. kavelylle tai uimaan"); jatkuu = false; break;}
				System.out.print("Koulussa ymmartamisvaikeuksia? (1 = on, 0 = ei): ");
				if (sc.nextInt() == 0){System.out.println("Opiskele kotona lisaa?"); jatkuu = false; break;}
				System.out.print("Onko tekmattomia hommia? (1 = on, 0 = ei): ");
				if (sc.nextInt() == 0){System.out.println("Tee ne?"); jatkuu = false; break;}
				jatkuu = false;
			}catch (Exception e){
				System.out.println("Jokin meni pieleen, yrita uudelleen!");
			}
		}
	}

}