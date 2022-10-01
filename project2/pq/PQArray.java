package pq;

public class PQArray extends PriorityQueue {

    public PQArray (int V, int[] d) {
        super(V, d);
    }

    @Override
    public void enqueue(int v) {
        pq[size++] = v;
    }
    
    @Override
    public int dequeue() {
        int index = findMin();
        int v = pq[index];
        size--;
        for (int i = index; i < size; i++) 
            pq[i] = pq[i+1];
        return v;
    }

    private int findMin() {
        int minD = d[pq[0]];
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (minD > d[pq[i]]) {
                minD = d[pq[i]];
                index = i;
            }
        }
        return index;
    }
}