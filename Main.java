
public class Main{

    public static long onethread()
    {
        long  sum =0;

        for (long i = 0; i < 1_000_000_000L; i++) {
            sum++;}

        return sum;
    }

    public static void main(String[]args) {
        long start = System.nanoTime();
        long total = onethread();
        long end = System.nanoTime();

        	System.out.println("single threaded sum: " + total);
        	System.out.println("time: " + (end-start)/ 1_000_000_000.0 + " seconds");
    }
}
