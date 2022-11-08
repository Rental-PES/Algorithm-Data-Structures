package MODUL2.NO1;

public class Main {
    public static void main(String[] args) {
        // inisiasi stack
        Stack mainStack = new Stack();
        // memasukkan nilai kedalam stack
        mainStack.push("Goku");
        mainStack.push("Anya");
        mainStack.push("Nagato");
        mainStack.push("Denji");
        mainStack.push("Loid");
        // memanggil fungsi printAll untuk memperlihatkan seluruh isi stack ke layar
        mainStack.printAll();

        // menampilkan kalimat after
        System.out.println("After : ");
        // memanggil fungsi selectedPop dengan Anya sebagai target untuk menghapus anya
        mainStack.selectedPop("Anya");
        // memanggil fungsi printAll untuk memperlihatkan seluruh isi stack ke layar
        mainStack.printAll();
    }
}
