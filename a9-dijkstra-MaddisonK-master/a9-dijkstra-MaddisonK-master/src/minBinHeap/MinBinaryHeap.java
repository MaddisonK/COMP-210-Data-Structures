package minBinHeap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class MinBinaryHeap <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

	private List<Prioritized<V,P>> _heap;
	
	/**
	 * Constructor that creates an empty heap of Prioritized objects.
	 */
    public MinBinaryHeap() {    	
    	_heap = new ArrayList<Prioritized<V,P>>();
    }
    
    /**
     * Constructor that builds a heap given an initial array of Prioritized objects.
     */
    public MinBinaryHeap(Prioritized<V, P>[] initialEntries) {
    	_heap = new ArrayList<Prioritized<V,P>>();

			Collections.addAll(_heap, initialEntries);
    	
    	if (_heap.size() >= 2) {
    		int cidx = (_heap.size()/2) - 1;
    		
    		while (cidx != 0) {
    			bubble_down(cidx);
    			cidx--;
    		}
    	}
    }

    @Override
    public int size() {
    	return _heap.size();
    }

    @Override
    public void enqueue(V value, P priority) {
    	Prioritized<V,P> e = new PrioritizedImpl<V,P>(value, priority);
    	
    	_heap.add(e);
    	bubble_up(_heap.size()-1);
    }

    @Override
    public V dequeue() {
    	V result = getMinValue();
    	
    	if (size() == 1) {
    		_heap.remove(0);
    	} else {
    		_heap.set(0, _heap.remove(size()-1));
    	}
    	bubble_down(0);
    	
    	return result;
    }

    @Override
    public V getMinValue() {
    	if (size() < 1) {
    		throw new NoSuchElementException();
    	}
    	
    	return _heap.get(0).getValue();
    }

	@Override
	public Prioritized<V,P> getMin() {
		if (size() < 1) {
			throw new NoSuchElementException();
		}

		return _heap.get(0);
	}


	@Override
    public Prioritized<V, P>[] getAsArray() {
    	Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
    	return _heap.toArray(result);
    }
    
    private void bubble_down(int idx) {
    	while (!is_leaf(idx)) {
    		int min_child = get_left(idx);
    		if (has_right(idx)) {
    			int ridx = get_right(idx);
    			if (compare_entries(ridx, min_child) <= 0) {
    				min_child = ridx;
    			}
    		}
    		if (compare_entries(idx, min_child) <= 0) {
    			return;
    		} else {
    			swap(idx, min_child);
    			idx = min_child;
    		}
    	}
    }
    
    private void bubble_up(int idx) {
    	while (idx > 0) {
    		int pidx = get_parent(idx);
    		if (compare_entries(idx, pidx) <= 0) {
    			swap(idx, pidx);
    			idx = pidx;
    		} else {
    			return;
    		}
    	}
    }
    
    private boolean is_leaf(int i) {
    	return !has_left(i);
    }
    
    private int get_left(int i) {
    	return i*2+1;
    }
    
    private int get_right(int i) {
    	return i*2+2;
    }
    
    private boolean has_left(int i) {
    	return get_left(i) < size();
    }
    
    private boolean has_right(int i) {
    	return get_right(i) < size();
    }
    
    private int get_parent(int i) {
    	return (i-1)/2;
    }
    
    private int compare_entries(int i, int j) {
    	return _heap.get(i).getPriority().compareTo(_heap.get(j).getPriority());    
    }
    
    private void swap(int i, int j) {
    	Prioritized<V,P> tmp = _heap.get(i);
    	_heap.set(i, _heap.get(j));
    	_heap.set(j, tmp);
    }
}
