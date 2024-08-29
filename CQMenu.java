import java.util.Scanner;
class p9{
    static int size = 5;
    static int arr[] = new int[size];
    static int R=-1,F=0,te=0,i;
    static Scanner s = new Scanner(System.in);
    static void add() {
        if (te == size) {
            System.out.println("Queue is full");
        } else {
        
            System.out.println("Enter a number");
            int n = s.nextInt();
            
            R = (R + 1) % size;
            arr[R] = n;
            te++;
        }
    }
  
  public static void main(String arg[]){
         int ch;
    System.out.println("Enter the number of elements insert to an array");
      int num=s.nextInt();
      System.out.println("Enter the elements of queue");
      for( i=0;i<num;i++){
        arr[i]=s.nextInt();
        R++;te++;
        }
          
          
     for(;;){
       System.out.println("1.Add\n2.Delete\n3.Display\n4.Exit\n Enter your choice:");
       ch=s.nextInt();
         switch(ch){
           case 1:if(te==size){
                    System.out.println("queues is full");
                    }
                    else{
                      add();
                      }
                    break;
           case 2:if(te==0){
           		System.out.println("Queue is empty");
           		}
           	     else{
           	        System.out.println("Number Deleted="+arr[F]);
           	        arr[F]=-1;
           	        F=(F+1)%size;
           	        
           	        te=te-1;
           	        }
           	        break;
           	      
           case 3:if(te==0){
               		System.out.println("Queue is empty");
               		}
                    else{
                        System.out.println("Elements of Queue");
                         if(F<=R){
                        	for( i=F;i<=R;i++){
                        	 System.out.print(arr[i]+" ");
                          	}
                             System.out.println();
                            }
                          else{
                        	for( i=0;i<=R;i++){
                        	 System.out.print(arr[i]+" \n");
                          	}
                          	for( i=F;i<size;i++){
                        	 System.out.print(arr[i]+" \n");
                          	}
                             System.out.println();
                            }
                             
                         }
                         break;
           case 4:System.exit(0);
                  break;
           default:System.out.println("Wrong choice");
         }
        }
       }
      }      
