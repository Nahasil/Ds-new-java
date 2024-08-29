import java.util.Scanner;
class stack{
  int arr[],top;
   stack(int size){
     arr=new int[size];
     top=-1;
     }
     
     public void push(Scanner s){
       if(top==arr.length-1){
         System.out.println("the stack is full");
         }
         else{
           System.out.println("Enter the value");
           int value=s.nextInt();
           arr[++top]=value;
           System.out.println("value is push into stack ");
           }
          }
         
       public void pop(){
        if(top==-1){
          System.out.println("stack is empty");
          }
          else{
           System.out.println(arr[top]+" is popped from stack");
           top--;
           }
         }
         
         public void peek(){
          if (top==-1){
            System.out.println("stack is empty");
            }else{
              System.out.println("the top element in stack is:"+arr[top]);
              }
            }
            
            public void print(){
              System.out.println("The element of stack is :-");
              for(int i=top;i>-1;i--){
                System.out.println(arr[i]);
                }
              }
           }
          class p6{
             public static void main (String args[]){
               
               int choice,n;
               Scanner s=new Scanner(System.in);
               System.out.println("enter the size of Stack");
               n=s.nextInt();
               stack obj=new stack(n);
               System.out.println("How many Elements you want to insert Stack");
               n=s.nextInt();
               while(n>10||n<1){
                    System.out.println("Enter between 1 to 10");
                    n=s.nextInt();
                  }
               for(int i=0;i<n;i++){
        	obj.push(s);
                }
               
               for(;;){
               System.out.println("Choose the one operation from the option given below:\n1.push\n2.pop\n3.peek\n4.Display\n5.Exit");
               choice=s.nextInt();
               switch(choice){
                   case 1:{
                          obj.push(s);
                          obj.print();
                          break;
                          }
                   case 2:{
                          obj.pop();
                          obj.print();
                          break;
                          }
                   case 3:{
                          obj.peek();
                          break;
                          }
                   case 4:{
                          obj.print();
                          break;
                          }
                   case 5:{
			  System.exit(0);
                          break;
                          }
                   default:{
                            System.out.println("You choose wrong Option");
                           }
                       }
                     }
                }
            }  
