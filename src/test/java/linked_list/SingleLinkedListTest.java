package linked_list;

import linked_list.singleList.SingleLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleLinkedListTest {


    @Test
    public void insertTest() {

        SingleLinkedList linkedList = new SingleLinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        String expected = " 1 2 3";
        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void removeTest(){

        SingleLinkedList linkedList = new SingleLinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove(1);
        String expected = " 1 3";
        assertEquals(expected, linkedList.toString());

    }
}