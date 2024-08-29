import java.util.*;
class p14{
  int binarySearch(int array[], int x, int low, int high) {
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (array[mid] == x)
        return mid;

      if (array[mid] < x)
        low = mid + 1;

      else
        high = mid - 1;
    }

    return -1; 
  }

  public static void main(String args[]) {
  int n;
  Scanner sc=new Scanner(System.in);
    p14 ob = new p14();
   
    int array[]=new int[5];
    System.out.println("enter elements ");
    for(int i=0;i<5;i++){
    array[i]=sc.nextInt();
    }
    Arrays.sort(array);
    System.out.println("sorted array");
    for(int i=0;i<5;i++){
    	System.out.println(array[i]);
    }
    System.out.println("enter the elemnt you want search ");
    int x = sc.nextInt();
    
    
    int result = ob.binarySearch(array, x, 0, 4);
    if (result == -1)
      System.out.println("Not found");
    else
      System.out.println("Element found at position " + (result+1));
  }
}
