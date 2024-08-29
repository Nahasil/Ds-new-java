import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    public DoublyLinkedList() {
        this.head = null;
        this.tail=null;
    }
//=========== Insert Node at first==========\\
   
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail=newNode;
            return;
        }
        newNode.prev=tail;
        tail.next=newNode;
        tail=newNode;
    }


//=========== Insert Node at Last==========\\
    
    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }
    
//=========== Insert Node at anyWhere==========\\
   
   void insertAtPosition(int pos,int data){
        Node newNode = new Node(data);
        if(pos==1){
            head.prev=newNode;
            newNode.next=head;
            head=newNode;
            return;
        }
        Node current=head;
        int currentPosition=1;
        while(current.next!=null&&currentPosition<pos-1){
            current=current.next;
            currentPosition++;
        }
        if(pos-1!=currentPosition){
                System.out.println("invalid position ");

            }else if(current==tail){
                tail.next=newNode;
                newNode.prev=tail;
                tail=newNode;
            }else{
              newNode.next=current.next;
              current.next.prev=newNode;
              current.next=newNode;
              newNode.prev=current;
            }
    
      
   }

//=========== Delete Node at first==========\\

void deleteFirst(){
    if(head==null){
        System.out.println("List is Empty...");
        return;
    }
    head=head.next;
    head.prev=null;
}

//=========== Delete Node at last==========\\

void deleteLast(){
    if(head==null){
        System.out.println("List is Empty...");
        return;
    }
    tail=tail.prev;
    tail.next=null;
}
//=========== Delete Node at anywhere==========\\
    
    public void deleteNode(int key) {
        Node current = head;
       int currentPosition=1;
        while (current != null) {
            if (currentPosition == key) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == head) {
                    head = current.next;
                    head.prev=null;
                }
                if(current==tail){
                    tail=tail.prev;
                    tail.next=null;
                }
                return;
            }
            current = current.next;
            currentPosition++;
        }
        System.out.println("Node with data " + key + " not found.");
    }


    public void traverseForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void traverseBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}

public class p27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        int a=1,val;
        while(a==1){
        System.out.println("Enter the number into the LL");
        val=scanner.nextInt();
        dll.append(val);
        System.out.println("Do you want more to add LL press 1");
        a=scanner.nextInt();
        }
        
                    dll.traverseForward();

        while (true) {
            System.out.println("\nDoubly Linked List Menu");
            System.out.println("1. Append");
            System.out.println("2. Prepend");
            System.out.println("3. Append node anywhere ");
            System.out.println("4. Delete node first");
            System.out.println("5. Delete node last");
            System.out.println("6. Delete node anywhere");
            System.out.println("7. Traverse Forward");
            System.out.println("8. Traverse Backward");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
             int data;
            switch (choice) {
                case 1:
                    System.out.print("Enter data to append: ");
                    data = scanner.nextInt();
                    dll.append(data);
                    dll.traverseForward();
                    break;
                case 2:
                    System.out.print("Enter data to prepend: ");
                    data = scanner.nextInt();
                    dll.prepend(data);
                    dll.traverseForward();
                    break;
                case 3:
                    System.out.print("Enter data to append node anywhere: ");
                    data = scanner.nextInt();
                    System.out.print("Enter position to append node anywhere: ");
                    int position = scanner.nextInt();
                    dll.insertAtPosition(position,data);
                    dll.traverseForward();
                    break;
                case 4:
                    dll.deleteFirst();
                    dll.traverseForward();
                    break;
                case 5:
                    dll.deleteLast();
                    dll.traverseForward();
                    break;
                case 6:
                    System.out.print("Enter position from delete List: ");
                    data = scanner.nextInt();
                    dll.deleteNode(data);
                    dll.traverseForward();
                    break;
                case 7:
                    System.out.println("Traversing forward:");
                    dll.traverseForward();
                    break;
                case 8:
                    System.out.println("Traversing backward:");
                    dll.traverseBackward();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
