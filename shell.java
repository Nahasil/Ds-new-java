public class p34 {

    /* Function to sort an array using Shell sort */
    void sort(int arr[]) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                // Add arr[i] to the elements that have been gap-sorted
                // Save arr[i] in temp and make a hole at position i
                int temp = arr[i];

                // Shift earlier gap-sorted elements up until the correct
                // location for arr[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

    // Utility function to print the array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {12, 34, 54, 2, 3};

        p33 shellSort = new p33();
        shellSort.sort(arr);

        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
