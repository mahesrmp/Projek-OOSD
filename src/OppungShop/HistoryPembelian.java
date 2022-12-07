package OppungShop;

import java.util.ArrayList;

public class HistoryPembelian {
    String namaPembeli;
    String namaProduk;
    int jumlah;
    String tanggalPembelian;


    public HistoryPembelian(){
    }
    public HistoryPembelian(String namaPembeli,String namaProduk, int jumlah,String tanggalPembelian) {
        this.namaProduk = namaProduk;
        this.jumlah = jumlah;
        this.tanggalPembelian = tanggalPembelian;
        this.namaPembeli = namaPembeli;

    }

    ArrayList<HistoryPembelian> catatan = new ArrayList<HistoryPembelian>();

    public void catat(String namaPembeli,String namaProduk, int jumlah,String tanggalPembelian){
        catatan.add(new HistoryPembelian(namaPembeli,namaProduk,jumlah,tanggalPembelian));
    }

    public void tampilSemuaCatatan(){
        int i=0;
        System.out.println("\nHistory Pembelian :");
        for(HistoryPembelian x : catatan){
            System.out.println((i+1)+". Nama Pembeli : " + x.namaPembeli + "| Nama Produk : " + x.namaProduk + "| Jumlah : " + x.jumlah + "| Tanggal Pembelian " + x.tanggalPembelian);
            i++;
        }

        if(i==0){
            System.out.println("Belum Ada Pembelian Apapun\n");
        }
    }
    public void tampilCatatanPembeli(String namaPembeli){
        int i = 0;
        System.out.println("History Pembelian Anda");
        for(HistoryPembelian x : catatan){
            if(x.namaPembeli.equals(namaPembeli)){
                System.out.println((i+1)+". Nama Pembeli : " + x.namaPembeli + "| Nama Produk : " + x.namaProduk + "| Jumlah : " + x.jumlah + "| Tanggal Pembelian " + x.tanggalPembelian);
                i++;
            }
        }
        if(i==0){
            System.out.println("Anda Belum Melakukan Pembelian Apapun\n");
        }
    }
}
