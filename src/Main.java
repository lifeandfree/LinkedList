public class Main {

    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        java.util.LinkedList linkedList1 = new java.util.LinkedList();

        Integer a = 7;
        int b = 8;
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(a);
        linkedList.add(b);
        System.out.println(linkedList.contains(a));
        System.out.println(linkedList.contains(b));
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(3));
        //linkedList.set(3,1);
        linkedList.remove(a);
        System.out.println(linkedList.get(3));
        System.out.println(linkedList);
        //linkedList1.

    }
}
