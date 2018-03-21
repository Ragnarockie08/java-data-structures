package queue.priorityQueue;

public class Node<T> {
    private T value;
    private Node nextNode;
    private int priority;

    public Node(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Node getNextNode(){
        return this.nextNode;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }
}