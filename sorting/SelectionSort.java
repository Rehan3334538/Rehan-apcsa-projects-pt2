package sorting;

public class SelectionSort implements Sorter {

    @Override
    public void sort(int[] input) {
        if (input == null || input.length <= 1) {
            return;
        }

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < input.length - 1; i++) {
            
            // Find the minimum element in unsorted part
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of unsorted part
            if (minIndex != i) {
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
            }
        }
    }
}