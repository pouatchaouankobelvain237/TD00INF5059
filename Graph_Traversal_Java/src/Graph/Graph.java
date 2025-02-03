package Graph;
import java.util.*;

public class Graph {
private Map<Integer, List<Integer>> adjList;
    
    public Graph() {
        adjList = new HashMap<>();
    }
    
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    
    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            
            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
    
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }
    
    private void dfsHelper(int node, Set<Integer> visited) {
        if (visited.contains(node)) return;
        
        System.out.print(node + " ");
        visited.add(node);
        
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            dfsHelper(neighbor, visited);
        }
    }
    
    public boolean isConnected(int u, int v) {
        Set<Integer> visited = new HashSet<>();
        return dfsSearch(u, v, visited);
    }
    
    private boolean dfsSearch(int node, int target, Set<Integer> visited) {
        if (node == target) return true;
        if (visited.contains(node)) return false;
        
        visited.add(node);
        
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (dfsSearch(neighbor, target, visited)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
    	Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        
        System.out.println("BFS Traversal:");
        graph.bfs(1);
        
        System.out.println("\nDFS Traversal:");
        graph.dfs(1);
        
        System.out.println("\nIs 1 connected to 6? " + graph.isConnected(1, 6));
    }

}
