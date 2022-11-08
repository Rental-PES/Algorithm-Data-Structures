package MODUL3;

public class Main {
    public static void main(String[] args) {
        // mendeklarasikan object dari kelas barang dengan data sesuai jurnal
        Barang mizone = new Barang("Mizone", 6000,30);
        Barang indomieGoreng = new Barang("Indomie Goreng", 3500,8);
        Barang pulpy = new Barang("Pulpy", 3000,17);
        Barang indomieSoto = new Barang("Indomie Soto", 3000,12);
        Barang kopikap = new Barang("Kopikap", 1500,40);
        Barang nabatiCoklat = new Barang("Nabati Coklat", 2000,34);
        Barang nabatiPermenKaret = new Barang("Nabati Permen Karet", 2000,39);
        Barang kudaMasOriginal = new Barang("Kuda Mas Original", 1000,77);

        // mendeklarasikan objek untuk double linked list
        DoublyLinkedList list = new DoublyLinkedList();
        // proses memasukkan seluruh objek barang kedalam list
        list.addLast(mizone);
        list.addLast(indomieGoreng);
        list.addLast(pulpy);
        list.addLast(indomieSoto);
        list.addLast(kopikap);
        list.addLast(nabatiCoklat);
        list.addLast(nabatiPermenKaret);
        list.addLast(kudaMasOriginal);

        // menampilkan daftar barang
        System.out.println("============================================");
        System.out.println("               Daftar Barang                ");
        System.out.println("============================================");
        list.printAll();
        // memanggil metode bubble sort
        list.doBubbleSort();
        System.out.println("Urutkan berdasarkan nama : ");
        list.printAll();
        System.out.println("Urutkan berdasarkan harga : ");
        // memanggil metode insertion sort
        list.doInsertionSort();
        list.printAll();
        System.out.println("Urutkan berdasarkan stok : ");
        // memanggil metode merge sort
        list.doMergeSort();
        list.printAll();
        System.out.println();
        // melakukan pencarian barang
        System.out.println("Mencari Barang : " + indomieGoreng.getNama());
        // mencari barang dengan metode sequential
        list.sequentialSearch(indomieGoreng.getNama());
        System.out.println("Mencari Barang : " + nabatiCoklat.getNama());
        // mencari barang dengan metode sequential
        list.searchBinary(nabatiCoklat.getNama());
        System.out.println("Mencari Barang : " + pulpy.getNama());
        // mencari barang dengan metode sequential
        list.sequentialSearch(pulpy.getNama());
        System.out.println("Mencari Barang : Nabati Keju" );
        list.sequentialSearch("Nabati Keju");




    }
}
