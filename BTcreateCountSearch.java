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

            if (current.left==null) {
                current.left=newNode;
                break;
            } else {
                queue.enqueue(current.left);
            }

            if (current.right==null) {
                current.right=newNode;
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

    public void inorderTraversal(Node node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public void preorderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void postorderTraversal(Node node) {
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}

public class p30 {
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
            System.out.println("3. Print In-Order Traversal");
            System.out.println("4. Print Pre-Order Traversal");
            System.out.println("5. Print Post-Order Traversal");
            System.out.println("6. Count Nodes");
            System.out.println("7. Exit");
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
                    System.out.println("In-Order Traversal:");
                    tree.inorderTraversal(tree.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Pre-Order Traversal:");
                    tree.preorderTraversal(tree.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Post-Order Traversal:");
                    tree.postorderTraversal(tree.root);
                    System.out.println();
                    break;
                case 6:
                    int nodeCount = tree.countNodes(tree.root);
                    System.out.println("Total number of nodes: " + nodeCount);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
