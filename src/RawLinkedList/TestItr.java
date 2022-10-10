package RawLinkedList;

public class TestItr {
    public static void main(String[] args) {
        LinkedListItr list = new LinkedListItr();
        list.insertNext(1);
        list.insertNext(2);
        list.insertNext(3);
        list.insertNext(4);
        list.printAll();
        System.out.println("test first & advance : target 2");
        list.first();
        list.advance();
        System.out.println(list.retrieve());
        System.out.println("delete next : target 3");
        list.deleteNext();
        list.printAll();
        System.out.println("isLast : " + list.isLast());
        System.out.println("isPastEnd : " + list.isPastEnd());
        System.out.println("isInList : " + list.isInList());
        System.out.println("locate 4 ");
        list.locate(4);
        System.out.println("current : " + list.retrieve());
    }

}
