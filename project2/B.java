public class B {
    // Suppose the input graph G = (V, E) is stored in an array of adjacency lists and we use a minimizing heap for the priority queue. 
    // Implement the Dijkstra’s algorithm using this setting and analyze its time complexity with respect to |V| and |E| both theoretically and empirically.
    public static void main(String[] args) {
        int V = 10000, E = 1000000;
        Graph g = new Graph(V);
        g.generateEdges(E);
        long startTime, endTime;

        Dijkstra.adjList(0, g.adjL, V);
        startTime = System.nanoTime();
        Dijkstra.adjList(0, g.adjL, V);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
    
}
