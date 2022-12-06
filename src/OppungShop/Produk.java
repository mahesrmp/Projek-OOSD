package OppungShop;

import java.util.ArrayList;

public class Produk {
        String namaProduk;
        JenisProduk jenis;
        int harga,stok;
        public Produk(){}
        public Produk(String namaProduk,JenisProduk jenis, int harga, int stok) {
            this.namaProduk = namaProduk;
            this.jenis = jenis;
            this.harga = harga;

            this.stok = stok;
        }

        ArrayList<Produk> daftar = new ArrayList<Produk>();

        public void tambahProduk(String namaProduk,JenisProduk jenis, int harga, int stok){
            daftar.add(new Produk(namaProduk,jenis,harga,stok));
        }

        public void lihatSemuaProduk(){
            int i = 0;
            System.out.println("Daftar Menu :");
            for(Produk x : daftar){

                System.out.println((i+1) + ". Nama Menu   : " + x.namaProduk + "\n   Jenis Menu  : " + x.jenis+ " \n   Harga       : " + x.harga + " \n   Stok        : " + x.stok);
                i++;
            }
            if(i == 0){
                System.out.println("Belum ada menu yang di Input");
            }

            System.out.println("======================================");
        }

        public void cariNamaProduk(String namaProduk){
            int i = 0;
            System.out.println("Hasil Pencarian Menu :");
            for(Produk x : daftar){

                if(x.namaProduk.equals(namaProduk)){
                    System.out.println((i+1) + " Nama menu : " + x.namaProduk + "  Harga : " + x.harga + "  Stok : " + x.stok);
                    i++;
                }
            }
            if(i == 0){
                System.out.println("Menu dengan nama " + namaProduk + " Tidak Ditemukan");
            }
            System.out.println(i + " Hasil Pencarian");
            System.out.println("======================================");
        }
        public Produk cariNamaProduk(String namaProduk,int index){
            int i = 0;
            for(Produk x : daftar){
                if(x.namaProduk.equals(namaProduk)){
                    i++;
                }
            }
            return daftar.get(i-1);


        }
        public void hapusProduk(String namaProduk){
            int i = 0;
            for(Produk x : daftar){
                if(x.namaProduk.equals(namaProduk)){
                    daftar.remove(i);
                    System.out.println("Produk dengan nama " + namaProduk +" berhasil dihapus");

                    i++;
                    break;
                }

            }
            if(i==0){
                System.out.println("Produk dengan nama " + namaProduk + "Tidak dapat ditemukan");
            }


        }

        public void jualProduk(String namaProduk,int jumlahProduk){
            int i = 0;
            for(Produk x: daftar){
                if(x.namaProduk.equals(namaProduk)){
                    x.stok = x.stok - jumlahProduk;
                    i++;
                }
            }
            if(i==0){
                System.out.println("tidak ada Menu");
            }
        }
    }

