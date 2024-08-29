import java.util.Scanner;
public class p25{
    class CNode{
        int data;
        CNode next;
        CNode(int data){
            this.data=data;
        }
    }
    CNode head=null;
    CNode tail=null;

     void insertAtPosition(int data,int position){
        CNode newNode=new CNode(data);
        if(position==1){
           newNode.next=head;
           head=newNode;
           tail.next=newNode;
        }else{
            CNode current=head;
            int currentPosition=1;
            while(current.next!=head&&currentPosition<position-1){

                current=current.next;
                currentPosition++;

            }
            if(position-1!=currentPosition){
                System.out.println("invalid position ");

            }else if(current==tail){
                tail.next=newNode;
                tail=newNode;
                newNode.next=head;
            }
                              
            else{
                
                newNode.next=current.next;
                current.next=newNode;
            }

        }
    }


     void addNode(int data){
        CNode newNode=new CNode(data);
        if(head==null) {
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            tail.next=newNode;
            tail=newNode;
        }
    }

      
    
    void display(){
        CNode current=head;
        if(head==null){
            System.out.println("list is empty....");
            return;
        }
        while(current.next!=head){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }
    public static void main(String args[]){
        p25 c=new p25();
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
       
        System.out.println("The Elements of  Linked list:");
        c.display();

        System.out.println("Enter the data to add Linked list ");
        int data=s.nextInt();

        System.out.println("Enter the Position ");
        int position=s.nextInt();
        c.insertAtPosition(data,position);

        System.out.println("After the insertion of Linked list:");
        c.display();
    }
}
