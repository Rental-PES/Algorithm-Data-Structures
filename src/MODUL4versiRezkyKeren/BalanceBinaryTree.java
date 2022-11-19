package MODUL4versiRezkyKeren;

// Membuat kelas balance binary tree yang memiliki public visibility modifier
// Balance Binary Tree merupakan pengembangan dari tree yang sudah ada ( seperti BinaryTree, SortedBinaryTree, dsb)
// Secara konsep balance binary tree merupakan tree yang akan selalu balance di kiri dan di kanannya ( left dan right )
// Oleh karena itu, di method add children saya membuat pengkondisian untuk mengecek keduanya
// Namun karena kebutuhan jurnal, konsep balance ini sedikit saya rubah dengan menambahkan fungsi untuk melakukan penambahan data berdasarkan pencarian
// Namun didalamnya metode penambahannya memakai konsep balance binary tree
public class BalanceBinaryTree {
    // atribut i ini digunakan untuk membantu melakukan numbering ketika melakukan inorder nanti, banyak kali kunjungan akan ditambahkan kesini
    int i = 1;
    // atribut root digunakan untuk menyimpan pucuk/puncak dari tree. yang mana akan digunakan sebagai gerbang akses untuk bagian tree yang ada dibawahnya.
    BinaryTreeNode root = null;
    // saya tidak menggunakan atribut current seperti di binary tree karena algoritma nya banyak menggunakan rekursif
    // sehingga tidak perlu semacam observator untuk mencari dari atas, tapi metode dilakukan dengan penumpukan dan dikerjakan dari bawah.

    // fungsi is empty adalah fungsi untuk mengecek apakah tree ini kosong atau tidak
    public boolean isEmpty(){
        // caranya adalah dengan mengecek puncaknya, tree dianggap kosong apabila puncaknya kosong
        // caranya adalah dengan melakukan perbandingan dengan operator logika equal
        // langsung dilakukan di return untuk mencegah redudansi kode jika dimasukkan kedalam if else terlebih dahulu
        return root == null;
    }

    // fungsi ini merupakan fungsi pemanggil untuk fungsi findnode
    // fungsi ini digunakan untuk simplifikasi pemanggilan rekursif
    // makanya, parameter yang diperlukan hanya string key yang merupakan target pencarian
    public  BinaryTreeNode doFindNode(String key){
        // variabel pivot digunakan sebagai awalan karena mengacu pada root
        BinaryTreeNode pivot = root;
        // selanjutnya fungsi ini akan memanggil fungsi lain yaitu find node dengan memasukkan pivot dan key sebagai param
        // lalu mengembalikan hasil
        return findNode(pivot, key);
    }

    // fungsi yang saya sebut (worker) dari fungsi pemanggilan tadi
    // disini proses pencarian dilakukan dengan serangkaian tahap rekursif
    private BinaryTreeNode findNode(BinaryTreeNode node, String key) {
        // baris dibawah merupakan pembatas untuk rekursif, dengan mengembalikan nilai null
        if (node == null) return null;
        // baris dibawah merupakan pembatas untuk rekursif jika menemukan data yang dicari, dan langsung mengembalikannya
        if (node.data == key) return node;
        // variabel res 1 digunakan sebagai penyimpan rekursif
        BinaryTreeNode res1 = findNode(node.left, key);
        // hasil rekursif di cek lagi, dan jika memenuhi ketentuan maka akan dikembalikan
        if (res1 != null && res1.data.equals(key)) return res1;
        // karena merupakan rekursif, dibagian return juga akan melakukan pengembalian fungsi lagi
        return findNode(node.right, key);
    }

    // fungsi yang digunakan untuk menginisiasi tree pertama kali
    public void  init(String data){
        if (isEmpty()){
            // dengan melakukan pengisian root dengan data jika treenya tidak kosong
            root  = new BinaryTreeNode(data);
            System.out.println("Daus dibuat sebagai Root");
        } else {
            // jika tree tidak kosong, maka akan ditampilkan pesan error
            System.out.println("Error Tree Sudah Dibuat");
        }
    }

    // ini merupakan fungsi utamanya
    // fungsi untuk menambahkan children dari tree yang sudah di buat dan di inisiasi
    // seperti yang saya jelaskan di atas, fungsi ini mengalami sedikit modifikasi dengan menggunakan acuan untuk parentnya
    // oleh karena itu, terdapat 2 parameter yaitu target parent dan data
    public void addChildren(String targetParent,String data){
        // dilakukan pencarian node parent sesuai dengan argumen target parent
        BinaryTreeNode resTarget = doFindNode(targetParent);
        // jika ditemukan ( tidak null )
        if (resTarget != null) {
            // akan di cek lagi apakah kirinya null atau tidak ( penjelasan : konsep balance )
            if (resTarget.left == null){
                resTarget.left = new BinaryTreeNode(data, resTarget.level+1, resTarget);
                System.out.println(data + " Ditambahkan Sebagai Left Dari " + targetParent);
            }
            // akan di cek lagi apakah kanannya null atau tidak ( penjelasan : konsep balance )
            else if (resTarget.right == null){
                resTarget.right = new BinaryTreeNode(data, resTarget.level+1, resTarget);
                System.out.println(data + " Ditambahkan Sebagai Right Dari " + targetParent);
            }
            // jika kiri dan kanan sudah terisi, maka akan di tampilkan peringatan
            else {
                System.out.println("Warning : Child dari Node Sudah Terisi");
            }
            // memberhentikan fungsi agar tidak mengeksekusi baris dibawahnya lagi yang akan digunakan untuk menampilkan pesan error
            return;
        }
        // menampilkan pesan error jika target parent tidak ditemukan
        System.out.println("Error : Tidak Dapat Menemukan Parent");
    }


    // Utilitas Relasi
    // di sini merupakan kumpulan fungsi untuk mengecek relasi antara 2 target yang menjadi parameter
    public void checkRelationship(String target1, String target2){
        // hal pertama yang dilakukan adalah mencari node dengan target tersebut didalam tree lalu menyimpannya dalam variabel
        BinaryTreeNode node1 = doFindNode(target1);
        BinaryTreeNode node2 = doFindNode(target2);
        // lalu dilakukan serangkaian proses pengecekan dengan fungsi yang telah dibuat dan akan dijelaskan dibawah
        isAnak(node1, node2);
        isCucu(node1, node2);
        isCucuJauh(node1, node2);
        isCicit(node1, node2);
        isKeponakan(node1, node2);
        isKeponakanJauh(node1, node2);
        isSaudara(node1, node2);
        isSaudaraJauh(node1, node2);
    }

    // fungsi isAnak adalah untuk mengecek apakah  mereka memiliki hubungan anak
    private void isAnak(BinaryTreeNode node1, BinaryTreeNode node2){
        try {
            // cara kerjanya adalah dengan mengecek apakah parent dari node 1 sama dengan node 2 ( beda 1 tingkat == anak )
            if (node1.parent.data == node2.data) {
                System.out.println(node1.data + " Merupakan Anak Dari " + node2.data);
            }
        } catch (Exception ignored){};
    }

    // fungsi isCucu adalah untuk mengecek apakah  mereka memiliki hubungan cucu
    private void isCucu(BinaryTreeNode node1, BinaryTreeNode node2){
        try {
            // cara kerjanya adalah mengecek apakah parent dari parent ( kakek/nenek ) dari node 1 sama dnegan data node 2 ( beda 2 tingkat == cucu )
            if (node1.parent.parent.data == node2.data) {
                System.out.println(node1.data + " Merupakan Cucu Dari " + node2.data);
            }
        } catch (Exception ignored){};
    }

    // fungsi isCucuJauh adalah untuk mengecek apakah  mereka memiliki hubungan cucu jauh
    private void isCucuJauh(BinaryTreeNode node1, BinaryTreeNode node2){
        try {

            // cara kerjanya adalah mengecek perbedaan level terlebih dahulu, syarat hubungan cucu adalah beda 2 level.
            // lalu untuk menentukan apakah dia cucu jauh adalah dengan
            // mengecek apakah parent dari parent ( kakek/nenek ) dari node 1 tidak sama dnegan data node 2 ( beda 2 tingkat == cucu )
            if (((node1.level - node2.level) == 2) &&(node1.parent.parent.data != node2.data)) {
                System.out.println(node1.data + " Merupakan Cucu Jauh Dari " + node2.data);
            }
        } catch (Exception ignored){};
    }

    // fungsi isCicit adalah untuk mengecek apakah  mereka memiliki hubungan cicit
    private void isCicit(BinaryTreeNode node1, BinaryTreeNode node2){
        try {
            // cara kerjanya adalah mengecek apakah parent dari parent parent  dari node 1 sama dnegan data node 2 ( beda 3 tingkat == cicit )
            if (node1.parent.parent.parent.data == node2.data) {
                System.out.println(node1.data + " Merupakan Cicit Dari " + node2.data);
            }
        } catch (Exception ignored){};
    }

    // fungsi isKeponakan adalah untuk mengecek apakah  mereka memiliki hubungan keponakan
    private void isKeponakan(BinaryTreeNode node1, BinaryTreeNode node2){
        try {
            // cara mengeceknya adalah dengan membandingkan kakek dari node1 dengan ortu dari node 2, jika sama merupakan keponakan
            if (node1.parent.parent.data == node2.parent.data) {
                System.out.println(node1.data + " Merupakan Keponakan Dari " + node2.data);
            }
        } catch (Exception ignored){};
    }

    // fungsi isKeponakanJauh adalah untuk mengecek apakah  mereka memiliki hubungan keponakan jauh
    private void isKeponakanJauh(BinaryTreeNode node1, BinaryTreeNode node2){
        try {
            // cara mengeceknya adalah dengan membandingkan kakek dari node1 dengan ortu dari node 2 jika tidak sama merupakan keponakan jauh
            // dan membandingkan selisih level apakah sama dengan 1.
            if (((node1.level - node2.level) == 1) && (node1.parent.data != node2.data)) {
                System.out.println(node1.data + " Merupakan Keponakan Jauh Dari " + node2.data);
            }
        } catch (Exception ignored){};
    }

    // fungsi isSaudara adalah untuk mengecek apakah  mereka memiliki hubungan Saudara
    private void isSaudara(BinaryTreeNode node1, BinaryTreeNode node2){
        try {
            // jika saudara, sudah pasti parent dan levelnya sama
            if ((node2.level == node1.level) && (node1.parent.data == node2.parent.data)) {
                System.out.println(node1.data + " Merupakan Saudara Dari " + node2.data);
            }
        } catch (Exception ignored){};
    }

    // fungsi isSaudaraJauh adalah untuk mengecek apakah  mereka memiliki hubungan SaudaraJauh
    private void isSaudaraJauh(BinaryTreeNode node1, BinaryTreeNode node2){
        try {
            // jika saudara jauh, sudah pasti parent nya berbeda dan tapi levelnya sama
            if ((node2.level == node1.level) && (node1.parent.data != node2.parent.data)) {
                System.out.println(node1.data + " Merupakan Saudara Jauh Dari " + node2.data);
            }
        } catch (Exception ignored){};
    }

    // Utilitas Pencetak
    // Disini merupakan kumpulan fungsi yang digunakan untuk mencetak isi tree

    // salah satunya adalah dengan cara inorder
    // fungsi dibawah merupakan fungsi untuk melakukan pemanggilan terhadap fungsi rekursif yang bertugas sebagai worker
    // alasan dibaginya sama seperti fungsi fungsi di atas tadi.
    public void  doInorder(){
        // menggunakan binaryTreeNode variabel dengan isi root sebagai acuan awal rekursif
        BinaryTreeNode binaryTreeNode = root;
        // memanggil fungsi worker
        printInorder(binaryTreeNode);
    }

    // fungsi worker untuk melakukan printInorder dengan cara rekursif
    private void printInorder(BinaryTreeNode node){
        //  mengecek apakah node yang dimasukkan null atau tidak, kalau tidak null maka baris didalamnya akan di eksekusi
        // setiap rekursif wajib memiliki penghentian, pengkondisian ini merupakan pemberhentian untuk rekursif ini dengan konisi
        // jika node nya null maka dianggap berakhir
        if (node != null) {
            // inorder secara konsep melakukan pencetakan dari kiri ke kanan, oleh akrena itu node.left dipanggil duluan
            printInorder(node.left);
            // lalu ditampilkan hasilnya
            // ada pemanggilan getchildren yang merupakan fungsi untuk mengecek child dari node tersebut
            System.out.println(i++ + ". " + node.data + " : " + getChildren(node));
            // lalu lanjut ke kanan
            printInorder(node.right);
        }
    }

    // fungsi get children, digunakan untuk mencari anak dari sebuah node dengan membaca left dan right nya
    String getChildren(BinaryTreeNode node){
        if(node.left != null && node.right != null){
            // jika memiliki anak, nilai anaknya akan digabung menjadi string yang dipisahkan dengan &
            return node.left.data  + " & " + node.right.data;
        }
        // jika tidak, yang dikembalikan adala strip yang berarti kosong
        return  "-";
    }




}
