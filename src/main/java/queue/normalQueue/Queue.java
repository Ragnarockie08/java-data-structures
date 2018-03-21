package queue.normalQueue;

public class Queue<T> {

    private Node<T> peekItem;
    private Node<T> lastItem;
    private int size;

    public Queue() {
    }

    public void enqueue(T value){
        Node node = new Node(value);

        if (peekItem == null){
            peekItem = node;
            lastItem = node;
        } else {
            lastItem.setNextNode(node);
            lastItem = node;
        }
        size++;
    }

    public void dequeue(){

        if (peekItem.getNextNode() == null){
            peekItem = null;
            lastItem = null;
        } else {
            peekItem = peekItem.getNextNode();
        }
        size--;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){

        if (peekItem == null){
            return null;
        }
        Node temp = peekItem;
        StringBuilder output = new StringBuilder();

        while (temp != null){
            output.append(temp.getValue()+ " ");
            temp = temp.getNextNode();
        }

        return output.toString();
    }
}
