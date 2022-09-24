package pq;

public class PQMinHeap extends PriorityQueue{

    public PQMinHeap(int n, int[] d) {
        super(n, d);
    }

    @Override
    public void enqueue(int v) {
        pq[size++] = v;
        fixUp();
    }

    @Override
    public int dequeue() {
        swap(0, --size);
        fixDown();
        return pq[size];
    }

    private void fixUp() {
        int pos = size - 1;
        while (pos > 0) {
            int par = parent(pos);
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
            int swapPos = pos;
            if (rChild < size)
                swapPos = pq[rChild] < pq[lChild] ? rChild : lChild;
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
