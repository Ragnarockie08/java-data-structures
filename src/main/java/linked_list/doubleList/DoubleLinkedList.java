package linked_list.doubleList;

public class DoubleLinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {

        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(E value){

        Node newNode = new Node(value);

        if(head==null){
            head=newNode;
            tail=newNode;
        }else {
            newNode.setPrevLink(tail);
            tail.setNextLink(newNode);
            tail = newNode;
        }
        size++;
    }

    private void addAtBeggining(E value){

        Node newNode = new Node(value);

        if(head==null){
            head=newNode;
            tail=newNode;
        }else {
            head.setPrevLink(newNode);
            newNode.setNextLink(head);
            head = newNode;
        }
        size++;
    }

    public void add(int index, E value){

        Node node = new Node(value);

        if (index == 0) {
            addAtBeggining(value);
        } else if (index == size){
            add(value);
        } else if (index > 0 && index < size){
            Node start = head;
            for (int i = 1; i < size; i++){
                if (i == index){
                    Node tmp = start.getNextLink();
                    start.setNextLink(node);
                    node.setPrevLink(start);
                    node.setNextLink(tmp);
                    tmp.setPrevLink(node);
                }
                start = start.getNextLink();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        size++;
    }

    public void remove(int index){

        if (index == 0 && size() > 0){
            head = head.getNextLink();
            head.setPrevLink(null);
        } else if (index > 0 && index < size() - 1){
            Node start = head;
            for (int i = 0; i < size() -1; i++){
                if (i == index){
                    Node prev = start.getPrevLink();
                    Node next = start.getNextLink();

                    prev.setNextLink(next);
                    next.setPrevLink(prev);
                }
                start = start.getNextLink();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        size--;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){

        String output = "";

        Node temp = head;
        while(temp != null){
            output += " " + temp.getValue() ;
            temp = temp.getNextLink();
        }

        return output;
    }

}
