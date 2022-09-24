import pq.*;

public class Main {
    public static void main(String[] args) {
        int[] d = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        PQMinHeap pq = new PQMinHeap(8, d);
        pq.enqueue(7);
        pq.enqueue(3);
        pq.enqueue(5);
        pq.enqueue(2);
        pq.enqueue(4);
        pq.enqueue(0);
        pq.enqueue(1);
        pq.enqueue(6);
        while (!pq.isEmpty())
            System.out.println(pq.dequeue());
    }
}
