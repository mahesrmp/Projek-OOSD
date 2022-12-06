package OppungShop;

public abstract class User {
    String username,password;

    public User(){
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public boolean login(String iusername, String ipassword){
        if(this.username.equals(iusername) && this.password.equals(ipassword)){
            return true;
        }
        else{

            return false;
        }


    }
}
