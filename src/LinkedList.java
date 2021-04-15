import java.util.NoSuchElementException;

class MyLinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;


    public void addLast(int item) {
        var node = new Node(item);
        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if (first == null) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        if (first == last) {
            first = last = null;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        if (first == last) {
            first = last = null;
        } else {
            last = getPrevious(last);
            last.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (first == null) {
            return;
        }

        var previous = first;
        var second = first.next;

        while (second != null) {
            var next = second.next;
            second.next = previous;
            second = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        var a = first;
        var b = first;

        for(int i = 0; i < k - 1; i++) {
            b = b.next;
            if(b == null) {
                throw new IllegalArgumentException();
            }
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

}
