package basics;

public class QueueImplementation<E> {
    private E[] arr;
    private int capacity;
    private int queueTail;

    QueueImplementation(int size) {
        arr = (E[]) new Object[size];
        capacity = size;
        queueTail = -1;
//        new LinkedList<>()
    }

    public void enqueue(E x) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }
        arr[++queueTail] = x;
    }

    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }
        E head = arr[0];
        for (int i = 0; i < capacity; i++) {
            arr[i] = arr[i+1];
        }
        capacity--;
        queueTail--;
        return head;
    }

    public boolean isEmpty() {
        return queueTail == -1;               // or return size() == 0;
    }

    public boolean isFull() {
        return queueTail == capacity - 1;     // or return size() == capacity;
    }

}
