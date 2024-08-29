import java.util.Scanner;
class p8{
     public static void main(String args[]){
          int size=10;
          int[] arr=new int[size];
          int r=-1,f=0,choice,n;
          Scanner s=new Scanner(System.in);
          System.out.println("How many Elements you want to insert queue");
          n=s.nextInt();
        while(n>size||n<1){
         System.out.println("Enter between 1 to 10");
         n=s.nextInt();
         }
         System.out.println("Enter the Element you want to insert queue");
         for (int i=0;i<n;i++){
        	arr[i]=s.nextInt();
        	r++;
          }
             for(;;){
                System.out.println("Choose the one operation from the option given below:\n1.add\n2.delete\n3.Display\n4.Exit");
                choice=s.nextInt();
                switch(choice){
                  case 1:{
                         if(r==size-1){
                           System.out.println("queue is full");
                           }
                           else{
                             System.out.println("Enter a number");
                             n=s.nextInt();
                             r++;
                             arr[r]=n;
                             }
                           break;
                          }
                    case 2:{
                           if(f>r){
                  	      System.out.println("queue is empty");
              	            }
           	           else{
              		      System.out.println("Number deleted="+arr[f]);
              		      f++;
              		    }
              		   }
              		    break;
                    case 3:{
                            if(f>r){
                		System.out.println("queue is empty");
               		     }
             		    else{
               		      for(int i=f;i<=r;i++){
                 	      System.out.print(arr[i]+" ");
                	      }
                	       System.out.println();
                	    }
                	   }
                	    break;
                    case 4:{
                            System.exit(0);
                            break;
                            }
                    default:System.out.println("You choose wrong Option");
                   }
                 }
               }
             }
