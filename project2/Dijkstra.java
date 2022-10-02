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
        for (int i = 0; i < V; i++) 
            pq.enqueue(i);  
        while (!pq.isEmpty()) {
            int u = pq.dequeue();
            S[u] = true;
            for (int[] i : g[u]) {
                int v = i[0];   // vertex v adjacent to vertex u
                int w = i[1];   // path cost between vertex v and u
                if (!S[v] && d[u] + w < d[v]) {
                    d[v] = d[u] + w;
                    pi[v] = u;
                    pq.updateHeap(v);   // priority of vertex v has changed, hence the heap must be updated
                }
            }
        }
    }
}
