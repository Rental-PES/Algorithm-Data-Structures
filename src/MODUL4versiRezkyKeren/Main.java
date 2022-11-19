package MODUL4versiRezkyKeren;

// Membuat class MODUL4.Main dengan visibily modifier publik
public class Main {
    // Membuat fungsi main yang merupakan fungsi utama dari program ( satu satunya fungsi yang akan dibaca compiler )
    public static void main(String[] args) {
        // Membuat objek family dari kelas Balance Binary Tree
        BalanceBinaryTree family = new BalanceBinaryTree();
        // Menginisiasi tree pertama kali dengan fungsi init
        family.init("Daus");

        // Menambahkan child dari parent yang ada di dalam tree dengan memasukkan string target sebagai acuan dan data sebagai data node baru
        family.addChildren("Daus", "Putri");
        family.addChildren("Daus", "Daden");
        family.addChildren("Putri", "Ari");
        family.addChildren("Putri", "Lilul");
        family.addChildren("Daden", "Arsan");
        family.addChildren("Daden", "Jidan");
        family.addChildren("Ari", "Uno");
        family.addChildren("Ari", "Shafa");
        family.addChildren("Lilul", "Diaz");
        family.addChildren("Lilul", "Melki");
        family.addChildren("Arsan", "Mahen");
        family.addChildren("Arsan", "Alita");
        family.addChildren("Jidan", "Rozaki");
        family.addChildren("Jidan", "Agung");

        // Mencetak Teks Hubungan dengan pagebreak sebelumnya (\n)
        System.out.println("\nHubungan");
        // Melakukan pengecekan hubungan dengan fungsi checkRelationship dengan memasukkan 2 argumen yaitu nama orang yang ingin diketahui hubungannya
        family.checkRelationship("Putri", "Daus");
        family.checkRelationship("Shafa", "Daus");
        family.checkRelationship("Mahen", "Alita");
        family.checkRelationship("Mahen", "Uno");
        family.checkRelationship("Lilul", "Daus");
        family.checkRelationship("Melki", "Daden");
        family.checkRelationship("Rozaki", "Arsan");
        family.checkRelationship("Rozaki", "Ari");
        family.checkRelationship("Diaz", "Agung");


        // Mencetak Teks In-Order dengan pagebreak sebelumnya (\n)
        System.out.println("\nIn-Order\nNo. Parent : Child");
        // Memanggil fungsi doInorder yang akan menampilkan data tree secara inorder
        family.doInorder();
    }
}
