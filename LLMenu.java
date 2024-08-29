import java.util.Scanner;
public class p22{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    Node tail=null;
   
    //===========ADD NODE END============\\
   
    void addNode(int data){
        Node newNode=new Node(data);
        if(head==null) {
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
    }
   
    //===========ADD NODE ANYWHERE============\\
     
     
    void insertAtPosition(int data, int position) {
    Node newNode = new Node(data);
    if (position <= 0) {
        System.out.println("Invalid position");
        return;
    }

    if (position == 1) {
        newNode.next = head;
        head = newNode;
        if (tail == null) {  
            tail = newNode;
        }
        return;
    }

    Node current = head;
    int currentPosition = 1;

    while (current != null && currentPosition < position - 1) {
        current = current.next;
        currentPosition++;
    }

    if (current == null) {
        System.out.println("Invalid position");
        return;
    }

    newNode.next = current.next;
    current.next = newNode;

    if (newNode.next == null) {
        tail = newNode;
    }
}

   
    //===========ADD NODE BEGINNING============\\
   
    void addNodeBeginning(int data){
       Node newNode=new Node(data);
       if(head==null){
           head=newNode;
       }else{
           Node temp=head;
           head=newNode;
            head.next=temp;
        }
   }
   
//==========DELETE NODE  AT FIRST========\\

void deleteAtFirst(){
    if(head==null){
        System.out.println("List is Empty");
        return;
    }
    System.out.println("Deleted from LL:-"+head.data);
    head=head.next;
}


//==========DELETE NODE  AT LAST========\\
void deleteAtLast(){
    if(head==null){
        System.out.println("List is Empty");
        return;
    }
    if(head.next==null){
        head=null;
        tail=null;
        return;
    }
    Node current=head;

    while(current.next.next!=null){
        current=current.next;
    }
    System.out.println("Deleted from LL:-"+tail.data);
    current.next=null;
    tail=current;
}


//===========DELETE NODE ANYWHERE==========\\

      void deleteAtPosition(int position) {
    if (position <= 0 || head == null) {
        System.out.println("Invalid position");
        return;
    }

    if (position == 1) {
        System.out.println("Deleted from LL: " + head.data);
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return;
    }

    Node current = head;
    int currentPosition = 1;

    while (current != null && current.next != null && currentPosition < position - 1) {
        current = current.next;
        currentPosition++;
    }

    if (current == null || current.next == null) {
        System.out.println("Invalid position");
        return;
    }

    System.out.println("Deleted from LL: " + current.next.data);
    current.next = current.next.next;

    if (current.next == null) {
        tail = current;
    }
}

  //=========== DISPLAY THE L.L============\\
 
    void display(){
        Node current=head;
        if(head==null){
            System.out.println("list is empty....");
            return;
        }
        System.out.println("Node of Singly Linked list:");
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        p22 c=new p22();
        int a,val,pos;
        Scanner s=new Scanner(System.in);
        a=1;
        while(a==1){
        System.out.println("Enter the number into the LL");
        val=s.nextInt();
        c.addNode(val);
        System.out.println("Do you want more to add LL press 1");
        a=s.nextInt();
        }
       
        System.out.println("The Elements of  Linked list:");
        c.display();

        while(true){
            System.out.println("select options:\n1.Add node at first\n2.Add node at last\n3.Add node anywhere\n4.Delete node at first\n5.Delete node at last\n6.Delete node anywhere\n7.traverse\n8.exit");
            int ch=s.nextInt();
            switch(ch){
                case 1:
                System.out.println("Enter the Values to add LL");
                val=s.nextInt();
                c.addNodeBeginning(val);
                c.display();
                break;
                case 2:
                System.out.println("Enter the Values to add LL");
                val=s.nextInt();
                c.addNode(val);
                c.display();
                break;
                case 3:
                System.out.println("Enter the Position to add LL");
                pos=s.nextInt();
                System.out.println("Enter the Values to add LL");
                val=s.nextInt();
                c.insertAtPosition(val,pos);
                c.display();
                break;
                case 4:
                c.deleteAtFirst();
                c.display();
                break;
                case 5:
                c.deleteAtLast();
                c.display();
                break;
                case 6:
                System.out.println("Enter the position to delete from list");
                val=s.nextInt();
                c.deleteAtPosition(val);
                c.display();
                break;
                case 7:
                c.display();
                break;
                case 8:System.exit(0);
                     break;
                default:System.out.println("Wrong choice");
            }
        }
    }
}
