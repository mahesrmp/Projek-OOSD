package OppungShop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    class InnerClass {
        void salamAwal() {
            System.out.println("Selamat Datang Di Aplikasi Oppung Shop");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String tgl_jam = sdf.format(dt);
        String n = tgl_jam;
        Main s = new Main();
        Main.InnerClass salam = s.new InnerClass();
        salam.salamAwal();
        Admin<Integer> staf = new Admin<Integer>(1, "admin", "admin", 100000);
        Pembeli pembeli = new Pembeli();
        Produk produk = new Produk();
        produk.daftar.add(new Produk("Mie Gomak", JenisProduk.Mie, 2000, 50));
        HistoryPembelian catatan = new HistoryPembelian();
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        int pil;
            try {
                awal:
                while (true) {
                    System.out.println("Selamat Datang Di Oppung Shop ");
                    System.out.println("Menu Awal");
                    System.out.println("(1) Login Sebagai Admin");
                    System.out.println("(2) Login Sebagai Pembeli");
                    System.out.println("(3) Daftar Sebagai Pembeli");
                    System.out.print("Pilihan :");
                    pil = input.nextInt();
                    if (pil == 1) {
                        System.out.println("Masukkan Username");
                        String username = input.next();
                        System.out.println("Masukkan Password");
                        String password = input.next();
                        if (staf.login(username, password) == true) {
                            System.out.println("Selamat Datang " + staf.username);
                            while (true) {
                                pil = 0;
                                System.out.println("Menu Admin");
                                System.out.println("(1) Menu yang tersedia");
                                System.out.println("(2) Tambah Menu");
                                System.out.println("(3) Cari Menu");
                                System.out.println("(4) Edit Menu");
                                System.out.println("(5) Hapus Menu");
                                System.out.println("(6) Lihat History Pembelian");
                                System.out.println("(7) Logout");
                                System.out.print("pilihan ");
                                pil = input.nextInt();
                                if (pil == 1) {
                                    produk.lihatSemuaProduk();
                                } else if (pil == 2) {
                                    System.out.println("Masukkan nama menu");
                                    input.nextLine();
                                    String namaProduk = input.nextLine();
                                    JenisProduk jenis;
                                    while (true) {
                                        System.out.println("Pilih Jenis Menu");
                                        System.out.println("\n(1)Mie\n(2)Snack\n(3)Minuman\n(4)Nasi");
                                        pil = input.nextInt();
                                        if (pil == 1) {
                                            jenis = JenisProduk.Mie;
                                            break;
                                        } else if (pil == 2) {
                                            jenis = JenisProduk.Snack;
                                            break;
                                        } else if (pil == 3) {
                                            jenis = JenisProduk.Minuman;
                                            break;
                                        } else if (pil == 4) {
                                            jenis = JenisProduk.Nasi;
                                            break;
                                        } else {
                                            System.out.println("Maaf Pilihan Tidak Ada Silahkan Memilih Kembali");

                                        }
                                    }

                                    System.out.print("Masukkan Harga Menu : ");
                                    int harga = input.nextInt();
                                    System.out.println("Banyaknya stok : ");
                                    int stok = input.nextInt();


                                    produk.tambahProduk(namaProduk, jenis, harga, stok);
                                    System.out.println("Produk Berhasil Ditambahkan\n");
                                    produk.lihatSemuaProduk();
                                } else if (pil == 3) {
                                    System.out.print("Masukkan Nama Menu : ");
                                    input.nextLine();
                                    String namaProduk = input.nextLine();
                                    produk.cariNamaProduk(namaProduk);
                                } else if (pil == 4) {
                                    produk.lihatSemuaProduk();
                                    System.out.println("Pilih menu yang ingin di Edit: ");
                                    int opsi = input.nextInt();
                                    if (opsi > 0) {
                                        System.out.println("Nama Menu yang baru: ");
                                        String namaProduk = input.next();
                                        JenisProduk jenis;
                                        while (true) {
                                            System.out.println("Pilih Jenis Menu Baru: ");
                                            System.out.println("\n(1)Mie\n(2)Snack\n(3)Minuman\n(4)Nasi");
                                            int pilJenis = input.nextInt();
                                            if (pilJenis == 1) {
                                                jenis = JenisProduk.Mie;
                                                break;
                                            } else if (pilJenis == 2) {
                                                jenis = JenisProduk.Snack;
                                                break;
                                            } else if (pilJenis == 3) {
                                                jenis = JenisProduk.Minuman;
                                                break;
                                            } else if (pilJenis == 4) {
                                                jenis = JenisProduk.Nasi;
                                                break;
                                            } else {
                                                System.out.println("Maaf Pilihan Tidak Ada Silahkan Memilih Kembali");

                                            }
                                        }

                                        System.out.println("Nama Harga yang baru: ");
                                        int harga = input.nextInt();
                                        System.out.println("Nama Stok yang baru: ");
                                        int stok = input.nextInt();

                                        produk.editProduk(namaProduk, jenis, harga, stok, opsi - 1);
                                        System.out.println("Produk Berhasil Diubah\n");
                                    }else {
                                        break ;
                                    }
                                    produk.lihatSemuaProduk();
                                } else if (pil == 5) {
                                    produk.lihatSemuaProduk();
                                    System.out.print("Masukkan No Menu yang ingin di hapus : ");
                                    int opsi = input.nextInt();
                                    if(opsi > 0) {
                                        produk.hapusProduk(opsi-1);
                                    }else{
                                        break ;
                                    }
                                    produk.lihatSemuaProduk();
                                } else if (pil == 6) {
                                    catatan.tampilSemuaCatatan();
                                } else if (pil == 7) {
                                    continue awal;
                                }
                            }

                        } else {
                            System.out.println("Username atau password yang anda Masukkan Salah Silahkan Ulangi Kembali");
                        }

                    } else if (pil == 2) {

                        System.out.println("\nMasukkan Username : ");
                        String username = input.next();
                        System.out.println("Masukkan Password");
                        String password = input.next();
                        if (pembeli.login(username, password) == true) {
                            System.out.println("Login Berhasil");
                            Pembeli luser = pembeli.pilihUser();
                            luser.perkenalan();
                            while (true) {
                                System.out.println("\nSelamat Datang " + luser.namaPembeli);
                                System.out.println("Saldo = " + luser.saldo);
                                System.out.println("Menu");
                                System.out.println("(1) Lihat Menu");
                                System.out.println("(2) Cari Menu");
                                System.out.println("(3) Beli Menu");
                                System.out.println("(4) Isi ulang saldo");
                                System.out.println("(5) Lihat Catatan Pembelian Anda");
                                System.out.println("(6) Logout");
                                System.out.print("Pilihan : ");
                                pil = input.nextInt();
                                if (pil == 1) {
                                    produk.lihatSemuaProduk();

                                } else if (pil == 2) {
                                    System.out.print("Masukkan Nama Menu : ");
                                    String namaProduk = input.next();
                                    produk.cariNamaProduk(namaProduk);

                                } else if (pil == 3) {
                                    int p1 = 1;
                                    int jumlah;
                                    String namaProduk = null;
                                    int jumlahProduk = 0;
                                    produk.lihatSemuaProduk();
                                    System.out.println("Masukkan Jumlah Menu yang akan Anda Beli :");
                                    jumlah = Integer.valueOf(new Scanner(System.in).nextLine());
                                    while(p1 <= jumlah) {
                                        System.out.print("Masukkan Nama Menu " + p1 + " Yang Ingin Dibeli:  ");
                                        namaProduk = input.next();
                                        System.out.print("Masukkan Jumlah Menu " + p1 + " Yang Ingin Dibeli:  ");
                                        jumlahProduk = input.nextInt();
                                        p1++;
                                    }

                                        try {
                                            Produk obs = produk.cariNamaProduk(namaProduk, 1);
                                            if (obs.stok >= jumlahProduk) {
                                                if (luser.saldo >= (jumlahProduk * obs.harga)) {
                                                    obs.stok = obs.stok - jumlahProduk;
                                                    luser.Beli(obs.harga, jumlahProduk);
                                                    catatan.catat(luser.namaPembeli, namaProduk, jumlahProduk, n);
                                                    int totalHarga = jumlahProduk * obs.harga;
                                                    System.out.println("Total pembayaran = Rp "+ totalHarga +"");
                                                    System.out.println("Metode Pengambilan barang: \n1. Ambil di tempat\n2. Antar\nPilihan: ");
                                                    int pilih = input.nextInt();
                                                    switch (pilih) {
                                                        case 1:
                                                            System.out.println("Oks kami menunggu mu");
                                                            break;
                                                        case 2:
                                                            System.out.println("Masukkan Alamat Lengkap: ");
                                                            String inputAlamat = input.next();
                                                            System.out.println("Barang anda akan di kirim ke alamat " + inputAlamat + ", silahkan tunggu");
                                                            break;
                                                    }
                                                } else {
                                                    System.out.println("Saldo tidak Mencukupi");
                                                }

                                            } else {
                                                System.out.println("Stok tidak Mencukupi");
                                            }

                                        } catch (Exception e) {
                                            System.out.println("Terjadi Kesalahan");
                                        } finally {
                                            System.out.println("\n");
                                        }

                                } else if (pil == 4) {
                                    System.out.print("Masukkan Jumlah Nominal : ");
                                    int nominal = input.nextInt();
                                    pembeli.tambahSaldo(nominal, luser.namaPembeli);
                                } else if (pil == 5) {
                                    catatan.tampilCatatanPembeli(luser.namaPembeli);
                                } else if (pil == 6) {
                                    continue awal;
                                }

                            }
                        } else {
                            System.out.println("User Belum Terdaftar");
                        }

                    } else if (pil == 3) {
                        System.out.println("Selamat Mendaftar");
                        System.out.println("Masukkan Username");
                        input.nextLine();
                        String username = input.nextLine();
                        System.out.println("Masukkan Password");
                        String password = input.nextLine();
                        System.out.println("Masukkan Nama : ");
                        String nama = input.nextLine();
                        System.out.println("Masukkan Saldo");
                        int saldo = input.nextInt();
                        pembeli.daftar(nama, saldo, username, password);
                    }

                }
            } catch (Exception e) {
                System.out.println("Inputan anda salah");

            }
    }
}
