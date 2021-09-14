package a7;

import javax.sound.midi.SysexMessage;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree();
        avl = (AVLTree<Integer>) avl.insert(47);
        avl = (AVLTree<Integer>) avl.insert(52);
        avl = (AVLTree<Integer>) avl.insert(60);
        avl = (AVLTree<Integer>) avl.insert(3);
        avl = (AVLTree<Integer>) avl.insert(7);
        avl = (AVLTree<Integer>) avl.insert(10);
        avl = (AVLTree<Integer>) avl.insert(58);
        avl = avl.remove(7);
        avl = avl.remove(3);
        avl = avl.remove(10);

        avl.traverse();

        if (false) {
            // Create a new empty tree.

            SelfBalancingBST<Integer> avl_bst1 = new AVLTree<Integer>(8);

            // Insert 50 random integers.
            // Note how we need to capture the result of insert back into
            // the variable avl_bst because the post insertion root that is
            // returned might change because of the insertion

//            for (int i = 0; i < 50; i++) {
//                avl_bst = avl_bst.insert((int) (Math.random() * 100));
//            }

//            System.out.println(avl_bst.height());
//
//            // Now insert 50 integers in increasing order which would
//            // cause a simple BST to become very tall but for our
//            // self-balancing tree won't be too bad.
//
////            for (int i = 0; i < 50; i++) {
////                avl_bst = avl_bst.insert(i);
////            }
//
//            System.out.println(avl_bst.height());
        }
    }
}
