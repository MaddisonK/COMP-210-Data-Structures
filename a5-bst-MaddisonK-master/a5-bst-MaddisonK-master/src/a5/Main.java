package a5;


public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values to it.
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<Integer>(30);
//    bst = bst.insert(8);
//    bst = bst.insert(12);
//    bst = bst.insert(4);
//    bst = bst.insert(40);
//    bst = bst.insert(37);
//    bst = bst.insert(52);
//    bst = bst.insert(39);
//    bst = bst.insert(26);
//    bst = bst.insert(29);
//    bst = bst.insert(10);
    bst = bst.remove(30);
    bst.printInOrderTraversal();
    System.out.println(" ");
    System.out.println(bst.size());
  }

}
