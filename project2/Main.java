import java.util.Arrays;
import java.util.List;

import pq.*;

public class Main {
    public static void main(String[] args) {
        int V = 10000, E = 1000000;
        Graph g = new Graph(V);
        g.generateEdges(E);
        long startTime, endTime;

        // Adjacency matrix and array
        dijkstraAdjMatrix(0, g.adjM, V);
        startTime = System.nanoTime();
        dijkstraAdjMatrix(0, g.adjM, V);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        // Adjacency list and heap
        dijkstraAdjList(0, g.adjL, V);
        startTime = System.nanoTime();
        dijkstraAdjList(0, g.adjL, V);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    
    }

    public static void dijkstraAdjMatrix(int source, int[][] g, int V) {
        int[] d = new int[V];
        Arrays.fill(d, Integer.MAX_VALUE);
        int[] pi = new int[V];
        Arrays.fill(pi, -1);
        boolean[] S = new boolean[V];
        d[source] = 0;
        PQArray pq = new PQArray(V, d);
        for (int i = 0; i < V; i++) 
            pq.enqueue(i);
        while (!pq.isEmpty()) {
            int u = pq.dequeue();
            S[u] = true;
            for (int v = 0; v < V; v++) {
                if (!S[v] && g[u][v] != -1 && d[u] + g[u][v] < d[v]) {
                    d[v] = d[u] + g[u][v];
                    pi[v] = u;
                }
            }
        }
    }

    public static void dijkstraAdjList(int source, List<int[]>[] g, int V) {
        int[] d = new int[V];
        Arrays.fill(d, Integer.MAX_VALUE);
        int[] pi = new int[V];
        Arrays.fill(pi, -1);
        boolean[] S = new boolean[V];
        d[source] = 0;
        PQMinHeap pq = new PQMinHeap(V, d);
        for (int i = 0; i < V; i++) 
            pq.enqueue(i);
        while (!pq.isEmpty()) {
            int u = pq.dequeue();
            S[u] = true;
            for (int[] i : g[u]) {
                int v = i[0];
                int w = i[1];
                if (!S[v] && d[u] + w < d[v]) {
                    d[v] = d[u] + w;
                    pi[v] = u;
                    pq.updateHeap(v);
                }
            }
        }
    }
}
