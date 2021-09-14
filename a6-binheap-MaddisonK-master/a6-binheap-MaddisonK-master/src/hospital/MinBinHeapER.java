package hospital;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MinBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;
    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MinBinHeapER() {
        _heap = new ArrayList<>();
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO: overloaded constructor
    public MinBinHeapER(Prioritized<V, P>[] initialEntries ) {

    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        _heap.add(patient);
        if (size() == 0) {
            return;
        }
        int current_i = size() -1;
        while (current_i != 0) {
            int compare_i = ((current_i-1)/2);
            if (_heap.get(current_i).getPriority().compareTo(_heap.get(compare_i).getPriority()) < 0) {
                Prioritized replaced = _heap.set(compare_i, _heap.get(current_i));
                _heap.set(current_i, replaced);
            } else {
                return;
            }
            current_i = compare_i;
        }
    }

    // TODO: enqueue
    public void enqueue(V value) {
        Patient patient = new Patient(value);
        _heap.add(patient);
        if (size() == 0) {
            return;
        }
        int current_i = size() -1;
        while (current_i != 0) {
            int compare_i = ((current_i-1)/2);
            if (_heap.get(current_i).getPriority().compareTo(_heap.get(compare_i).getPriority()) < 0) {
                Prioritized replaced = _heap.set(compare_i, _heap.get(current_i));
                _heap.set(current_i, replaced);
            } else {
                return;
            }
            current_i = compare_i;
        }
    }

    // TODO: dequeue
    @Override
    public V dequeue() {
        if (size() == 0) {
            return null;
        }
        if (size() == 1) {
            return _heap.remove(0).getValue();
        }
        Prioritized end = _heap.remove(size() - 1);
        V min_p = (V) _heap.set(0, end).getValue();
        int current_i = 0;
        while ((current_i * 2) + 2 <= size() - 1) {
            int compare_iL = (current_i * 2) + 1;
            int compare_iR = (current_i * 2) + 2;
            if ((_heap.get(current_i).getPriority().compareTo(_heap.get(compare_iL).getPriority()) > 0) | (_heap.get(current_i).getPriority().compareTo(_heap.get(compare_iR).getPriority()) > 0)) {
                if (_heap.get(compare_iL).getPriority().compareTo(_heap.get(compare_iR).getPriority()) < 0) {
                    // replace left
                    Prioritized replaced = _heap.set(compare_iL, _heap.get(current_i));
                    _heap.set(current_i, replaced);
                    current_i = compare_iL;
                } else {
                    // replace right
                    Prioritized replaced = _heap.set(compare_iR, _heap.get(current_i));
                    _heap.set(current_i, replaced);
                    current_i = compare_iR;
                }
            } else {
                return min_p;
            }
        }
        //check for last left
        if ((current_i * 2) + 1 <= size() - 1) {
            int compare_iL_last = (current_i * 2) + 1;
            if ((_heap.get(current_i).getPriority().compareTo(_heap.get(compare_iL_last).getPriority()) > 0)) {
                Prioritized replaced = _heap.set(compare_iL_last, _heap.get(current_i));
                _heap.set(current_i, replaced);
            }
        }
            return min_p;
    }

    // TODO: getMin
    @Override
    public V getMin() {
        if (size() == 0) {
            return null;
        }
       return _heap.get(0).getValue();
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }






}
