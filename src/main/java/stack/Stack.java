package stack;

import java.io.IOException;

public class Stack<T> {

    private T data[];
    private int capacity;
    private int size;
    private int peekItem = -1;

    public Stack(int initialSize) {
        this.capacity = initialSize;
        this.data = (T[]) new Object [initialSize];
    }

    public void push(T value){

        checkSpace();

        data[++peekItem] = value;
        size++;
    }

    public int size(){
        return size;
    }

    public T pop(){
        Object popItem = data[peekItem];
        data[peekItem--] = null;
        size--;

        return (T) popItem;
    }

    public T peek(){
        return data[peekItem];
    }

    public void checkSpace(){
        if (capacity - size < 1) {
            throw new IllegalArgumentException("No space left");
        }
    }

    public String toString(){
        String output = "";
        for (int i = size()-1; i >=0; i--){
            if (data[i] != null){
                output += " " + data[i];
            }
        }
        return output;
    }

    public int spaceLeft(){
        return capacity - size;
    }
}
