package queue.implementation;

class QueueNode<T> {

    T value;
    QueueNode<T> next;

    QueueNode(T value) {
        this.value = value;
    }
}
