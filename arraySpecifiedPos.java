import java.util.Scanner;
 public class p1{
  public static void main(String args[]){
   int n,pos,x;
   Scanner s=new Scanner(System.in);
   int a[]=new int[5];
   System.out.println("Enter the no.of elements you want in Array");
   n=s.nextInt();
   System.out.println("Enter all the elements:");
   for(int i=0;i<n;i++){
   if(i>=5){
    System.out.println("Array overflow");
    }
    a[i]=s.nextInt();
    }
    
     System.out.println("Enter the position where you want to insert:");
      pos=s.nextInt();
      System.out.println("Enter the Element to Insert Array");
      x=s.nextInt();
      if(n>=5){
         System.out.println("Array overflow "+n);
         }else{
       for(int i=(n-1);i>=(pos-1);i--){
         a[i+1]=a[i];
         }
        a[pos-1]=x;
        n++;
        }
        System.out.println("After Inserting:");
          for(int i=0;i<n;i++){
           System.out.print(a[i]+" ");
           }
          //System.out.print(a[n]+"\n");
       
   }
  }
