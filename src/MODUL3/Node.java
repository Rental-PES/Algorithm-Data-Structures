package MODUL3;

// Membuat class node untuk container dari nilai barang
class Node{
    // atribut barang dengan tipe data barang untuk menyimpan nilai barnag
    public  Barang barang;
    // atribut prev dan next dengan tipe data node untuk menampung pointer penunjuk container berikutnya/sebelumnya
    public  Node next;
    public Node prev;
    // membuat constructor agar nilai barang harus langsung diisi jika membuat object baru dari node
    Node(Barang barang){
        this.barang = barang;

    }
}