package tdd;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class CircularListTest {
    private CircularQueue queue;

    @BeforeEach
    void beforeEach() {
        queue = new CircularQueueImpl(3);
    }

    @Test
    void testInitialStateIsEmpty() {
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(0, queue.size());
        assertEquals(3, queue.capacity());
    }

    @Test
    void testEnqueueAndPeek() {
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
        assertEquals(10, queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    void testFIFOOrder() {
        fillQueue(1, 2, 3);
        
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    void testOverwriteWhenFull() {
        fillQueue(1, 2, 3);
        queue.enqueue(4);
        
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
    }

    @Test
    void testDequeueReducesSize() {
        fillQueue(1, 2);
        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    void testPeekDoesNotChangeSize() {
        queue.enqueue(5);
        queue.peek();
        assertEquals(1, queue.size());
    }

    @Test
    void testDequeueThrowsExceptionWhenEmpty() {
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    void testPeekThrowsExceptionWhenEmpty() {
        assertThrows(IllegalStateException.class, () -> queue.peek());
    }

    @Test
    void testCircularBehaviorMultipleCycles() {
        fillQueue(1, 2, 3);
        queue.dequeue();
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(5);
        
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
    }

    @Test
    void testQueueWithCapacityOne() {
        CircularQueue smallQueue = new CircularQueueImpl(1);
        smallQueue.enqueue(1);
        assertTrue(smallQueue.isFull());
        smallQueue.enqueue(2);
        assertEquals(2, smallQueue.dequeue());
    }

    private void fillQueue(int... values) {
        for (int value : values) {
            queue.enqueue(value);
        }
    }
}
