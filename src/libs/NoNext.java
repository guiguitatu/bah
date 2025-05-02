package libs;

public class No<T> {
    public T data;
    public No<T> next;

    public No(T data) {
        this.data = data;
        this.next = null;
    }
}

