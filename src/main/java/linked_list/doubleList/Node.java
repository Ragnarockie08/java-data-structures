package linked_list.doubleList;

public class Node<T> {

    private Node<T> prevLink;
    private Node<T> nextLink;
    private T value;

    public Node( T value) {
        this.prevLink = null;
        this.nextLink = null;
        this.value = value;
    }

    public Node<T> getPrevLink() {
        return prevLink;
    }

    public Node<T> getNextLink() {
        return nextLink;
    }

    public T getValue() {
        return value;
    }

    public void setPrevLink(Node<T> prevLink) {
        this.prevLink = prevLink;
    }

    public void setNextLink(Node<T> nextLink) {
        this.nextLink = nextLink;
    }
}
