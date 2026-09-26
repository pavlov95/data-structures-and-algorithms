package queue.implementation;

public class CircularQueue<T> {

    private final Object[] elements;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        elements = new Object[capacity];
    }

    //Time: O(1)
    public void enqueue(T value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        elements[rear] = value;

        rear = (rear + 1) % elements.length;
        size++;
    }

    //Time: O(1)
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T value = (T) elements[front];
        elements[front] = null;

        front = (front + 1) % elements.length;
        size--;

        return value;
    }

    //Time: O(1)
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return (T) elements[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return elements.length;
    }

    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }

        front = 0;
        rear = 0;
    }
}