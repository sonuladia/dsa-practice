class Node {
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        this.next = null;
    }
    

}

public class LinkedList {
    private Node head;
    private int size;

    LinkedList(){
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }
    
    public void insertAtHead(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtTail(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            head = newNode;
            size++;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public void insertAtIndex(int value, int index){
        Node newNode = new Node(value);
        if (index == 0){
            newNode.next = head;
            head = newNode;
            size++; return;
        }

        Node current = head;
        int counter = 0;

        while(current != null && counter < index-1){
            current = current.next;
            counter++;
        }

        if(current == null) {
            System.out.println("Index out of bound, can't insert at this position");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void deleteFromHead(){
        if(isEmpty()){
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
    }

    public void deleteFromTail(){
        if(isEmpty()){
            System.out.println("List is Empty");
            return;
        }

        if(head.next == null){
            head = null;
            size--;
            return;
        }

        Node current = head;
        Node previous = null;
        while(current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
        size--;
    }

    public void deleteAtIndex(int index){
        if(index < 0 || index > size - 1){
            System.out.println("Index out of bound");
            return;
        }
        if(isEmpty()){
            System.out.println("List is Empty");
            return;
        }
        if(index == 0){
            Node temp = head;
            head = head.next;
            temp.next = null;
            size--; return;
        }

        Node current = head;
        int counter = 0;

        while(current != null && counter < index-1){
            current = current.next;
            counter++;
        }
        Node temp = current.next;
        current.next = temp.next;
        temp.next = null;
        size--;
    }

    public int getAtIndex(int index){
        if(index < 0 || index > size - 1){
            System.out.println("Index out of bound");
            return 0;
        }
        if(isEmpty()){
            System.out.println("List is Empty");
            return 0;
        }
        if(index == 0){
            return head.data;
        }

        Node current = head;
        int counter = 0;

        while(current != null && counter < index-1){
            current = current.next;
            counter++;
        }
        return current.next.data;
    }

    public void print(){
        if(isEmpty())
            System.out.print("List is Empty");
        Node current = head;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
            if(current == null)
                System.out.println("null");
        }
    }

    public static void main(String args[]){
/*        LinkedList list = new LinkedList();
        list.insertAtHead(9);
        list.insertAtHead(8);
        list.insertAtHead(7);
        list.insertAtHead(6);
        list.insertAtHead(5);
        list.print();
        System.out.print("Size:- " + list.size());*/

        LinkedList list = new LinkedList();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.insertAtIndex(6,5);
        list.print();
        System.out.println("Data at " + 1 + " is:- " + list.getAtIndex(1));

        //list.deleteAtIndex(9);
/*        list.deleteFromTail();
        list.deleteFromTail();
        list.deleteFromTail();
        list.deleteFromTail();
        list.deleteFromTail();*/
        list.print();
/*        list.deleteFromHead();
        list.deleteFromHead();
        list.print();*/
        System.out.print("Size:- " + list.size());

    }

}

