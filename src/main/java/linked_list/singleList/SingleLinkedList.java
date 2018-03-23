package linked_list.singleList;

public class SingleLinkedList<E> {

    private Node head;

    private Node end;

    private int size;

    public SingleLinkedList() {
        head = null;
        end = null;
        size = 0;
    }

    public void add(E value){

        Node<E> node = new Node(value);


        if (head == null){
            head = node;
            end = node;
        } else{
            end.setLink(node);
            end = node;
        }
        size++;
    }

    public void addAtBeggining(E value){
        Node<E> node = new Node(value);


        if (head == null){
            head = node;
            end = node;
        } else{
            node.setLink(head);
            head = node;
        }
        size++;
    }

    public void add(int index, E value){

        Node<E> node = new Node<>(value);

        if (index == 0) {
            addAtBeggining(value);
        } else if(index == size){
            add(value);
        } else if (index > 0 && index < size){
            Node elem = head;
            Node temp = elem;
            for (int i = 0; i < index; i++){
                temp = elem;
                elem = elem.getLink();
            }
            temp.setLink(node);
            node.setLink(elem);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        size++;
    }

    public void remove(int index){

        if (index == 0){
            head = head.getLink();
        } else if (index == size-1){
            removeEnd();
        } else if (index > 0 && index < size-1){
            removeMiddle(index);
        }
        size--;
    }

    public int size(){
        return size;
    }

    public String toString(){

        String output = "";

        Node temp = head;
        while(temp != null){
            output += " " + temp.getValue() ;
            temp = temp.getLink();
        }

        return output;
    }

    private void removeEnd(){
        Node start = head;
        Node temp = head;
        while(start != end){
            temp = start;
            start = start.getLink();
        }
        end = temp;
        end.setLink(null);
    }

    private void removeMiddle(int index){

        Node elem = head;
        for (int i = 1; i < index; i++){
            elem = elem.getLink();
        }
        Node temp = elem.getLink();
        temp = temp.getLink();
        elem.setLink(temp);
    }
}
