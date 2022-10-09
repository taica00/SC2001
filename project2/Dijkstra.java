import java.util.Arrays;
import java.util.List;

import pq.*;

public class Dijkstra {

    private Dijkstra() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void adjMatrix(int source, int[][] g, int V) {
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

    public static void adjList(int source, List<int[]>[] g, int V) {
        int[] d = new int[V];
        Arrays.fill(d, Integer.MAX_VALUE);
        int[] pi = new int[V];
        Arrays.fill(pi, -1);
        boolean[] S = new boolean[V];
        d[source] = 0;  
        PQMinHeap pq = new PQMinHeap(V, d);
        pq.enqueue(source);  // ensure source is at the root of the heap
        for (int i = 0; i < V; i++) {
            if (i != source) 
                pq.enqueue(i);
        }
        while (!pq.isEmpty()) {
            int u = pq.dequeue();
            S[u] = true;
            for (int[] edge : g[u]) {
                int v = edge[0];   // vertex v adjacent to vertex u
                int w = edge[1];   // path cost between vertex v and u
                if (!S[v] && d[u] + w < d[v]) {
                    d[v] = d[u] + w;
                    pi[v] = u;
                    pq.updateHeap(v);   // priority of vertex v has changed, hence the heap must be updated
                }
            }
        }
    }
}
