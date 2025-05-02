package libs;

public class NoNext<T> {
    public T data;
    public NoNext<T> next;

    public NoNext(T data) {
        this.data = data;
        this.next = null;
    }
}

