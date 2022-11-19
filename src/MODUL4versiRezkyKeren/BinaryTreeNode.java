package MODUL4versiRezkyKeren;

// Membuat kelas MODUL4.BinaryTreeNode dengan public visibility modifier
// Gunanya adalah sebagai container data di dalam tree
public class BinaryTreeNode {
    // Didalamnya terdapat beberapa atribut yaitu right, left, dan parent
    // Atribut right adalah untuk menyimpan rujukan untuk Node yang akan berada di sebelah kanan bawahnya
    BinaryTreeNode right;
    // Atribut left adalah untuk menyimpan rujukan untuk Node yang akan berada di sebelah kiri bawahnya
    BinaryTreeNode left;
    // Atribut parent adalah untuk menyimpan rujukan untuk Node yang akan berada di di atasnya
    BinaryTreeNode parent;
    // Atribut data adalah untuk menyimpan nilai utamanya
    String data;
    // Atribut level digunakan untuk mencatat kedalaman atau level dari sebuah node
    int level = 1;

    // Disini saya menggunakan constructor overloading untuk membuat 2 tipe constructor

    // Di constructor ini saya hanya menggunakan 1 parameter, digunakan untuk menginisiasi root saja yang tidak perlu parent
    BinaryTreeNode(String data){
        // jadi yang perlu diinput hanya datanya saja
        this.data = data;
    }

    // Di constructor ini saya menggunakan 3 parameter, gunanya untuk node yang bukan root (child) oleh karena itu memiliki parent
    // data untuk nilai yang disimpan, level untuk mengupdate level yang sudah ada defaultnya, dan parent sebagai penghubung ke bagian tree lainnya
    BinaryTreeNode(String data, int level, BinaryTreeNode parent){
        this.parent = parent;
        this.data = data;
        this.level = level;
    }






}
