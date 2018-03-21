package queue;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomQueueTest {

    @Test
    public void enqueueWithTwoParameters() {

        CustomQueue<Integer> queue = new CustomQueue<>();

        queue.enqueue(3, 1);
        queue.enqueue(1, 0);
        queue.enqueue(2, 2);


        String expected = " 2 3 1";

        assertEquals(expected, queue.toString());

    }

    @Test
    public void dequeueTest() {

        CustomQueue<Integer> queue = new CustomQueue<>();

        queue.enqueue(1, 0);
        queue.enqueue(2, 2);
        queue.enqueue(3, 1);
        queue.dequeue();

        String expected = " 3 1";

        assertEquals(expected, queue.toString() );
    }

    @Test
    public void peekTest() {

        CustomQueue<Integer> queue = new CustomQueue<>();

        queue.enqueue(1, 0);
        queue.enqueue(2, 2);
        queue.enqueue(3, 1);

        assertEquals(Integer.valueOf(2), queue.peek().getValue());

    }

    @Test
    public void queueSizeTest() {

        CustomQueue<Integer> queue = new CustomQueue<>();

        queue.enqueue(1, 0);
        queue.enqueue(2, 2);
        queue.enqueue(3, 1);

        assertEquals(3, queue.queueSize());
    }

    @Test
    public void isEmpty() {

        CustomQueue<Integer> queue = new CustomQueue<>();

        assertTrue(queue.isEmpty());

    }
}