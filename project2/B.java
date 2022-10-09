public class B {
    // Suppose the input graph G = (V, E) is stored in an array of adjacency lists and we use a minimizing heap for the priority queue. 
    // Implement the Dijkstra’s algorithm using this setting and analyze its time complexity with respect to |V| and |E| both theoretically and empirically.
    public static void main(String[] args) {
        long startTime, endTime;
        int V = 1000;

        // vary |E|
        Graph g = new Graph(V);
        for (int E = 0; E <= 100000; E += 2000) {
            Dijkstra.adjList(0, g.adjL, V);
            startTime = System.nanoTime();
            Dijkstra.adjList(0, g.adjL, V);
            endTime = System.nanoTime();
            System.out.println((endTime - startTime)/1000);
            g.generateEdges(2000);
        }

        // vary |V|, |E| == 1000
        System.out.println();
        for (V = 32; V < 20000; V += 400) {
            g = new Graph(V);
            g.generateEdges(1000);
            startTime = System.nanoTime();
            Dijkstra.adjList(0, g.adjL, V);
            endTime = System.nanoTime();
            System.out.println((endTime - startTime)/1000);
        }

        // |V| == |E|
        System.out.println();
        for (V = 5; V < 20000; V += 400) {
            g = new Graph(V);
            g.generateEdges(V);
            startTime = System.nanoTime();
            Dijkstra.adjList(0, g.adjL, V);
            endTime = System.nanoTime();
            System.out.println((endTime - startTime)/1000);
        }
        
        // |V| == 0.5|E|
        System.out.println();
        for (V = 5; V < 20000; V += 400) {
            g = new Graph(V);
            g.generateEdges((int)(0.5*V));
            startTime = System.nanoTime();
            Dijkstra.adjList(0, g.adjL, V);
            endTime = System.nanoTime();
            System.out.println((endTime - startTime)/1000);
        }
    }
    
}
