package RawLinkedList;

public class TestSorted {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(10);
        list.insert(8);
        list.insert(100);
        list.insert(1);
        list.printAll();

        // test length
        System.out.println("length : " + list.length());
        // test retrieve
        System.out.println("retrieve index 0 : " + list.retrieve(0));
        // test retrieve
        System.out.println("===== delete index 0 ======");
        list.delete(0);
        list.printAll();
    }
}
