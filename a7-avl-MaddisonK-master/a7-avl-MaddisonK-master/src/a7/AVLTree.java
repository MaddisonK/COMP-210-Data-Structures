package a7;
import javax.sound.midi.SysexMessage;
import java.lang.Math;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    T _element;
    AVLTree<T> _left;
    AVLTree<T> _right;
    int size;
    boolean empty;

    public AVLTree() {
        _element = null;
        _left = null;
        _right = null;
        size = 0;
        empty = true;
    }
    
    public AVLTree(T element) {
        _element = element;
        _left = new AVLTree<T>();
        _right = new AVLTree<T>();
        size = 1;
        empty = false;
    }

    /**
     *
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
    
     public AVLTree<T> rotateLeft() {
         T root_element_copy = this.getValue();
         SelfBalancingBST<T> root_left_copy = this.getLeft();
         SelfBalancingBST<T> right = this.getRight();
         // Rearrangement
         this._element = right.getValue();
         this._right = (AVLTree<T>) right.getRight();
         AVLTree<T> new_left = new AVLTree<T>(root_element_copy);
         new_left._left = (AVLTree<T>) root_left_copy;
         new_left._right = (AVLTree<T>) right.getLeft();
         this._left = new_left;
         return this;
     }
    
    /**
     *
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */ 
     
     public AVLTree<T> rotateRight() {
        T root_element_copy = this.getValue();
        SelfBalancingBST<T> root_right_copy = this.getRight();
        SelfBalancingBST<T> left = this.getLeft();
        // Rearrangement
        this._element = left.getValue();
        this._left = (AVLTree<T>) left.getLeft();
        AVLTree<T> new_right = new AVLTree<T>(root_element_copy);
        new_right._right = (AVLTree<T>) root_right_copy;
        new_right._left = (AVLTree<T>) left.getRight();
        this._right = new_right;
        return this;

     }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
         if (getValue() == null) {
             return new AVLTree<T>(element);
         }
        if (element.compareTo(_element) < 0) {
            _left = (AVLTree<T>) _left.insert(element);
        } else {
            _right = (AVLTree<T>) _right.insert(element);
        }

        // check heights
        if (Math.abs(_left.height() - _right.height()) > 1) {
            if (_left.height() > _right.height()) {
               if (_left.getRight().height() > _left.getLeft().height()) {
                   // LR
                   AVLTree<T> left = (AVLTree<T>) getLeft();
                   left.rotateLeft();
                   rotateRight();
               } else {
                   // LL
                   rotateRight();
               }
            } else {
                if (_right.getLeft().height() > _right.getRight().height()) {
                    // RL
                    AVLTree<T> right = (AVLTree<T>) getRight();
                    right.rotateRight();
                    rotateLeft();
                } else {
                    // RR
                    rotateLeft();
                }
            }
        }
        size += 1;
        return this;
    }

    @Override
    public AVLTree<T> remove(T element) {
         if (_element == null) {
             return this;
         }
        if (element.compareTo(_element) == 0) {
            if (_right.getValue() == null & _left.getValue() == null) {
                return (AVLTree<T>) _right;
            } else if (_left.getValue() == null) {
                return (AVLTree<T>) _right;
            } else if (_right.getValue() == null) {
                return (AVLTree<T>) _left;
            } else {
                T rightMin = _right.findMin();
                this._right.remove2(rightMin);
                this._element = rightMin;
            }
        } else {
            _left = _left.remove(element);
            _right = _right.remove(element);
        }

        // check heights
        if (Math.abs(_left.height() - _right.height()) > 1) {
            if (_left.height() > _right.height()) {
                if (_left.getRight().height() > _left.getLeft().height()) {
                    // LR
                    AVLTree<T> left = (AVLTree<T>) getLeft();
                    left.rotateLeft();
                    rotateRight();
                } else {
                    // LL
                    rotateRight();
                }
            } else {
                if (_right.getLeft().height() > _right.getRight().height()) {
                    // RL
                    AVLTree<T> right = (AVLTree<T>) getRight();
                    right.rotateRight();
                    rotateLeft();
                } else {
                    // RR
                    rotateLeft();
                }
            }
        }
        size-= 1;
        return this;
    }

    private AVLTree<T> remove2(T element) {
        if (_element == null) {
            return this;
        }
        if (element.compareTo(_element) == 0) {
            if (_right.getValue() == null & _left.getValue() == null) {
                return (AVLTree<T>) _right;
            } else if (_left.getValue() == null) {
                return (AVLTree<T>) _right;
            } else if (_right.getValue() == null) {
                return (AVLTree<T>) _left;
            } else {
                T rightMin = _right.findMin();
                this._right.remove2(rightMin);
                this._element = rightMin;
            }
        } else {
            _left = _left.remove(element);
            _right = _right.remove(element);
        }

        size -=1;
        return this;
    }

    @Override
    public T findMin() {
        T value;
        if (_left.getValue() == null) {
            return _element;
        } else {
            value = _left.findMin();
        }
        return value;
    }

    @Override
    public T findMax() {
        T value;
        if (_right.getValue() == null) {
            return _element;
        } else {
            value = _right.findMax();
        }
        return value;
    }

    @Override
    public boolean contains(T element) {
         if (_element == null) {
             return false;
         }
        if (element.compareTo(_element) == 0) {
            return true;
        }
        boolean value;
        if (element.compareTo(_element) < 0) {
            value = _left.contains(element);
        } else {
            value = _right.contains(element);
        }
        if (!value) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public T getValue() {
        return _element;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        return _right;
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }

    @Override
    public int height() {
         if (getValue() == null) {
             return -1;
         }
        return Math.max(_left.height(), _right.height())+1;
    }

    public void traverse() {
        if (getValue() == null) {
            return;
        } else {
            System.out.println(getValue());
            _left.traverse();
            _right.traverse();
        }
    }

}
