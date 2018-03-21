package stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void pushTest() {

        Stack stack = new Stack(2);

        stack.push(1);
        String expected = " 1";

        assertEquals(expected, stack.toString());
    }

    @Test
    public void sizeTest() {

        Stack stack = new Stack(2);

        assertEquals(2, stack.size());

    }

    @Test
    public void popTest() {

        Stack stack = new Stack(2);

        stack.push(1);
        stack.push(2);
        stack.pop();

        String expected = " 1";

        assertEquals(expected, stack.toString());

    }

    @Test
    public void peekTest() {

        Stack stack = new Stack(2);

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.peek());
    }

    @Test
    public void spaceLeftTest() {

        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);

        assertEquals(3, stack.spaceLeft());
    }
}