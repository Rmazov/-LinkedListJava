public class LinkedList {

    class Node {
        int value;
        Node next = null;
        Node(int value){
            this.value = value;
        }
    }

    protected Node head = null;
    protected Node tail = null;

    public void agregarValorAlInicio(int valor){
        Node nuevoNodo = new Node(valor);
        nuevoNodo.next = head;
        head = nuevoNodo;
        if(nuevoNodo.next == null) {
            tail = nuevoNodo;
        }
    }

    public void agregarFinal(int valor) {
        Node nuevoNodo = new Node(valor);
        if(tail == null){
            head = nuevoNodo;
        } else {
            tail.next = nuevoNodo;
            tail = nuevoNodo;
        }
    }

    public void agregarPorPosicion(int posicion, int valor){
        if(posicion < 0) {
            throw new IndexOutOfBoundsException();
        } else if(posicion == 0){
            agregarValorAlInicio(valor);
        } else{
            Node nuevoNodo = new Node(valor);
            Node actual = head;
            for (int i = 0; i < posicion-1; i++) {
                if(actual == null) {
                    throw new IndexOutOfBoundsException();
                }
                actual = actual.next;
            }
            if(actual.next == null){
                agregarFinal(valor);
            } else {
                nuevoNodo.next = actual.next;
                actual.next = nuevoNodo;
            }
        }

    }
    public int getValueAtPosition(int position) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (index == position) {
                System.out.println(current.value);
                return current.value;
            }
            current = current.next;
            index++;
        }
        throw new IndexOutOfBoundsException("Position " + position + " not found in the linked list");
    }
    public void deleteHead() {
        if (head == null) {

            return;
        }
        head = head.next;
    }
    public void deleteTail() {
        if (head == null) {
            // The list is empty, there is no tail to delete
            return;
        }
        if (head.next == null) {
            // The list has only one element, set the head to null
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    public void deleteNodeAtPosition(int position) {
        if (head == null) {

            return;
        }
        if (position == 0) {

            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current.next == null) {

                return;
            }
            current = current.next;
        }
        if (current.next == null) {

            return;
        }
        current.next = current.next.next;
    }
}
