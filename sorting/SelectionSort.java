package sorting;

public class SelectionSort implements Sorter {

    int comparisons = 0;
    int swaps = 0;

    public void sort(int[] input) {

        comparisons = 0;
        swaps = 0;

        if (input == null || input.length <= 1) {
            return;
        }
        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;
            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < input.length; j++) {
                comparisons++; // comparing input[j] with input[minIndex]
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap if needed
            if (minIndex != i) {
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
                swaps++;
            }
        }
        printStats();
    }
    public void printStats() {
        System.out.println("Selection Sort Completed");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Total Operations: " + (comparisons + swaps));
    }
}
