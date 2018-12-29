import java.util.concurrent.*;
import java.util.*;

public class ForkJoinPoolDemo {
    public static void main(String[] args) {

        //SINGLE THREAD

        long startTimeS = System.nanoTime();
        for(int i = 0; i < Test.Load; i++){
            System.out.print("");
        }
        long endTimeS = System.nanoTime();
        
        //MULTITHREAD w/ ForkJoinPool

        long startTimeF = System.nanoTime();
        ForkJoinPool pool = new ForkJoinPool(4, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
        pool.invoke(new CustomAction(0, Test.Load));

        System.out.println("ForkJoinPool - Aikaa kului: " + (System.nanoTime() - startTimeF)/1000000 + " ms");
        System.out.println("SingleThread - Aikaa kului: " + (endTimeS - startTimeS)/1000000 + " ms");
    }
}

interface Test{
    public final static int Load = 30000000;
}

class CustomAction extends RecursiveAction {

    private static final long serialVersionUID = 1L;
    private int start;
    private int end;
    private int vali;

    CustomAction(int start, int end) { 
        this.start = start;
        this.end = end;
        this.vali = end-start;
    }

    @Override
    protected void compute() {      
        if (vali > Test.Load/10) {
            System.out.println("Splitting: " + start + "-" + end + " = " + vali);
            split();
        } 
        else {
            System.out.println("Toimii: " + start + "-" + end + " = " + vali);
            for(int i = start; i < end; i++){
                System.out.print("");
            }
        }
    }

    private void split(){
        CustomAction low = new CustomAction(start, (start+end)/2);
        CustomAction high = new CustomAction((start+end)/2, end);
        low.fork();
        high.fork();
        low.join();
        high.join();
    }
}