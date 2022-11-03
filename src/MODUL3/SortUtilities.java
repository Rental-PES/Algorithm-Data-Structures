package MODUL3;

public class SortUtilities {
    static void bubbleSort(Barang arr[]){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j].getNama().toCharArray()[0] > arr[j + 1].getNama().toCharArray()[0]) {
                    Barang temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    static  void insertionSort(Barang arr[]){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Barang pivot = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].getHarga() < pivot.getHarga()) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = pivot;
        }
    }


}
