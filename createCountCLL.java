import java.util.Scanner;
public class p23{
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
        }else{
            tail.next=newNode;
        }
        tail=newNode;
        tail.next=head;
    }
    void display(){
        int count=0;
        Node current=head;
        if(head==null){
            System.out.println("list is empty....");
            return;
        }else{
        System.out.println("Node of circular Linked list:");
        
        while(current.next!=head){
            System.out.print(current.data+" ");
            current=current.next;
            count++;
        }System.out.print(current.data);
        System.out.println();
        System.out.println("total no.of elements in L L:"+(count+1));
    }
  }
    public static void main(String args[]){
        p23 c=new p23();
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

    }
}
