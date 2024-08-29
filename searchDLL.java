import java.util.Scanner;
class p26{
   class DNode{
       int data;
       DNode prev=null;
       DNode next=null;
       DNode(int data){
           this.data=data;
           }
        }
    DNode head;
    DNode tail;
    
      void addNode(int data){
        DNode newNode=new DNode(data);
        if(head==null) {
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
    }
      
    
    public void traverseForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
   
    public boolean searchForward(int key){
          DNode current=head;
          while(current!=null){
            if(current.data==key){
               return true;
               }
            current=current.next;
            }
          return false;
       }
      
      
      public boolean searchBackward(int key){
          DNode current=head;
          if(current==null){
           return false;
           }
          while(current.next!=null){
           current=current.next;
          }
          while(current!=null){
            if(current.data==key){
               return true;
               }
            current=current.prev;
            }
          return false;
       }
       
       public static void main(String args[]){
            p26 dl=new p26();
            Scanner sc=new Scanner(System.in);
            int choice,a,data,key;
            
            
            do{
               System.out.println("select your option from given Menu:");
               System.out.println("1. Insert");
               System.out.println("2. Search Forward");
               System.out.println("3. Search Backward");
               System.out.println("4. Exit");
               System.out.print("Enter your choice: ");
               choice = sc.nextInt();
               
               
               switch (choice) {
                case 1:
                       System.out.print("Enter data to append: ");
                       data = sc.nextInt();
                       dl.addNode(data);
                       dl.traverseForward();
                       break;
                case 2:
                    System.out.print("Enter element to search Forward: ");
                      key = sc.nextInt();
                    if (dl.searchForward(key)) {
                        System.out.println("Element found");
                    } else {
                        System.out.println("Element not found");
                    }
                    break;
                case 3:
                      System.out.print("Enter element to search Forward: ");
                      key = sc.nextInt();
                    if (dl.searchBackward(key)) {
                        System.out.println("Element found");
                    } else {
                        System.out.println("Element not found");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
           }while(choice!=4);
            
          
        }
               
     }        
            
  
