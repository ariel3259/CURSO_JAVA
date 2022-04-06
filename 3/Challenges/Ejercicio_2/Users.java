package Challenges.Ejercicio_2;

public class Users{

    protected String email;
    protected String password;
    private final String[] musics = {"Batery", "Iron man", "Bohemian rhapsody", "Killer Queen", "N.I.B"};

    public Users(String email, String password){
        this.email = email;
        this.password = password;
    }
    
    public void showMusics(){
        for(int i = 0; i < musics.length; i++){
            System.out.println((i+1)+"-"+musics[i]);
        }
    }

    public void listenToMusic(int musicIndex){
        System.out.println("Listening to "+musics[musicIndex-1]);
    }   
}