package libs;

public class Root<T> {
    public T data;
    public Root<T> left;   // “.”
    public Root<T> right;  // “-”

    public Root(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
