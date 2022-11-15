package RESPONMODUL1;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList timA = new DoublyLinkedList();
        timA.addLast("Goku");
        timA.addLast("Naruto");
        timA.addLast("Vegeta");
        timA.addLast("Tanjiro");
        timA.addLast("Akutagawa");
        timA.addLast("Flare");
        System.out.println("Tim A");
        timA.printAll();
        timA.printReverse();

        DoublyLinkedList timB = new DoublyLinkedList();
        timB.addLast("Tanjiro");
        timB.addLast("Itachi");
        timB.addLast("Vegeta");
        timB.addLast("Buu");
        timB.addLast("Madara");
        timB.addLast("Tanjiro");
        timB.addLast("Flare");
        timB.addLast("Denji");
        timB.addLast("Naruto");
        timB.addLast("Vegeta");
        System.out.println("Tim B");
        timB.printAll();
        timB.printReverse();
        System.out.println("Setelah Digabung");
        timA.joinWithoutDuplicate(timB);
        timA.printAll();
        timA.printReverse();
    }
}
