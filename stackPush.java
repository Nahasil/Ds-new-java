import java.util.*;
class stack{
  static int max=10;
  int top;
  int a[]=new int[max];
  stack(){
   top=-1;
   }
   boolean push (int x){
    if(top >= max-1){
     System.out.println("Stack overflow");
     return false;
     }
     else{
     a[++top]=x;
     System.out.println(x+" pushed into Stack");
     return true;
     }
    }
  void print(){
   for(int i=top;i>-1;i--){
     System.out.println(" "+a[i]);
     }
    }
   }
   class p4{
     public static void main(String args[]){
      int x,ch=0,n;
       stack s=new stack();
       Scanner sc=new Scanner(System.in);
       System.out.println("How many Elements you want to insert Stack");
        n=sc.nextInt();
        while(n>s.max||n<1){
         System.out.println("Enter between 1 to 10");
         n=sc.nextInt();
         }
       System.out.println("Enter the Element you want to insert Stack");
       for(int i=0;i<n;i++){
        	x=sc.nextInt();
        	s.push(x);
          }
          	if(n<s.max){
                System.out.println("You want to insert more  elements into Stack press 1");
                ch=sc.nextInt();
                }
       		while(ch==1&&n<s.max){
       			System.out.println("Enter the Element you want to insert Stack");
        		x=sc.nextInt();
        		s.push(x);
        		n++;
        		ch=0;
       				if(n<s.max){
       					 System.out.println("You want to insert more  elements into Stack press 1");
        				 ch=sc.nextInt();
       					}
        	   }
       System.out.println("Elements in Stack:");
       s.print();
      }
     }
    
