import java.util.Scanner;
 public class p2{
  public static void main(String args[]){
   int n,pos,x,ch,size=5;
   Scanner s=new Scanner(System.in);
   System.out.println("Enter the no.of elements you want in Array");
   n=s.nextInt();
   
   int a[]=new int[size];
   System.out.println("Enter all the elements:");
   for(int i=0;i<n;i++){
   if(i>=size){
    System.out.println("Array overflow");
    return;
    }
    a[i]=s.nextInt();
    }
    
    
    
    do{
   System.out.println("Enter the position where you want to insert:");
   pos=s.nextInt();
   System.out.println("Enter the Element to Insert Array");
   x=s.nextInt();
   for(int i=(n-1);i>=(pos-1);i--){
    a[i+1]=a[i];
    }
    a[pos-1]=x;
    n++;
    if (pos>=size){ 
    size=pos;
    }
    
  
    
    System.out.println("After Inserting:");
    for(int i=0;i<n-1;i++){
     System.out.print(a[i]+",");
     }
     System.out.print(a[n-1]+"\n");
     
     //=============================================================\\
    
    
    System.out.println("Do you want to insert more Elements press 1");
    ch=s.nextInt();
    if(n>=size&&ch==1) System.out.println("Array is Overflow");
    }while(n<size&&ch==1);
    
   }
  }
