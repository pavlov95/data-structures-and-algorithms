package queue.implementation;

public class LinkedListQueue<T> {

    private QueueNode<T> front;
    private QueueNode<T> rear;
    private int size;

    //Time: O(1) Space: O(1)
    public void enqueue(T value) {
        QueueNode<T> newNode = new QueueNode<>(value);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }

        rear = newNode;
        size++;
    }

    //Time: O(1) Space: O(1)
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T value = front.value;
        front = front.next;
        size--;

        if (size == 0) {
            rear = null;
        }

        return value;
    }

    //Time: O(1)
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return front.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
}
