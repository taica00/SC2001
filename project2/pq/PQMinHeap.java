package pq;

public class PQMinHeap extends PriorityQueue {

    public PQMinHeap(int n, int[] d) {
        super(n, d);
    }

    @Override
    public void enqueue(int v) {
        pq[size++] = v;
        fixUp(size-1);
    }

    @Override
    public int dequeue() {
        swap(0, --size);
        fixDown();
        return pq[size];
    }

    public void updateHeap(int v) {
        for (int i = 0; i < size; i++) {
            if (pq[i] == v) {
                fixUp(i);
                break;
            }
        }
    }

    private void fixUp(int pos) {
        int par = 0;
        while (pos > 0) {
            par = parent(pos);
            if (d[pq[pos]] < d[pq[par]]) 
                swap(pos, par);
            else
                break;
            pos = par;
        }
    }

    private void fixDown() {
        int pos = 0;
        while (leftChild(pos) < size) {
            int lChild = leftChild(pos);
            int rChild = rightChild(pos);
            int swapPos;
            if (rChild < size)
                swapPos = d[pq[rChild]] < d[pq[lChild]] ? rChild : lChild;
            else
                swapPos = lChild;
            if (d[pq[swapPos]] < d[pq[pos]])
                swap(swapPos, pos);
            pos = swapPos;
        }
    }

    private void swap(int x, int y) {
        int temp = pq[x];
        pq[x] = pq[y];
        pq[y] = temp;
    }

    private int parent(int pos) {
        return (pos-1)/2;
    }

    private int leftChild(int pos) {
        return 2*pos + 1;
    }

    private int rightChild(int pos) {
        return 2*pos + 2;
    }
}
