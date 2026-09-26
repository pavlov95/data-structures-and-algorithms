package queue.implementation;

public class ArrayQueue<T> {

    private final Object[] elements;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        elements = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    //Time: O(1) Space: O(1)
    public void enqueue(T value) {
        if (size == elements.length) {
            throw new IllegalStateException("Queue is full");
        }

        elements[rear] = value;
        rear++;
        size++;
    }

    //Time: O(1) Space: O(1)
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T value = (T) elements[front];
        elements[front] = null;
        front++;
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

    public int size() {
        return size;
    }

    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
        front = 0;
        rear = 0;
    }
}