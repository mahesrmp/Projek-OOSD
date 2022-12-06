package OppungShop;

public class Admin<T> extends User implements Individu {
    int idAdmin;
    T gaji;
    public Admin(){

    }

    public Admin(int idAdmin, String username, String password,T gaji ) {
        super(username, password);
        this.idAdmin = idAdmin;
        this.gaji = gaji;
    }

    @Override
    public void perkenalan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

