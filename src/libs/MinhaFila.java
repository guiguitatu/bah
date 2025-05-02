package libs;

public class MinhaFila<T> {
    private NoNext<T> front;
    private NoNext<T> rear;

    public MinhaFila() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(T data) {
        NoNext<T> newNoNext = new NoNext<>(data);
        if (isEmpty()) front = newNoNext;
        else rear.next = newNoNext;
        rear = newNoNext;
    }

    public T deQueue() {
        if (isEmpty()) return null;
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public T peek() {
        if (isEmpty()) return null;
        return front.data;
    }
}
