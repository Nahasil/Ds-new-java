import java.util.Scanner;

class Btree{
    private static final int T = 3; // Minimum degree (defines the range for number of keys)

    private class BTreeNode {
        int n = 0; // Number of keys
        int[] keys = new int[2 * T - 1];
        BTreeNode[] children = new BTreeNode[2 * T];
        boolean leaf = true;

        // Traverse the B-Tree
        public void traverse() {
            int i;
            for (i = 0; i < n; i++) {
                if (!leaf) {
                    children[i].traverse();
                }
                System.out.print(" " + keys[i]);
            }
            if (!leaf) {
                children[i].traverse();
            }
        }

        // Search for a key in the B-Tree
        public BTreeNode search(int key) {
            int i = 0;
            while (i < n && key > keys[i]) {
                i++;
            }
            if (i < n && keys[i] == key) {
                return this;
            }
            if (leaf) {
                return null;
            }
            return children[i].search(key);
        }
    }

    private BTreeNode root = new BTreeNode();

    public void traverse() {
        if (root != null) {
            root.traverse();
            System.out.println();
        }
    }

    public BTreeNode search(int key) {
        return root.search(key);
    }

    public void insert(int key) {
        BTreeNode r = root;
        if (r.n == 2 * T - 1) {
            BTreeNode s = new BTreeNode();
            root = s;
            s.leaf = false;
            s.children[0] = r;
            splitChild(s, 0);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void insertNonFull(BTreeNode x, int key) {
        int i = x.n - 1;
        if (x.leaf) {
            while (i >= 0 && key < x.keys[i]) {
                x.keys[i + 1] = x.keys[i];
                i--;
            }
            x.keys[i + 1] = key;
            x.n++;
        } else {
            while (i >= 0 && key < x.keys[i]) {
                i--;
            }
            i++;
            if (x.children[i].n == 2 * T - 1) {
                splitChild(x, i);
                if (key > x.keys[i]) {
                    i++;
                }
            }
            insertNonFull(x.children[i], key);
        }
    }

    private void splitChild(BTreeNode x, int i) {
        BTreeNode z = new BTreeNode();
        BTreeNode y = x.children[i];
        z.leaf = y.leaf;
        z.n = T - 1;

        for (int j = 0; j < T - 1; j++) {
            z.keys[j] = y.keys[j + T];
        }
        if (!y.leaf) {
            for (int j = 0; j < T; j++) {
                z.children[j] = y.children[j + T];
            }
        }
        y.n = T - 1;

        for (int j = x.n; j >= i + 1; j--) {
            x.children[j + 1] = x.children[j];
        }
        x.children[i + 1] = z;

        for (int j = x.n - 1; j >= i; j--) {
            x.keys[j + 1] = x.keys[j];
        }
        x.keys[i] = y.keys[T - 1];
        x.n++;
    }

    // Method to delete a key from the B-Tree
    public void delete(int key) {
        root = delete(root, key);
        if (root.n == 0 && !root.leaf) {
            root = root.children[0];
        }
    }

    private BTreeNode delete(BTreeNode node, int key) {
        int idx = findKey(node, key);

        if (idx < node.n && node.keys[idx] == key) {
            if (node.leaf) {
                return removeFromLeaf(node, idx);
            } else {
                return removeFromNonLeaf(node, idx);
            }
        } else {
            if (node.leaf) {
                return node;
            }
            boolean flag = (idx == node.n);
            if (node.children[idx].n < T) {
                fill(node, idx);
            }
            if (flag && idx > node.n) {
                return delete(node.children[idx - 1], key);
            } else {
                return delete(node.children[idx], key);
            }
        }
    }

    private int findKey(BTreeNode node, int key) {
        int idx = 0;
        while (idx < node.n && node.keys[idx] < key) {
            ++idx;
        }
        return idx;
    }

    private BTreeNode removeFromLeaf(BTreeNode node, int idx) {
        for (int i = idx + 1; i < node.n; i++) {
            node.keys[i - 1] = node.keys[i];
        }
        node.n--;
        return node;
    }

    private BTreeNode removeFromNonLeaf(BTreeNode node, int idx) {
        int k = node.keys[idx];

        if (node.children[idx].n >= T) {
            int pred = getPred(node, idx);
            node.keys[idx] = pred;
            delete(node.children[idx], pred);
        } else if (node.children[idx + 1].n >= T) {
            int succ = getSucc(node, idx);
            node.keys[idx] = succ;
            delete(node.children[idx + 1], succ);
        } else {
            merge(node, idx);
            delete(node.children[idx], k);
        }
        return node;
    }

    private void fill(BTreeNode node, int idx) {
        if (idx != 0 && node.children[idx - 1].n >= T) {
            borrowFromPrev(node, idx);
        } else if (idx != node.n && node.children[idx + 1].n >= T) {
            borrowFromNext(node, idx);
        } else {
            if (idx != node.n) {
                merge(node, idx);
            } else {
                merge(node, idx - 1);
            }
        }
    }

    private void borrowFromPrev(BTreeNode node, int idx) {
        BTreeNode child = node.children[idx];
        BTreeNode sibling = node.children[idx - 1];

        for (int i = child.n - 1; i >= 0; i--) {
            child.keys[i + 1] = child.keys[i];
        }
        if (!child.leaf) {
            for (int i = child.n; i >= 0; i--) {
                child.children[i + 1] = child.children[i];
            }
        }
        child.keys[0] = node.keys[idx - 1];

        if (!node.leaf) {
            child.children[0] = sibling.children[sibling.n];
        }
        node.keys[idx - 1] = sibling.keys[sibling.n - 1];
        child.n += 1;
        sibling.n -= 1;
    }

    private void borrowFromNext(BTreeNode node, int idx) {
        BTreeNode child = node.children[idx];
        BTreeNode sibling = node.children[idx + 1];

        child.keys[child.n] = node.keys[idx];

        if (!child.leaf) {
            child.children[child.n + 1] = sibling.children[0];
        }
        node.keys[idx] = sibling.keys[0];

        for (int i = 1; i < sibling.n; i++) {
            sibling.keys[i - 1] = sibling.keys[i];
        }
        if (!sibling.leaf) {
            for (int i = 1; i <= sibling.n; i++) {
                sibling.children[i - 1] = sibling.children[i];
            }
        }
        child.n += 1;
        sibling.n -= 1;
    }

    private void merge(BTreeNode node, int idx) {
        BTreeNode child = node.children[idx];
        BTreeNode sibling = node.children[idx + 1];

        child.keys[T - 1] = node.keys[idx];

        for (int i = 0; i < sibling.n; i++) {
            child.keys[i + T] = sibling.keys[i];
        }
        if (!child.leaf) {
            for (int i = 0; i <= sibling.n; i++) {
                child.children[i + T] = sibling.children[i];
            }
        }

        for (int i = idx + 1; i < node.n; i++) {
            node.keys[i - 1] = node.keys[i];
        }
        for (int i = idx + 2; i <= node.n; i++) {
            node.children[i - 1] = node.children[i];
        }
        child.n += sibling.n + 1;
        node.n--;
    }

    private int getPred(BTreeNode node, int idx) {
        BTreeNode cur = node.children[idx];
        while (!cur.leaf) {
            cur = cur.children[cur.n];
        }
        return cur.keys[cur.n - 1];
    }

    private int getSucc(BTreeNode node, int idx) {
        BTreeNode cur = node.children[idx + 1];
        while (!cur.leaf) {
            cur = cur.children[0];
        }
        return cur.keys[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Btree bTree = new Btree();

        while (true) {
            System.out.println("B-Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Traverse");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            System.out.print("Choose an operation: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();
                    bTree.insert(insertValue);
                    System.out.println("Inserted " + insertValue);
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    bTree.delete(deleteValue);
                    System.out.println("Deleted " + deleteValue);
                    break;

                case 3:
                    System.out.println("B-Tree Traversal:");
                    bTree.traverse();
                    break;

                case 4:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    BTreeNode result = bTree.search(searchValue);
                    if (result != null) {
                        System.out.println("Found " + searchValue);
                    } else {
                        System.out.println("Not Found " + searchValue);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

