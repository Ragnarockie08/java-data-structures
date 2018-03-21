package dynamic_array;

import java.util.Arrays;

public class DynamicIntArray<E> {

    private  Object[] data;
    private int size;

    public DynamicIntArray(){

        data = new Object [10];
        size = 0;
    }

    public Object[] getData() {
        return data;
    }

    public DynamicIntArray(int initialSize){
        data = new Object [initialSize];
        size = 0;
    }

    private void increaseDataSize(){

        if (data.length - size < 1){
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    public E get(int index){

        checkIndex(index);
        return (E) data[index];
    }

    public boolean add(E element){

        increaseDataSize();
        data[size++] = element;
        return true;
    }

    public boolean remove(int index){

        checkIndex(index);

        for (int i = index; i < size(); i++) {
            data[i] = data[i + 1];
        }
        size--;

        return true;

    }

    public void insert(int index, E element){

        if (index >= size){
            add(element);
        } else if (index >= 0) {
            increaseDataSize();
            for (int i = size(); i > index; i--) {
                data[i] = data[i-1];
            }
            data[index] = element;
        } else {
            throw new IllegalArgumentException();
        }
        size++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public String toString(){
        String output = "";
        for (Object element: data){
            if (element == null){
                continue;
            }
            output += " " + element;
        }
        return output;
    }

}
