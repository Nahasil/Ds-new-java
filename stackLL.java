import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        System.out.println("top:-"+top);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed " + data + " to the stack.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to pop.");
            return;
        }
        System.out.println("Popped " + top.data + " from the stack.");
        top = top.next;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top element is " + top.data);
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        Node current = top;
        System.out.print("Stack elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class p28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        
       /* a=1;
        while(a==1){
        System.out.println("Enter the number into the LL");
        val=s.nextInt();
        stack.addNode(val);
        System.out.println("Do you want more to add LL press 1");
        a=scanner.nextInt();
        }
        
        System.out.println("The Elements of  Linked list:");
        stack.display();*/
        

        while (true) {
            System.out.println("Stack Menu");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to push: ");
                    int data = scanner.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
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
