import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add an edge to the graph
    void addEdge(int src, int dest) {
        adjacencyList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        adjacencyList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src);
    }

    // Breadth-First Search (BFS)
    void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        System.out.println("BFS starting from node " + start + ":");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjacencyList.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search (DFS) using recursion
    void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS starting from node " + start + ":");
        dfsRec(start, visited);
        System.out.println();
    }

    private void dfsRec(int node, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : adjacencyList.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsRec(neighbor, visited);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        // Example usage
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Edge");
            System.out.println("2. BFS");
            System.out.println("3. DFS");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter source node: ");
                    int src = scanner.nextInt();
                    System.out.print("Enter destination node: ");
                    int dest = scanner.nextInt();
                    graph.addEdge(src, dest);
                    break;
                case 2:
                    System.out.print("Enter starting node for BFS: ");
                    int bfsStart = scanner.nextInt();
                    graph.bfs(bfsStart);
                    break;
                case 3:
                    System.out.print("Enter starting node for DFS: ");
                    int dfsStart = scanner.nextInt();
                    graph.dfs(dfsStart);
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

