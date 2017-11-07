package lab4;

public interface Config {
    <T> Class getImpl(Class<T> ifc);
}
