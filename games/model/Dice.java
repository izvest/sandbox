import java.util.Random;

public class Dice{

    private int sides;

    public Dice(int sides){
        this.sides = sides;
    }

    public int roll(){
        Random r = new Random();
        return r.nextInt(sides+1);
    }
}