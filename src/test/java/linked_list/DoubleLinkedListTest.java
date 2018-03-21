package linked_list;

import linked_list.doubleList.DoubleLinkedList;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DoubleLinkedListTest {

    @Test
    public void add() {

        DoubleLinkedList linkedList = new DoubleLinkedList();

        linkedList.add(1);
        linkedList.add(12321);

        String expected = " 1 12321";
        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void add1() {

        DoubleLinkedList linkedList = new DoubleLinkedList();

        linkedList.add(1);
        linkedList.add(12321);
        linkedList.add(1, 12);

        String expected = " 1 12 12321";

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void remove() {

        DoubleLinkedList linkedList = new DoubleLinkedList();

        linkedList.add(1);
        linkedList.add(12321);
        linkedList.add(1, 12);
        linkedList.remove(1);

        String expected = " 1 12321";

        assertEquals(expected, linkedList.toString());
    }

}