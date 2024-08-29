import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int item) {
        value = item;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a new node
    void insert(int key) {
        root = insertRec(root, key);
    }

    TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.value) {
            root.left = insertRec(root.left, key);
        } else if (key > root.value) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Delete a node
    void delete(int key) {
        root = deleteRec(root, key);
    }

    TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.value) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    int minValue(TreeNode root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    // Inorder traversal
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal
    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Search for a value
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.value) {
            return true;
        }

        if (key < root.value) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }
}

public class BST{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Postorder Traversal");
            System.out.println("6. Search");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();
                    bst.insert(insertValue);
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    bst.delete(deleteValue);
                    break;
                case 3:
                    System.out.print("Inorder Traversal: ");
                    bst.inorder();
                    break;
                case 4:
                    System.out.print("Preorder Traversal: ");
                    bst.preorder();
                    break;
                case 5:
                    System.out.print("Postorder Traversal: ");
                    bst.postorder();
                    break;
                case 6:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    boolean found = bst.search(searchValue);
                    if (found) {
                        System.out.println(searchValue + " is present in the tree.");
                    } else {
                        System.out.println(searchValue + " is not present in the tree.");
                    }
                    break;
                case 7:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

