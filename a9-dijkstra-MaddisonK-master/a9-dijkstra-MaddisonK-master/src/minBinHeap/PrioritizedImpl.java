package minBinHeap;

public class PrioritizedImpl<V, P extends Comparable<P>> implements Prioritized<V,P> {
    private V value;
    private P priority;

    public PrioritizedImpl(V value, P priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public P getPriority() {
        return priority;
    }
}