package libs;

public class MinhaPilha<T> {
    private NoNext<T> top;

    public MinhaPilha() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        NoNext<T> newNoNext = new NoNext<>(data);
        newNoNext.next = top;
        top = newNoNext;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }
}
