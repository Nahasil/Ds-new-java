import java.util.Scanner;
public class p13{
  public static void main(String arg[]){
    int i,n,search,arr[];
    Scanner in=new Scanner(System.in);
    do{
    System.out.println("Enter size of array less than or equal 10");
    n=in.nextInt();
    }while(n>10||n<0);
    arr=new int[10];
    System.out.println("Enter the elements");
    for(i=0;i<n;i++){
     arr[i]=in.nextInt();
     }
   System.out.println("Enter value to find ");
   search=in.nextInt();
   for(i=0;i<n;i++){
    if(arr[i]==search){
       System.out.println(search+"is present at location "+(i+1));
       break;
       }
     }
    if(i==n) System.out.println(search+"is not present ");
  }
}
