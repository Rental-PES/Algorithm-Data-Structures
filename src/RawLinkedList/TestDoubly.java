package RawLinkedList;

public class TestDoubly {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);
        list.addFirst(0);

        list.printAll();

        System.out.println("test delete first and last");
        list.deleteFirst();
        list.deleteLast();
        list.printAll();

        System.out.println("test delete after 30 : 40");
        list.deleteAfter(30);
        list.printAll();


        System.out.println("test delete before 50 : 30");
        list.deleteBefore(50);
        list.printAll();

        System.out.println("test insert after 50 : 100");
        list.insertAfter(50, 100);
        list.printAll();

        System.out.println("test insert before 20 : 999");
        list.insertBefore(20, 999);
        list.printAll();

        System.out.println("============");
        list.printReverse();
    }
}
