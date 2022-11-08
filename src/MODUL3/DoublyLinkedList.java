package MODUL3;

// Membuat class DoublyLinkedList
public class DoublyLinkedList{
    // Dengan atribut head dan tail dengan tipe data Node
    Node head;
    Node tail;

    // Membuat variabel size untuk menampung banyak elemen
    int size = 0;

    // Membuat fungsi untuk melakukan merge sort dengan memanggil fungsi dari SortUtilities dan inner class nya
    void doMergeSort(){
        head = SortUtilities.MergeSort.doMergeSort(head);
    }

    // Membuat fungsi untuk melakukan insertion sort dengan memanggil fungsi dari SortUtilities dan inner class nya
    void doInsertionSort(){
        head = SortUtilities.InsertionSort.doInsertionSort(head);
    }

    // Membuat fungsi untuk melakukan bubble sort dengan memanggil fungsi dari SortUtilities dan inner class nya
    void doBubbleSort(){
        head = SortUtilities.BubbleSort.doBubbleSort(head);
    }

    // Fungsi untuk mendapatkan node dengan index sebagai patokan
    // n merupakan index yang dicari
    public Node getNode(int n){
        // membuat variabel current untuk patokan perulangan
        Node current = head;
        // melakukan perulangan sebanyak size dari list
        for (int i=0;i<size;i++){
            // jika ketemu index yang sama maka perulangan diberhentikan
            if (i==n){
                break;
            }else{
                // jika tidak, perulangan akan terus berlanjut dan berpindah ke data selanjutnya
                current=current.next;
            }
        }
        // mengembalikan nilai current yang berubah, karena ketemu/tidak
        return current;
    }

    // fungsi untuk menambahkan elemen baru (barang) dalam list menggunakan node sebagai container
    // node akan ditambahkan di akhir list karena addLast
    public void  addLast(Barang value){
        // membuat node baru dari nilai barang
        Node newNode = new Node(value);
        // jika list masih kosong, maka akan langsung menjadi yang pertama dan terakhir
        if (isEmpty()) head = tail= newNode;
        // jika tidak, maka
        else {
            // mengaitkan atribut prev node baru ke tail
            newNode.prev = tail;
            // mengaitkan atribut next dari tail ke node baru
            tail.next = newNode;
            // merubah label tail ke node baru
            tail = newNode;
        }
        // karena ada penambahan elemen, maka size juga harus ditambah
        size+=1;
    }

    // fungsi untuk mengecek apakah list kosong atau tidak
    private boolean isEmpty(){
        // caranya adalah dengan melakukan pengecekan boolean untuk head apakah kosong atau tidak
        // nilai dari boolean tersebut yang akan dikembalikan
        return (head == null);
    }

    // Fungsi untuk menampilkan semua elemen didalam list
    void printAll(){
        // variabel node digunakan untuk basis dan bernilai head karena mulai dari awal
        Node node = head;
        // melakukan infinity loop namun akan diberhentikan nanti
        while (true){
            // jika node belum null maka
            if(node != null) {
                // nilai barang dari node akan dicetak ke layar
                System.out.println(node.barang);
                // data node akan diganti ke data berikutnya
                node = node.next;
            }
            // jika node sama dengan null maka loop berhenti
            else break;
        }
    }



//  Fungsi untuk search, tidak dibuatkan package terpisah ( agar rapi ) karena takut kehabisan waktu

    // Membuat fungsi untuk mencari value di dalam sebuah list dengan metode sequentialSearch
    //metode sequential merupakan salah satu metode dalam pencarian data dalam sebuah list
    //data akan dicari dan dibandingkan satu persatu mulai dari head sampai tail(depan sampai akhir)
    //pada metode ini data bisa saja diurutkan terlebih dahulu bisa juga tidak
    //sequentialSearch menggunakan parameter berupa variabel param dengan tipe data string
    //fungsi nya agar nanti saat di gunakan dalam main, maka method dapat di isi data berupa string
    public void sequentialSearch(String param){
        // membuat variabel yang berfungsi sebagai pointer yang merujuk pada data pertama atau head
        //fungsinya agar nanti yang akan melakukan proses pemindahan adalah current dan head tetap di tempat
        Node current = head;
        // membuat variabel status untuk menentukan apakah nilai yang dicari ditemukan
        boolean status = false;
            //statement perulangan for berguna untuk melakukan perulangan dengan batasan berupa ukuran dari data linkedlist
            for (int i=0;i<size;i++){
                // baris ini berfungsi untuk mengecek apakah data yg akan dicari ada didalam list bagian mana, karena pada list
                // ada data dibagian head, tail dan diantara nya
                if (current.barang.getNama().equals(param)){
                    System.out.println("===Barang Ditemukan===");
                    System.out.println("Nama:\t"+ param);
                    System.out.print("Letak: ");
                    // ketika value yang ditemukan berada di head maka cukup mencetak data yang ditemukan setelahnya
                    //menggunakan variabel current sebagai penunjuk next
                    if (current.barang.getNama()==head.barang.getNama()){
                        System.out.println("Sebelum "+current.next.barang.getNama());
                    }
                    // ketika value yang ditemukan berada di tail maka cukup mencetak data yang ditemukan sebelumnya
                    // menggunakan variabel current sebagai penunjuk previous
                    else if(current.barang.getNama()==tail.barang.getNama()){
                        System.out.println("Setelah "+current.prev.barang.getNama());
                    }
                    // mencetak value nama  sebelum dan sesudah ditemukan dengan
                    // menggunakan variabel current sebagai penunjuk next dan previous
                    else{
                        System.out.println("\tSebelum "+current.next.barang.getNama());
                        System.out.println("\t\tSetelah "+current.prev.barang.getNama());
                    }
                    // jika masuk ke kondisi ini artinya ditemukan maka status akan berubah menjadi true
                    status = true;
                    // karena ditemukan, perulangan akan berhenti
                    break;
                }
                // jika tidak ditemukan
                else{
                    // datanya akan terus berganti ke data selanjutnya
                    current = current.next;
                }
            }
            // jika sampai akhir statusnya masih false, maka dianggap data tidak ditemukan
            // menampilkan peringatan data tidak ditemukan
            if (status == false) System.out.println("Barang Tidak Ditemukan");

    }

    // metode pencarian binary merupakan metode yang bekerja dengan cara membagi list menjadi 2 bagian untuk mempermudah pencarian data
    //dan list akan semakin dibagi jika masih belum ditemukan datanya sampai tersisa satu bagian data
    //metode ini memerlukan data yang telah diurutkan terlebih dahulu
    //pada method ini parameter yang digunakan cuman satu yaitu variabel key dengan tipe data string
    //yang fungsinya agar pada saat dipanggil di main, method ini dapat menginput data
    public void searchBinary(String key) {
        // menyimpan nilai kembalian dari fungsi binary method dengan parameter data awal atau indeks 0
        // kemudian banyak data atau size dan string kata kunci
        int found = binaryMethod(0, size, key);
        // jika ditemukan/ found lebih dari 0
        if (found >= 0) {
            //sytem.out.println berfungsi untuk menampilkan data pada jendela layar
            //pada baris ini yang akan ditampilkan berupa nama data dan posisi data sebelum dan sesudah
            System.out.println("===== Barang Ditemukan ====");
            System.out.println("Nama Barang : " + getNode(found).barang.getNama());
            System.out.print("Letak : ");
            // dengan kondisi jika found == 0 maka hanya perlu mencetak data setelah node kata kunci
            // data yang akan ditampilkan cukup sebelum barang
            if (found == 0) System.out.println("Sebelum barang " + getNode(found + 1).barang.getNama());
            // jika found sama dengan indeks data terakhir maka perlu mencetak data sebelum node kata kunci
            // data yang akan ditampilkan yaitu setelah barang
            else if (found == size - 1) System.out.println("Setelah barang " + getNode(found - 1).barang.getNama());
            // jika kondisi diatas tidak terpenuhi maka perlu mencetak data sebelum dan sesudah kata kunci
            else {
                System.out.println("Sebelum barang " + getNode(found + 1).barang.getNama());
                System.out.println("\t\tSetelah barang " + getNode(found - 1).barang.getNama());
            }
            // return akan mengembalikan nilai dan keluar dari method
            return;
        }
        // jika data found kurang dari 0 maka data tidak ditemukan dan akan menampilkan kata dibawah ini pada
        //jendela tampilan
        System.out.println("===== Barang Tidak Ditemukan ====");
    }

    // membuat fungsi yang menerapkan metode binary dengan tipe data integer
    // dengan parameter nilai awal,niali akhir dan string kata kunci
    //method ini berfungsi untuk menentukan nilai tengah, nilai awal, dan akhir
    //yang nanti nya akan digunakan dalam method searchBinary
    private int binaryMethod(int low, int high, String key) {
        // membuat kondisi apakah nilai akhir lebih dari sama dengan nilai awal
        if (high >= low) {
            // melakukan perhitungan untuk menentukan nilai tengah
            int mid = low + (high - low) / 2;
            // membuat kondisi untuk memeriksa apakah node tengah tersebut sama dengan parameter kata kunci
            //mengembalikan nilai tengah
            if (key.equalsIgnoreCase(getNode(mid).barang.getNama())) return mid;
            // membuat kondisi untuk membandingkan dua buah string apakah banyak karakter dari string karakter kata kunci
            // dan banyak karakter dari node mid.nama kurang dari 0
            // jika iya maka melakukan rekursif dengan mid dikurangi 1 atau melakukan pengecekan data sebelum mid
            if (key.compareToIgnoreCase(getNode(mid).barang.getNama()) < 0) return binaryMethod(low, mid - 1, key);
            // melakukan rekursif untuk mengecek data setelah mid
            return binaryMethod(mid + 1, high, key);
        }
        // ketika data tidak ditemukan maka nilai kembalian dari fungsi ini sama dengan -1
        return -1;
    }




}
