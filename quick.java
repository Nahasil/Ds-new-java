import java.util.Scanner;
public class p17 {

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); 

        for (int j = low; j < high ; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int n;
       do{
          System.out.println("Enter size of array less than or equal 10");
           n=s.nextInt();
         }while(n>10||n<0);
        int[] arr = new int[10];
        
        System.out.println("Enter the elements of Array:-");
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }

        System.out.println("Unsorted array");
        printArray(arr, n);

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array");
        printArray(arr, n);
    }
}
