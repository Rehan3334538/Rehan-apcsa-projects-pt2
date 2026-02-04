package sorting;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] testInput = randomArray(800);

        // Increase this once everything works
        TestSuite.run(testInput, 1);
        // TestSuite.run(testInput, 10000);
    }

    public static int[] randomArray(int length) {
        Random rand = new Random();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(800); 
        }

        return arr;
    }
}
