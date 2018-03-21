package queue.priorityQueue;

import java.util.NoSuchElementException;

public class CustomQueue<T> {

    private Node<T> peekItem;
    private Node<T> last;
    private int size;

    public CustomQueue() {
        this.peekItem = null;
        this.size = 0;
    }

    public void enqueue(Node node){

        if (peekItem == null){
            peekItem = node;
            last = node;
        }else {
            last.setNextNode(node);
            last = node;
        }
        size++;
    }

    public void enqueue(T value, int priority){

        Node node = new Node(value);
        node.setPriority(priority);

        if (peekItem == null || priority <= last.getPriority()){
            enqueue(node);
        }else {
            handlePriorityQueue(node);
        }
    }

    public void dequeue(){

        handleEmptyQueue();

        if (peekItem.getNextNode() == null){
            peekItem = null;
            last = null;
        } else {
            peekItem = peekItem.getNextNode();
        }
        size--;
    }

    public Node<T> peek(){

        handleEmptyQueue();

        if (peekItem != null){
            return peekItem;
        } else {
            throw new NoSuchElementException();
        }
    }

    public int queueSize(){
        return size;
    }

    public boolean isEmpty(){
        return peekItem == null;
    }

    public void handleEmptyQueue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
    }

    private void handlePriorityQueue(Node node){

        Node temp = peekItem;
        Node elem = temp;

        if (peekItem.getNextNode() == null) {
            if (peekItem.getPriority() >= node.getPriority()){
                peekItem.setNextNode(node);
            } else {
                node.setNextNode(peekItem);
                peekItem = node;
            }
        } else {
            while (node.getPriority() <= temp.getPriority() && temp.getNextNode() != null){
                elem = temp;
                temp = temp.getNextNode();
            }
            if (node.getPriority() > peekItem.getPriority()){
                node.setNextNode(peekItem);
                peekItem = node;
            } else {
                node.setNextNode(temp);
                elem.setNextNode(node);
            }
        }
        size++;
    }

    @Override
    public String toString(){

        String output = "";
        Node element;

        if (size == 0){
            output = "[]";
        } else if (peekItem.getNextNode() == null){
            output = String.valueOf(peekItem.getValue());
        } else {
            element = peekItem;

            while(element.getNextNode() != null){
                output += " " + element.getValue();
                element = element.getNextNode();
            }
            output += " " + element.getValue();
        }
        return output;
    }

}
