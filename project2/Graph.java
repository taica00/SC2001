import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Graph {
    public int[][] adjM;
    public List<int[]>[] adjL; // array of linkedlists of int[]{v, w}
    public int edges;

    public Graph(int V) {
        adjM = new int[V][V];   
        adjL = new List[V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(adjM[i], -1); // -1 denotes that there is no connection between the two vertices
            adjL[i] = new LinkedList<>();
        }
        edges = 0;
    }

    public void generateEdges(int E) {
        Random rd = new Random();
        int v, u, w;
        for (int i = 0; i < E; i++) {
            do {
                v = rd.nextInt(adjM.length);
                u = rd.nextInt(adjM.length);
            } while (adjM[v][u] != -1); // ensure that edge does not already exist
            w = rd.nextInt(Integer.MAX_VALUE-2) + 1;
            adjM[v][u] = w;
            adjL[v].add(new int[]{u, w});
            edges++;
        }
    }
}
