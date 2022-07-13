package dal;

public interface DAO<T> {
    public T get(T data);
}
