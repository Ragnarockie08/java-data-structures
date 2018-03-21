package queue.normalQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    Queue<Integer> queue;

    @BeforeEach
    private void createQueue(){

        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
    }


    @Test
    void testEnqueue() {

        queue.enqueue(5);

        String expected = "1 2 3 4 5 ";
        assertEquals(expected, queue.toString());

    }

    @Test
    void dequeue() {

        queue.dequeue();

        String expected = "2 3 4 ";
        assertEquals(expected, queue.toString());
    }

    @Test
    void size() {

        assertEquals(4, queue.size());
    }

    @Test
    void isEmpty() {
        assertFalse(queue.isEmpty());
    }


}