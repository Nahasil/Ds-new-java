import java.util.Scanner;
class p3{
  public static void main(String args[]){
   int n,x,flag=1,loc=0;
   Scanner s=new Scanner(System.in);
   System.out.println("Enter the no.of Elements you want?");
   n=s.nextInt();
   int a[] = new int[n];
   System.out.println("Enter all the elements");
   for(int i=0;i<n;i++){
   a[i]=s.nextInt();
   }
   System.out.println("enter the element you want to delete");
   x=s.nextInt();
   for(int i=0;i<n;i++){
    if(a[i]==x){
      for(int j=i+1;j<n;j++){
       a[j-1]=a[j];
      }
       n--;
     }
   }
  System.out.println("After deleting:");
     for(int i=0;i<n;i++){
       System.out.println(a[i]+" ");
       }
     }
   }
       
