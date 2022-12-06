package OppungShop;

import java.util.ArrayList;

public class Pembeli extends User implements Individu{
    String namaPembeli;
    int saldo;
    String alamat;
    public Pembeli(){
    }

    public Pembeli(String namaPembeli, int saldo, String username, String password) {
        super(username, password);
        this.namaPembeli = namaPembeli;
        this.saldo = saldo;

    }

    ArrayList<Pembeli> daftar = new ArrayList<Pembeli>();
    int i = 0;
    public void daftar(String namaPembeli, int saldo, String username, String password){
        int chk = 0;

        for(Pembeli x : daftar){
            if(x.username.equals(username)){
                chk++;
            }

        }
        if(chk == 0){
            daftar.add(new Pembeli(namaPembeli,saldo,username,password));
            System.out.println("Akun anda berhasil didaftarkan");
        }
        else{
            System.out.println("Username anda Sudah didaftarkan, silahkan pilih username yang lain");
        }
    }

    @Override
    public boolean login(String iusername, String ipassword){
        i = 0;
        for(Pembeli x : daftar){
            if(x.username.equals(iusername) && x.password.equals(ipassword)){
                i++;
            }
        }

        if(i == 0){
            return false;
        }
        else{
            return true;
        }

    }
    public Pembeli pilihUser(){
        return daftar.get(i-1);
    }

    public void Beli(int harga, int jumlah){
        this.saldo = this.saldo - (jumlah * harga);

    }

    public void tambahSaldo(int nominal,String nama){
        for(Pembeli x : daftar){
            if(x.namaPembeli.equals(nama)){
                x.saldo = x.saldo + nominal;
                System.out.println("Saldo Berhasil Ditambahkan");
            }
        }
    }

    @Override
    public void perkenalan() {
        System.out.println("Hello ");
    }

}
