public class A {
    // Suppose the input graph G = (V, E) is stored in an adjacency matrix and we use an array for the priority queue. 
    // Implement the Dijkstra’s algorithm using this setting and analyze its time complexity with respect to |V| and |E| both theoretically and empirically.
    public static void main(String[] args) {
        int V = 10000, E = 1000000;
        Graph g = new Graph(V);
        g.generateEdges(E);
        long startTime, endTime;
        
        Dijkstra.adjMatrix(0, g.adjM, V);
        startTime = System.nanoTime();
        Dijkstra.adjMatrix(0, g.adjM, V);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
