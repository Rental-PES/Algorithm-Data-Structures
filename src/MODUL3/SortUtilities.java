package MODUL3;

// Membuat class dengan nama SortUtilities
public class SortUtilities  {
    // membuat inner class MergeSort dari parent class SortUtilities
    // ini dilakukan agar lebih rapi dalam pembagian struktur kode
    static  public  class  MergeSort{
        // Secara konsep, merge sort adalah metode sorting yang membagi elemen dalam list kedalam kelompok kelompok pasangan
        // fungsi ini digunakan untuk melakukan hal tersebut
        // Head akan tetap digunakan sebagai acuan
        static Node split(Node head) {
            // Karena berpasangan, nodenya akan dibagi menjadi 2, yaitu kanan dan kiri ( right left )
            Node left = head, right = head;
            // Perulangan akan dilakukan sampai tidak ada elemen tersisa
            while (left.next != null && left.next.next != null) {
                // proses dibawah adalah untuk memasukkan nilai untuk pasangan tersebut
                // nilai untuk kiri
                left = left.next.next;
                // nilai untuk kanan
                right = right.next;
            }
            // Memasukkan nilai righ.next kedalam temp ( biasanya ini adalah sisa jika nilainya belum habis )
            Node temp = right.next;
            // menghapus nilai sisa tadi
            right.next = null;
            // mengembalikan nilai sisa
            return temp;
        }



        // Metode merge sort dimulai dengan membaginya menjadi kelompok kelompok
        // setelah itu mereka akan diurutkan dan disatukan kembali
        // proses penyatuan tersebut adalah merge, yang memerlukan 2 list atau kelompok yang akan digabung (first, second)
        // berikut merupakan fungsinya :
        static Node merge(Node first, Node second) {
            // Ketika first nya sudah kosong maka akan mengembalikan yang kedua ( second )
            if (first == null) return second;

            // Ketika second nya sudah kosong maka akan mengembalikan yang pertama ( first )
            if (second == null) return first;

            // Disini akan dilakukan proses pemilihan nilai yang lebih kecil
            // jika yang ada di first lebih kecil daripada yang ada di second ( mirip konsep kiri, kanan)
            if (first.barang.getStok() < second.barang.getStok()) {
                // maka nilai dari atribut first adalah hasil merge dari first.next dan second
                // metode ini menggunakan konsep stack, yaitu memanggil dirinya sendiri terus menerus,
                // dan akan diberhentikan jika masuk kedalam kondisi di atas tadi ( yang first == null atau second == null )
                first.next = merge(first.next, second);
                // first next.prev akan dikaitkan ke first ( nilai yang sudah terurut sebelumnya
                first.next.prev = first;
                // first.prev akan jadi null karena dia merupakan nilai pertama, atribut prev nya tidak akan dikaitkan
                first.prev = null;
                // mengembalikan nilai first
                return first;
            }

            // jika yang ada di first tidak lebih kecil (lebih besar) daripada yang ada di second ( mirip konsep kiri, kanan)
            else {
                // maka nilai dari atribut seconf adalah hasil merge dari first dan second.next
                // metode ini menggunakan konsep stack, yaitu memanggil dirinya sendiri terus menerus,
                // dan akan diberhentikan jika masuk kedalam kondisi di atas tadi ( yang first == null atau second == null )
                second.next = merge(first, second.next);
                // second.next.prev akan dikaitkan ke second ( nilai yang sudah terurut sebelumnya )
                second.next.prev = second;
                // second.prev akan jadi null karena dia merupakan nilai pertama, atribut prev nya tidak akan dikaitkan
                second.prev = null;
                // mengembalikan nilai second
                return second;
            }
        }


        // Berikut merupakan fungsi utamanya
        // karena merge sort terdiri dari proses pengelompokan (split) dan penggabungan&pengurutan(merge)
        // maka diperlukan fungsi 1 lagi untuk melakukan keduanya
        // parameter node akan digunakan untuk acuan
        static Node mergeSort(Node node) {
            // ketika list nya kosong maka akan langsung mengembalikan node
            if (node == null || node.next == null) {
                return node;
            }
            // jika tidak akan lanjut :
            // membuat variavel second yang berisi hasil pembagian node
            Node second = split(node);

            // melakukan rekursif untuk sorting kedua sisi ( node dan second )
            node = mergeSort(node);
            second = mergeSort(second);

            // menggabungkan keduanya lalu mengembalikan hasilnya
            return merge(node, second);
        }

        // fungsi ini digunakan untuk melakukan perubahan terhadap list saja ( perombakan )
        // dengan memanggil fungsi fungsi sebelumnya
        // menggunakan parameter head sebagai acuan list yang akan dirombak
        static Node doMergeSort(Node head){
            // merombak head
            head = mergeSort(head);
            // mengembalikan nilai head
            return head;
        }

    }


    // membuat inner class InsertionSort dari parent class SortUtilities
    // ini dilakukan agar lebih rapi dalam pembagian struktur kode
    static public class InsertionSort{
        // insertion sort secara konsep adalah cara mengurutkan yang didasari dari memasukkan nilai secara terurut.
        // fungsi dibawah ini adalah untuk melakukan hal tersebut.
        // head sebagai parameter akan digunakan sebagai acuan dari operasi ini
        // newNode adalah node baru yang dimasukkan ( hasil rombakan dari list sebelumnya yang ingin di sort )
        static Node sortedInsert(Node head, Node newNode){
            // Membuat variabel current ber tipe data node
            Node current;
            // Melakukan pengecekan apakah list nya kosong, jika kosong akan langsung dimasukkan di awal
            if (head == null) head = newNode;

            // Kondisi selanjutnya dalah jika tidak kosong dan harga barang yang dimasukkan lebih dari harga barang yang ada di head/awal
            // Maka new node akan dimasukkan di awal
            else if ((head).barang.getHarga() <= newNode.barang.getHarga()) {
                // melakukan operasi addFirst
                // next dari newNode akan ditautkan pointernya ke head
                newNode.next = head;
                // sedangkan head ( newNode.next ) pointer prev nya akan ditautkan ke newNode
                newNode.next.prev = newNode;
                // label head dipindahkan ke newNode
                head = newNode;
            }
            // Jika tidak dimasukkan di awal maka :
            else {
                // akan melakukan perulangan.
                // current dengan nilai head akan digunakan untuk basis perulangan.
                current = head;

                // Mencari node (current) yang  nilai barangnya lebih besar dari nilai barang newNode
                // menggunakan looping yang akan berhenti jika syarat tersebut terpenuhi
                while (current.next != null && current.next.barang.getHarga() > newNode.barang.getHarga())
                    current = current.next;


                // lalu memasukkan nilainya (newNode) di setelah nilai besar tersebut
                // perlu diingat, hal ini dilakukan karena tujuannya adalah untuk desc sorting.

                // Pertama-tama yang dilakukannya adalah menyisipkannya, dengan cara menautkan newNode ke node setelah current
                // agar berada di tengah tengah.
                newNode.next = current.next;
                // Kika newNode tidak dimasukkan di akhir list maka:
                if (current.next != null)
                    // menautkan atribut prev node setelah current tadi yang telah ditautkan ke newNode ( oleh operasi tadi )
                    newNode.next.prev = newNode;

                // mengaitkan current next ke newNode
                current.next = newNode;
                // mengaitkan newNode prev ke current
                newNode.prev = current;
            }
            // mengembalikan node head sebagai acuan list baru
            return head;
        }

        // Kalau tadi kita membuat fungsi memasukkan nilai sevara urut saja,
        // ini merupakan fungsi utama yang akan bertugas merombak list yang sudah ada
        // caranya adalah dengan memanfaatkan head dari list tersebut yang dijadikan argumen untuk parameter head
        static Node doInsertionSort(Node head) {
            // Membuat variabel sorted untuk menampung basis dari list yang terurut
            Node sorted = null;

            // Membuat variabel current dengan nilai head untuk awalan perulangan
            Node current = head;
            // Perulangan dilakukan sebanyak elemen dalam list ( sleama current tidak kosong/null )
            while (current != null){

                // Menyimpan next dari current terlebih dahulu
                Node next = current.next;

                // menghapus semua kaitan dari current.
                // karena akan dijadikan node baru untuk dimasukkan
                // *ingat ini dilakukan untuk perombakan list yan akan diisi kembali dengan elemen sebelumnya*
                current.prev = current.next = null;

                // memasukkan nilai current kedalam fungsi memasukkan urut tadi sebagai argumen
                // setiap kali sortedInsert dipanggil, nilai sorted atau basis variabel untuk menampung nilai yang terurut akan berubah
                sorted=sortedInsert(sorted, current);

                // melanjutkan ke node selanjutnya dalam list ( alasan kenapa kita menyimpannya dalam next )
                current = next;
            }

            // Mengupdate label head nilainya jadi nilai sorted yang terurut
            head = sorted;
            // Mengembalikan nilai head sebagai acuan awal dari list.
            return  head;

        }
    }

    // membuat inner class BubbleSort dari parent class SortUtilities
    // ini dilakukan agar lebih rapi dalam pembagian struktur kode
    static public class BubbleSort{
        static  Node  doBubbleSort(Node head){
            // mendeklarasikan variabel swap untuk menghitung berapa kali aksi swap dilakukan
            // nantinya akan digunakan untuk mengecek apakah sudah terurut atau belum
            // jika sudah terurut, artinya swap == 0
            int swapped;
            // melakukan perulangan pertama
            // di bubble sort terdapat 2 perulangan
            // perulangan pertama adalah untuk melakukan perulangan sampai tidak ditemukan adanya swap
            // swap dilakukan di perulangan kedua
            do{
                // swap di setiap perulangan akan di atur menjadi 0
                swapped = 0;
                // perulangan akan dilakukan dari paling awal atau head,
                // oleh karena itu current akan dimulai dari head
                Node current = head;
                // ini merupakan perulangan kedua tadi
                // perulangan kedua dilakukan di seluruh item list sampai tidak ada lagi item
                // oleh karena itu kondisinya adalah current.next tidak null
                while (current.next != null){
                    // disini perbandingan dilakukan
                    // dilakukan pengecekan apakah nilai nama saat ini pada karakter pertama secara ascii lebih besar dari nilai selanjutnya atau tidak
                    if (current.barang.getNama().toCharArray()[0] > current.next.barang.getNama().toCharArray()[0]) {
                        // jika lebih besar, maka akan dilakukan pergeseran current
                        // current akan disimpan terlebih dahulu karena akan digunakan nanti
                        // perlu disimpan karena label current akan berpindah
                        Barang t = current.barang;
                        // current akan diganti nilainya dengan nilai selanjutnya.
                        // artinya memindahkan nilai selanjutnya ke kiri ( karena lebih kecil )
                        current.barang = current.next.barang;
                        // lalu current yang tadi disimpan dalam t akan dipindahkan ke kanan ( karena lebih besar )
                        // kanan disini artinya next dari current yang tadi di kiri.
                        current.next.barang = t;
                        // karena terjadi swap, maka nilai swap berubah.
                        swapped = 1;
                    }
                    // melakukan pergantian posisi mulai karena posisi yang tadi telah dilakukan pengecekan.
                    current = current.next;
                }
            }
            // disini menggunakan do while loop, jadi kode di atas akan dilakukan sekali sebelum mengecek kondisinya
            // kondisi pemberhentiannya adalah ketika tidak ada lagi swap
            while (swapped != 0);
            // karena dianggap tidak ada lagi swap ( sudah urut ), patokan awal atau head akan dikembalikan.
            return head;
        }

    }



}
