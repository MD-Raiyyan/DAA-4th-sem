import java.util.*;

class TopologicalSort {

    static void dfs(int v, boolean visited[],
                    Stack<Integer> stack,
                    ArrayList<ArrayList<Integer>> graph) {

        visited[v] = true;

        for (int u : graph.get(v)) {
            if (!visited[u]) {
                dfs(u, visited, stack, graph);
            }
        }

        stack.push(v);
    }

    static void topologicalSort(int V,
                                ArrayList<ArrayList<Integer>> graph) {

        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, graph);
            }
        }

        System.out.println("\nTopological Order:");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter edges (source destination):");

        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph.get(src).add(dest);
        }

        topologicalSort(V, graph);

        sc.close();
    }
}
