package RawLinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertNode(10);
        list.insertNode(20);
        list.insertNode(30);
        list.printAll();
        System.out.println("test delete");
        list.deleteNode();
        list.printAll();

    }
}
