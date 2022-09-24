package pq;

public class PQMinHeap extends PriorityQueue{

    public PQMinHeap(int n, int[] d) {
        super(n, d);
    }

    public void enqueue(int v) {

    }

    public void dequeue() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int leftChild(int pos) {
        return 2*pos + 1;
    }

    private int rightChild(int pos) {
        return 2*pos + 2;
    }
}
