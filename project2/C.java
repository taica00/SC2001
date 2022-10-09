public class C {
    // Compare the two implementations in (a) and (b). 
    // Discuss which implementation is better and in what circumstances.
    public static void main(String[] args) {
        long startTime, endTime;
        int V = 1000;
        Graph g = new Graph(V);
        g.generateEdges(10000);
        Dijkstra.adjMatrix(0, g.adjM, V);
        Dijkstra.adjList(0, g.adjL, V);

        // |V| == 1000
        for (int E = 0; E <= 100000; E += 2000) {
            g = new Graph(V);
            g.generateEdges(E);
            startTime = System.nanoTime();
            Dijkstra.adjMatrix(0, g.adjM, V);
            endTime = System.nanoTime();
            System.out.print((endTime - startTime)/1000 + " ");
            startTime = System.nanoTime();
            Dijkstra.adjList(0, g.adjL, V);
            endTime = System.nanoTime();
            System.out.println((endTime - startTime)/1000);
        }

        // |E| == |V|
        System.out.println();
        for (V = 5; V < 20000; V += 400) {
            g = new Graph(V);
            g.generateEdges(V);
            startTime = System.nanoTime();
            Dijkstra.adjMatrix(0, g.adjM, V);
            endTime = System.nanoTime();
            System.out.print((endTime - startTime)/1000 + " ");

            startTime = System.nanoTime();
            Dijkstra.adjList(0, g.adjL, V);
            endTime = System.nanoTime();
            System.out.println((endTime - startTime)/1000);
        }

        // |E| == 0.5*|V|^2
        System.out.println();
        for (V = 5; V < 5000; V += 100) {
            g = new Graph(V);
            g.generateEdges((int)(0.5*V*V));
            startTime = System.currentTimeMillis();
            Dijkstra.adjMatrix(0, g.adjM, V);
            endTime = System.currentTimeMillis();
            System.out.print(endTime - startTime + " ");

            startTime = System.currentTimeMillis();
            Dijkstra.adjList(0, g.adjL, V);
            endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        }

    }
}
