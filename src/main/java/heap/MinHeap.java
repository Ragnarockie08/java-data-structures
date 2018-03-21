package heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {

    private static final int INITIAL_SIZE = 10;
    private int[] data;
    private int size;

    MinHeap() {
        this.data = new int[INITIAL_SIZE];
        size = 0;
    }

    public void build(int[] array){

        for (int i = 0; i < array.length; i++){
            add(array[i]);
        }
    }

    public void add(int value){

        increaseSize();

        data[size++] = value;
        handleSwipUp();
    }

    public int remove(){

        if (size == 0){
            throw new NoSuchElementException();
        }

        int root = data[0];

        data[0] = data[size-1];
        size--;
        handleSwipDown();

        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return data[0];
    }

    private void handleSwipUp(){

        int index = size-1;
        while (hasParent(index) && parent(index) > data[index]){
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    private void handleSwipDown(){

        int index = 0;

        while(hasLeftChild(index)) {
            int smallerChild = getleftChild(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChild = getRightChild(index);
            }

            if (data[index] < data[smallerChild]){
                break;
            } else {
                swap(index, smallerChild);
            }

            index = smallerChild;
        }

    }

    private void swap(int index1, int index2){

        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    private void increaseSize(){

        if (data.length - size < 1){
            data = Arrays.copyOf(data, data.length + (data.length / 2));
        }
    }

    private int getParent(int i){
        return (i - 1) / 2;
    }

    private int getleftChild(int i){
        return i * 2 + 1;
    }

    private int getRightChild(int i){
        return i * 2 + 2;
    }

    private boolean hasLeftChild(int index){
        return getleftChild(index) < size;
    }

    private boolean hasRightChild(int index){
        return getRightChild(index) < size;
    }

    private boolean hasParent(int index){
        return getParent(index) >= 0;
    }

    private int leftChild(int index) {
        return data[getleftChild(index)];
    }

    private int parent(int index){
        return data[getParent(index)];
    }

    private int rightChild(int index){
        return data[getRightChild(index)];
    }

    public String toString() {

        StringBuilder temp = new StringBuilder("[");

        for (int i  = 0; i < size; i++){

            if (data[i] != 0){
                temp.append(data[i] + ", ");
            }
        }
        String output = temp.toString().substring(0, temp.length()-2) + "]";
        return output;
    }
}
