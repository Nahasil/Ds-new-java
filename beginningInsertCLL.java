import java.util.Scanner;
public class p24{
    class CNode{
        int data;
        CNode next;
        CNode(int data){
            this.data=data;
        }
    }
    CNode head=null;
    CNode tail=null;
    
    
    void addNode(int data){
        CNode newNode=new CNode(data);
        if(head==null) {
            head=newNode;
        }else{
            tail.next=newNode;
        }
        tail=newNode;
        tail.next=head;
    }
    
     void addFirst(int data){
        CNode newNode=new CNode(data);
        if(head==null) {
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
            tail.next=newNode;
        }
    }
    
    void display(){
        CNode current=head;
        if(head==null){
            System.out.println("list is empty....");
            return;
        }
        System.out.println("Node of circular Linked list:");
        while(current.next!=head){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.print(current.data+" ");
        System.out.println();
    }
    public static void main(String args[]){
        p24 c=new p24();
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
        

        System.out.println("Enter the data to add Linked list ");
        int data=s.nextInt();
        c.addFirst(data);
        System.out.println("After the insertion of Linked list:");
        c.display();
    }
}
