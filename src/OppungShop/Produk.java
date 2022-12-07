package OppungShop;

import java.util.ArrayList;
import java.util.Scanner;

public class Produk {
        String namaProduk;
        JenisProduk jenis;
        int harga,stok;

        Scanner input = new Scanner(System.in).useDelimiter("\n");
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
            int i;
            System.out.println("Daftar Menu :");
            for(i = 0; i <daftar.size(); i++){
                System.out.println((i+1) + ". Nama Menu   : " + daftar.get(i).namaProduk + "\n   Jenis Menu  : " + daftar.get(i).jenis + " \n   Harga       : " + daftar.get(i).harga + " \n   Stok        : " + daftar.get(i).stok);
            }
//            for(Produk x : daftar){
//
//                System.out.println((i+1) + ". Nama Menu   : " + x.getNamaProduk() + "\n   Jenis Menu  : " + x.getJenis()+ " \n   Harga       : " + x.getHarga() + " \n   Stok        : " + x.getStok());
//                i++;
//            }
            if(i == 0){
                System.out.println("Belum ada menu yang di Input\n");
            }

            System.out.println("======================================\n");
        }

    public String getNamaProduk() {
        return namaProduk;
    }

    public JenisProduk getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void editProduk(String namaProduk, JenisProduk jenis, int harga, int stok, int opsi){

        daftar.set(opsi, new Produk(namaProduk, jenis, harga, stok));
//            for( int i = 0; i < dafter.size(); i++){
//                if(namaProduk.getModel().equals(daftar.get(i)){
//                    daftar.set(i, newNama ); // Create your object and pass it here
//                }


//            System.out.println("Nama Menu yang baru: ");
//            newNama = input.next();
//            System.out.println("Menu yang baru: ");
//            int pilJenis = input.nextInt();
//            newJenis = null;
//            if (pilJenis == 1) {
//                newJenis = JenisProduk.Mie;
//                break;
//            } else if (pilJenis == 2) {
//                newJenis = JenisProduk.Snack;
//                break;
//            } else if (pilJenis == 3) {
//                newJenis = JenisProduk.Minuman;
//                break;
//            } else if (pilJenis == 4) {
//                newJenis = JenisProduk.Nasi;
//                break;
//            } else {
//                System.out.println("Maaf Pilihan Tidak Ada Silahkan Memilih Kembali");
//
//            }
//
//            System.out.println("Nama Harga yang baru: ");
//            newHarga = input.nextInt();
//            System.out.println("Nama Stok yang baru: ");
//            newStok = input.nextInt();
//
//            daftar.set(newNama, newJenis, newHarga, newStok);
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
        public void hapusProduk(int opsi){
            int i;
            for (i = 0; i<daftar.size();i++){
                if(opsi == i){
                    daftar.remove(i);
                }
            }
//            int i = 0;
//            for(Produk x : daftar){
//                if(x.namaProduk.equals(namaProduk)){
//                    daftar.remove(i);
//                    System.out.println("Produk dengan nama " + namaProduk +" berhasil dihapus");
//
//                    i++;
//                    break;
//                }
//
//            }
            if(i==0){
                System.out.println("Produk dengan nama " + namaProduk + "Tidak dapat ditemukan");
            }


        }

//        public void beliProduk(){
//            System.out.println("Masukkan Jumlah obat yang akan Anda Beli :");
//            jumlah = Integer.valueOf(new Scanner(System.in).nextLine());
//
//            while(p1 <= jumlah){
//                System.out.println("Obat Ke-" + p1 + " : ");
//                obat = Integer.valueOf(new Scanner(System.in).nextLine());
//                System.out.println("Jumlah Obat ke-" + p1 + " Yang mau di Beli" + " : ");
//                stok = Integer.valueOf(new Scanner(System.in).nextLine());
//                harga = harga + (arrayHarga[obat - 1] * stok);
//                p1++;
//            }
//            System.out.println("=====================================================");
//            System.out.println("Total Pembayaran = Rp. " + harga + ",00");
//            System.out.println("=====================================================");
//
//            }

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

