package pq;

public class PQArray extends PriorityQueue {

    public PQArray (int n, int[] d) {
        super(n, d);
    }

    @Override
    public void enqueue(int v) {
        pq[size++] = v;
    }
    
    @Override
    public int dequeue() {
        int index = peek();
        int v = pq[index];
        size--;
        for (int i = index; i < size; i++) 
            pq[i] = pq[i+1];
        return v;
    }

    private int peek() {
        int smallestD = d[pq[0]];
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (smallestD > d[pq[i]]) {
                smallestD = d[pq[i]];
                index = i;
            }
        }
        return index;
    }
}