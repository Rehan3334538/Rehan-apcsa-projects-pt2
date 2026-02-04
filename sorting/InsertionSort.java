package sorting;

public class InsertionSort implements Sorter {

    int comparisons = 0;
    int shifts = 0;
    public void sort(int[] input) {
        comparisons = 0;
        shifts = 0;
        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++; // count comparison
                if (input[j] > key) {
                    input[j + 1] = input[j]; // shift
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }
            input[j + 1] = key;
            shifts++; // placing the key
        }
        printStats();
    }
    public void printStats() {
        System.out.println("Insertion Sort Completed");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Shifts: " + shifts);
        System.out.println("Total Operations: " + (comparisons + shifts));
    }
}
