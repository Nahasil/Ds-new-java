import java.util.Scanner;

public class p16 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
       do{
          System.out.println("Enter size of array less than or equal 10");
           n=scanner.nextInt();
         }while(n>10||n<0);
        int[] arr = new int[10];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.print("Sorted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


