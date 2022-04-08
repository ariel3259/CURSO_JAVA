package lecura.SOLID.primerPrincipio;

public class UserLogin {
    private final Database db;

    UserLogin(Database db){
        this.db = db;
    }

    void login(String username, String password){
        User user = db.findByUserName(username);
        if(user == null ){

        }
        else{

        }
    }


}

