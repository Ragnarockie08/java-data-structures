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
        Node elem = head;

        if (index == 0) {
            addAtBeggining(value);
        } else if(index == size){
            add(value);
        } else if (index > 0 && index < size){
            for (int i = 1; i < size; i++){
                if (i == index){
                    Node temp = elem.getLink();
                    elem.setLink(node);
                    node.setLink(temp);
                }
                elem = elem.getLink();
            }
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
        for (int i = 1; i < size()-1; i++){
            if (i == index){
                Node temp = elem.getLink();
                temp = temp.getLink();
                elem.setLink(temp);
                break;
            }
            elem = elem.getLink();
        }
    }
}
