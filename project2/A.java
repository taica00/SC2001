public class A {
    // Suppose the input graph G = (V, E) is stored in an adjacency matrix and we use an array for the priority queue. 
    // Implement the Dijkstra’s algorithm using this setting and analyze its time complexity with respect to |V| and |E| both theoretically and empirically.
    public static void main(String[] args) {
        long startTime, endTime;
        int V = 1000;
        // Dummy runs
        for (int E = 0; E <= 1000; E += 100) {
            Graph g = new Graph(V);
            g.generateEdges(E);
            Dijkstra.adjMatrix(0, g.adjM, V);   
        }

        // vary |E|
        for (int E = 0; E <= 100000; E += 2000) {
            Graph g = new Graph(V);
            g.generateEdges(E);
            startTime = System.nanoTime();
            Dijkstra.adjMatrix(0, g.adjM, V);
            endTime = System.nanoTime();
            System.out.println((endTime - startTime)/1000);
        }

        // vary |V|, |E| == |V|
        System.out.println();
        for (V = 5; V < 20000; V += 400) {
            Graph g = new Graph(V);
            g.generateEdges(V);
            startTime = System.currentTimeMillis();
            Dijkstra.adjMatrix(0, g.adjM, V);
            endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        }

        // vary |V|, |E| == 0
        System.out.println();
        for (V = 5; V < 20000; V += 400) {
            Graph g = new Graph(V);
            startTime = System.currentTimeMillis();
            Dijkstra.adjMatrix(0, g.adjM, V);
            endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        }
    }
}
