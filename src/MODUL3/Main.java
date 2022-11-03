package MODUL3;

public class Main {
    static void printAll(Barang arr[]){
        for (int i = 0; i<arr.length; i++){
            System.out.println(arr[i].toString());
        }
    }
    public static void main(String[] args) {
        Barang mizone = new Barang("Mizone", 6000,30);
        Barang indomieGoreng = new Barang("Indomie Goreng", 3500,8);
        Barang pulpy = new Barang("Pulpy", 3000,17);
        Barang indomieSoto = new Barang("Indomie Soto", 3000,12);
        Barang kopikap = new Barang("Kopikap", 1500,40);
        Barang nabatiCoklat = new Barang("Nabati Coklat", 2000,34);
        Barang nabatiPermenKaret = new Barang("Nabati Permen Karet", 2000,39);
        Barang kudaMasOriginal = new Barang("Kuda Mas Original", 1000,77);

        Barang[] barangs = {mizone, indomieGoreng, pulpy, indomieSoto, kopikap, nabatiCoklat, nabatiPermenKaret, kudaMasOriginal};

        printAll(barangs);
        System.out.println("\nUrutkan Berdasarkan Nama (Asc) : ");
        SortUtilities.bubbleSort(barangs);
        printAll(barangs);
        System.out.println("\nUrutkan Berdasarkan Harga (Desc) : ");
        SortUtilities.insertionSort(barangs);
        printAll(barangs);


    }
}
