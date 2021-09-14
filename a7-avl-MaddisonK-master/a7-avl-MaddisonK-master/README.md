# AVL Tree

Your task in A7 is to implement an AVL tree as an implementation of
the interface SelfBalancingTree. 

A skeleton AVLTree class has been provided. You must at least provide a 
constructor that takes no arguments and creates an empty AVLTree. You 
can either use a null element value to indicate that a tree is empty or
explicitly keep track of whether a tree is empty with a boolean field. You
can assume that null is not otherwise a valid value for inserting into a 
tree as an element.

Inserting and removing elements to a self-balancing tree may result is a different root
object after the insertion or removal because of self-balancing operations. This is why
these methods as declared in the interface return the potentially different post-operation
root of the tree. In your AVLTree implementation, this means you will need to recapture
the result whenever you recursively do something to a child. 

The skeleton also declares private rotateLeft and rotateRight methods. You should 
provide the code to implement these operations and then use them as necessary in
your implementation of insert and remove.

Self balancing trees are one of the more difficult Data Structures to implement so 
we highly recommend making use of the debugger to help with any issues you may run into. 
As always you should be writing your own JUnits to test your code instead of only 
relying on the autograder. 
