package hospital;

public interface Prioritized<V,P extends Comparable<P>> {
    V getValue();
    P getPriority();
}