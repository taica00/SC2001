public class C {
    // Compare the two implementations in (a) and (b). 
    // Discuss which implementation is better and in what circumstances.
    public static void main(String[] args) {
        int V = 10000, E = 1000000;
        Graph g = new Graph(V);
        g.generateEdges(E);
        long startTime, endTime;

        // Adjacency matrix and array
        Dijkstra.adjMatrix(0, g.adjM, V);
        startTime = System.nanoTime();
        Dijkstra.adjMatrix(0, g.adjM, V);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        // Adjacency list and heap
        Dijkstra.adjList(0, g.adjL, V);
        startTime = System.nanoTime();
        Dijkstra.adjList(0, g.adjL, V);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
