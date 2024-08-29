import java.util.*;

public class p15 {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         int n;
    do{
    System.out.println("Enter size of array less than or equal 10");
    n=sc.nextInt();
    }while(n>10||n<0);
    int arr[]=new int[10];
    System.out.println("enter elements ");
    for(int i=0;i<n;i++){
    arr[i]=sc.nextInt();
    }

        for (int i = 0; i < n-1; i++) {
        int min=i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) {
                   min=j;
                }
            } 
              int temp = arr[min];
                     arr[min] = arr[i];
                     arr[i] = temp;
            
        }

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

