public class LinkedList<T> implements List<T> {
    private Node<T> front;
    private int size;

    LinkedList() {
        front = null;
        size = 0;
    }

    public void add(T item) {
        if(front == null)
            front = new Node<>(item);
        else {
            Node<T> current = front;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<>(item));
        }
        size++;
    }

    public void add(int ind, T item) {
        if (ind == 0) {
            Node<T> n = new Node<>(item);
            n.setNext(front);
            front = n;
        }
        else {
            Node<T> previous = front;
            for (int i = 0; i < ind - 1; i++)
                previous = previous.getNext();
            Node<T> n = new Node<>(item);
            n.setNext(previous.getNext());
            previous.setNext(n);
        }
        ++size;
    }

    public T remove(int ind) {
        if(ind == 0) {
            Node<T> current = front;
            front = front.getNext();
            size--;
            return current.getData();
        }
        else {
            Node<T> previous = front;
            for (int i = 0; i < ind - 1; i++)
                previous = previous.getNext();
            Node<T> current = previous.getNext();
            previous.setNext(current.getNext());
            size--;
            return current.getData();
        }
    }

    public int size() {
        return size;
    }

    public T get(int ind) {
        Node<T> n = front;

        for(int i = 0; i < ind; i++)
            n = n.getNext();
        return n.getData();
    }

    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            next = null;
        }
        void setNext(Node next) {
            this.next = next;
        }
        Node getNext() {
            return this.next;
        }
        T getData() {
            return this.data;
        }
    }
}