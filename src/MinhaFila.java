public class MinhaFila<T> {
    private No<T> front;
    private No<T> rear;

    public MinhaFila() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(T data) {
        No<T> newNo = new No<>(data);
        if (isEmpty()) front = newNo;
        else rear.next = newNo;
        rear = newNo;
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
