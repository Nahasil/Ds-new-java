import java.util.Scanner;

class p7 {
    static int[] arr = new int[10];
    static int r, f = 0;

    public static void Remove() {
        if (f > r-1) {
            System.out.println("queue is empty");
        } else {
            System.out.println("Number deleted=" + arr[f]);
            f++;
        }
    }

    public static void Print() {
        if (f > r) {
            System.out.println("queue is empty");
        } else {
            for (int i = f; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int choice = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("How many Elements you want to insert queue");
        int n = s.nextInt();
        while (n > 10 || n < 1) {
            System.out.println("Enter between 1 to 10");
            n = s.nextInt();
        }
        System.out.println("Enter the Element you want to insert queue");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            r++;
        }
        do {
            System.out.println("Do you want to Remove element from queue press 1");
            choice = s.nextInt();
            if (choice == 1) {
                Remove();
            }
        } while (f<r&&choice == 1);
        Print();
    }
}

