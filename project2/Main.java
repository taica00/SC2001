import java.util.Arrays;
import java.util.List;

import pq.*;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.generateEdges(10);
        
    }

    public static void dijkstraAdjMatrix(int source, int[][] g, int V) {
        int[] d = new int[V];
        Arrays.fill(d, Integer.MAX_VALUE);
        int[] pi = new int[V];
        Arrays.fill(pi, -1);
        boolean[] S = new boolean[V];
        d[source] = 0;
        PriorityQueue pq = new PQArray(V, d);
        for (int i = 0; i < V; i++) 
            pq.enqueue(i);
        while (!pq.isEmpty()) {
            int u = pq.dequeue();
            S[u] = true;
            for (int v = 0; v < V; i++) {
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
        PriorityQueue pq = new PQMinHeap(V, d);
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
                }
            }
        }
    }
}
