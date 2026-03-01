package tdd;

public class CircularQueueImpl implements CircularQueue {
    private int[] queue;
    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public CircularQueueImpl(int capacity) {
        this.queue = new int[capacity];
    }

    @Override
    public void enqueue(int value) {
        queue[tail] = value;
        tail = nextIndex(tail);
        
        if (isFull()) {
            head = nextIndex(head);
        } else {
            count++;
        }
    }

    @Override
    public int dequeue() {
        ensureNotEmpty();
        int value = queue[head];
        head = nextIndex(head);
        count--;
        return value;
    }

    @Override
    public int peek() {
        ensureNotEmpty();
        return queue[head];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == queue.length;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public int capacity() {
        return queue.length;
    }

    private int nextIndex(int index) {
        return (index + 1) % queue.length;
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
    }

}
