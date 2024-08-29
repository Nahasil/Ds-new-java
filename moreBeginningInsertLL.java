import java.util.Scanner;
public class p20{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    Node head=null;
    Node tail=null;
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
        p20 c=new p20();
        int a,val;
        Scanner s=new Scanner(System.in);
        a=1;
        while(a==1){
        System.out.println("Enter the number into the LL");
        val=s.nextInt();
        c.addNode(val);
        System.out.println("Do you want more to add LL press 1");
        a=s.nextInt();
        }

        c.display();

        
        while(true){
            System.out.println("select options:\n1.addFirst\n2.exit");
            int ch=s.nextInt();
            switch(ch){
                case 1:
                System.out.println("Enter the Values to add LL");
                val=s.nextInt();
                c.addNodeBeginning(val);
                c.display();
                break;
                case 2:System.exit(0);
                break;
                default:System.out.println("Wrong choice");
            }
        }
    }
}
