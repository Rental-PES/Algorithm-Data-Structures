package MODUL3;

// membuat class barang untuk menampung data barang
public class Barang {
    // atribut nama bertipe data string
    private String nama;
    // atribut harga dan stok bertipe data integer
    private int harga;
    private int stok;

    // membuat constructor dimana ketiga atribut tersebut harus sudah diisi jika membuat objek baru
    Barang(String nama, int harga, int stok){
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    };

    // karena ketiga atribut di atas private maka dibuatkan getter setternya
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }


    public int getHarga() {
        return harga;
    }


    public void setHarga(int harga) {
        this.harga = harga;
    }


    // membuat versi lain dari getter harga, yaitu dengan kembalian string karena diperlukan format rupiah
    public String getHargaFormatted() {
        return "Rp."+harga;
    }

    // merubah/override fungsi toString yang sebelumnya menampilkan alamat data, menjadi mencetak nilai data
    @Override
    public String toString() {
        return "Nama : " + getNama() + ", Harga : " + getHargaFormatted() + ", Stok : " + getStok();
    }
}
