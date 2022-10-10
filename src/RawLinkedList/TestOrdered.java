package RawLinkedList;

public class TestOrdered {
    public static void main(String[] args) {
        OrderedLinkedList list = new OrderedLinkedList();
        list.insert(0, "aldar"); // i = 0
        list.insert(1, "ali 1"); // i = 1
        list.insert(2, "ali 2"); // i = 2
        list.insert(2, "ali 3 ");
        list.insert(2, "ali 4");

        list.printAll(list);

        //test retrieve
        System.out.println("test retrieve index ke 2");
        System.out.println(list.retrieve(2));

        //test length
        System.out.println("test length");
        System.out.println(list.length());

        //test hapus
        System.out.println("------ hapus index ke 1 -------");
        list.delete(1);
        list.printAll(list);
        System.out.println("------ hapus index ke 0 -------");
        list.delete(0);
        list.printAll(list);
        System.out.println("------ hapus index ke 9 -------");
        list.delete(9);

    }
}
