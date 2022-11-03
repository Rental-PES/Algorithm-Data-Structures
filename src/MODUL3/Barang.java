package MODUL3;

public class Barang {
    private String nama;
    private int harga;
    private int stok;

    Barang(String nama, int harga, int stok){
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public String getHargaFormatted() {
        return "Rp."+harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "Nama : " + getNama() + ", Harga : " + getHargaFormatted() + ", Stok : " + getStok();
    }
}
