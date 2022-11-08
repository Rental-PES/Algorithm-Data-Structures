package MODUL2.NO2;

// memasukkan utility exception untuk error tidak ada elemen
import java.util.NoSuchElementException;
// membuat class stack dengan access modifier public
public class Stack {
    // membuat atribut top dengan tipe data node
    Node top;
    // membuat atribut bottom dengan tipe data node.
    // sebenarnya atribut bottom bisa dihilangkan, karena hanya digunakan untuk mengecek apakah top sama dengan bottom
    // dihilangkan diganti dengan fungsi untuk mengecek apakah setelah top ada node lagi atau tidak
    private Node bottom;
    // atribut size untuk menyimpan nilai dari jumlah data dalam stack
    int size = 0;

    // fungsi untuk memasukkan data kedalam stack
    public void push(char value){
        // membuat variabel node yang berisi Node baru dengan data dari argumen
        var node = new Node(value);
        // mengecek apakah stack masih kosong atau tidak, jika masih, maka akan langsung dimasukkan kedalam stack dan menjadi bottom dan top
        if (top == null) top = bottom = node;
            // jika tidak kosong, maka :
        else{
            // atribut next node baru akan dikaitkan dengan top
            node.next = top;
            // lalu merubah label top ke node baru tadi
            top = node;
        }
        // menambah jumlah nilai dalam atribut size karena ada data baru yang di push/masukkan
        size++;
    }

    // fungsi untuk melihat nilai tanpa harus menghapus ( mengintip )
    public char peek(){
        // mengembalikan nilai atribut value dari top
        return top.value;
    }

    // membuat fungsi pop dengan mengeluarkan nilai dengan tipe data char
    // pop digunakan untuk mengeluarkan data ( menghapus & mengembalikan ). data yang dikeluarkan adalah data paling atas
    public char pop(){
        // jika list nya kosong, berarti tidak ada yg dikembalikan, maka akan memicu error tidak ada element
        if (isEmpty()) throw new NoSuchElementException();
        // menyimpan item yang akan di pop ke dalam popItem
        var popItem = top;
        // jika data tersebut merupakan data terakhir dan pertama, maka stack akan langsung dikosongkan
        if (top == bottom) top = bottom = null;
        else {
            // jika data tersebut bukan data terakhir dan pertama maka
            // data setelah data tersebut akan disimpan di variabel second
            var second = top.next;
            // lalu memutuskan hubungan dari data tersebut ke data selanjutnya
            top.next = null;
            // merubah label top ke second
            top = second;
        }
        // mengurangi size dari array 1
        size--;
        // mengembalikan nilai dari pop yang sudah terhapus. dapat dikembalikan karena sebelumnya kita simpan di popItem terlebih dahulu
        return popItem.value;
    }

    // fungsi untuk mencetak semua data didalam stack
    public  void printAll(){
        // membuat variabel node sebagai pivot atau acuan awal dengan nilai dari atribut top
        // karena pencetakan akan dimulai dari yang teratas
        Node node = top;
        // melakukan infinity loop, tapi akan dihentikan nanti
        while (true){
            // ketika node nya nanti tidak sama dengan null maka
            if(node != null) {
                // nilainya akan di cetak
                System.out.println(node.value);
                // nilai node akan diganti dengan nilai node selanjutnya
                node = node.next;
            }
            // jika node nya sudah null atau sudah data terakhir, maka perulangan dihentikan
            else break;
        }
    }

    // fungsi untuk mengecek apakah stack kosong atau tidak, dengan pengembalian nilai dengan tipe data boolean
    public   boolean isEmpty(){
        // mengembalikan nilai hasil pengecekan apakah top sama dengan null
        return  top == null;
    }


}
