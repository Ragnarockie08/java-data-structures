package heap;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinHeapTest {


    @Test
    public void build() {

        MinHeap heap = new MinHeap();

        int[] array = new int[] {17, 25, 10, 5, 1, 34};
        heap.build(array);

        String expected = "[1, 5, 17, 25, 10, 34]";

        assertEquals(expected, heap.toString());

    }

    @Test
    public void add() {

        MinHeap heap = new MinHeap();

        int[] array = new int[] {16, 5, 4, 2, 6};
        heap.build(array);
        heap.add(7);

        String expected = "[2, 4, 5, 16, 6, 7]";

        assertEquals(expected, heap.toString());
    }

    @Test
    public void remove() {

        MinHeap heap = new MinHeap();

        int[] array = new int[] {2, 4, 5, 16, 6, 7};
        heap.build(array);
        heap.remove();

        String expected = "[4, 6, 5, 16, 7]";

        assertEquals(expected, heap.toString());
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void peek() {
        MinHeap heap = new MinHeap();

        int[] array = new int[] {17, 25, 10, 5, 1, 34};
        heap.build(array);

        assertEquals(1, heap.peek());

    }
}
