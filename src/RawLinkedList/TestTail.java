package RawLinkedList;

public class TestTail {
    public static void main(String[] args) {
        LinkedListTail list = new LinkedListTail();
        list.addHead(10);
        list.addTail(20);
        list.addTail(30);
        list.addTail(40);
        list.addHead(0);

        list.printAll();

        System.out.println("test delete head & tail");
        list.removeHead();
        list.removeTail();
        list.printAll();
    }
}
