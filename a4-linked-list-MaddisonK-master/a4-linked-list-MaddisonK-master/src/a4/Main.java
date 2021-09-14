package a4;


public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList<Integer>();
        list.add(1);
        list.add(3);
        LinkedList list2 = new LinkedList<Integer>();
        list2.add(2);
        list2.add(4);
        list2.add(5);
//        list.removeAtIndex(0);
        list.merge(list2);
        System.out.println(list.toString());
    }
}
