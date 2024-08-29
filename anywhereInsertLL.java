import java.util.Scanner;
public class p21{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    Node head=null;
    Node tail=null;
    void insertAtPosition(int data,int position){
        Node newNode=new Node(data);
        if(position==1){
           newNode.next=head;
           head=newNode;
        }else{
            Node current=head;
            int currentPosition=1;
            while(current!=null&&currentPosition<position-1){
                current=current.next;
                currentPosition++;
            }
            if(current==null||position<=0){
                System.out.println("invalid position");
            }
            else{
                
                newNode.next=current.next;
                current.next=newNode;
            }

        }
    }

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
    
    void display(){
        Node current=head;
        if(head==null){
            System.out.println("list is empty....");
            return;
        }
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        p21 c=new p21();
        int a,b=1,val;
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
        
        while(b==1){
           System.out.println("Enter the data to add Linked list ");
           int data=s.nextInt();
           System.out.println("Enter the Position ");
           int position=s.nextInt();
           c.insertAtPosition(data,position);
           System.out.println("After the insertion of Linked list:");
           c.display();
           System.out.println("Do you want more to add LL press 1");
           b=s.nextInt();
        }
    }
}
