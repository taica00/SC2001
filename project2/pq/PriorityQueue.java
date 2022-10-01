package pq;

public abstract class PriorityQueue {
    protected int[] pq;
    protected int[] d;
    protected int size;

    protected PriorityQueue(int n, int[] d) {
        pq = new int[n];
        this.d = d;
        size = 0;
    }

    public abstract void enqueue(int v);
    public abstract int dequeue();

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for (int i : pq)
            System.out.print(i + " ");
        System.out.println();
    }
}
