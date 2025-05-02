public class MinhaPilha<T> {
    private No<T> top;

    public MinhaPilha() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        No<T> newNo = new No<>(data);
        newNo.next = top;
        top = newNo;
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
