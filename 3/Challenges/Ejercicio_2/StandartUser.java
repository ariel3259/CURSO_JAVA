package Challenges.Ejercicio_2;

import java.util.Timer;
import java.util.TimerTask;

public class StandartUser extends Users{
    
    private final String[] musics = {"N.I.B", "Iron Man"};

    public StandartUser(String email, String password){
        super(email, password);
    }

    public void listenToMusic(int musicIndex){
        
        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Spam");
            }
            
        }, 500, 5000);

        System.out.println(musics[musicIndex]);
    }
}