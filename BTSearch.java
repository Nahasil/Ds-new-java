import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class QueueNode {
    Node[] queue;
    int front, rear, size;

    public QueueNode(int capacity) {
        queue = new Node[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(Node node) {
        if (size == queue.length) {
            System.out.println("Queue is full");
            return;
        }
        queue[rear] = node;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public Node dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        Node node = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return node;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class BinaryTree {
    Node root;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        QueueNode queue = new QueueNode(10);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();

            if (current.left == null) {
                current.left = newNode;
                break;
            } else {
                queue.enqueue(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                break;
            } else {
                queue.enqueue(current.right);
            }
        }
    }

    public void printLevelOrder() {
        if (root == null) return;

        QueueNode queue = new QueueNode(10);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();
            System.out.print(current.data + " ");

            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        }
        System.out.println(); 
    }
    
    
        public boolean searchLevelOrder(int data) {
        if (root == null) return false;

        QueueNode queue = new QueueNode(10);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();
            if(current.data==data) return true;

            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        } 
        return false;
    }
 }

public class p31{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        int val, choice;
        boolean continueInput = true;

        while (continueInput) {
            System.out.println("Enter the number to insert into the tree:");
            val = sc.nextInt();
            tree.insert(val);

            System.out.println("Do you want to add more nodes? Press 1 for Yes, 0 for No:");
            int a = sc.nextInt();
            continueInput = a == 1;
        }
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Node");
            System.out.println("2. Print Level Order Traversal");
            System.out.println("3. Search Node in a tree");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number to insert into the tree:");
                    val = sc.nextInt();
                    tree.insert(val);
                    break;
                case 2:
                    System.out.println("Level Order Traversal:");
                    tree.printLevelOrder();
                    break;
                case 3:
                    System.out.println("Enter the value for search  from the tree:");
                     int a = sc.nextInt();
                     boolean found = tree.searchLevelOrder(a);
                     System.out.println("found:"+found);
                     if(found)
                         System.out.println("Element found in the tree.");
                     else 
                         System.out.println("Element not found in the tree."); 
                     break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
