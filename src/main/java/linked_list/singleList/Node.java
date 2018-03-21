package linked_list.singleList;

public class Node<T> {

    private T value;

    private Node<T> link;

    public Node(T value) {
        this.value = value;
        this.link = null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLink(Node<T> link) {
        this.link = link;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLink() {
        return link;
    }
}
