import repository.MusicsRepository;
import java.util.Scanner;

import models.Musics;

public class JukeBox {
    public static void main(String[] args) {
        MusicsRepository MusicControl = new MusicsRepository();

        Scanner scanf = new Scanner(System.in);
        int option = 5;

        do{
            System.out.println("Welcome to jukebox");
            System.out.println("Select a option");
            System.out.println("\n");
            System.out.println("1- Insert Music");
            System.out.println("2- List All Musics");
            System.out.println("3- Delete Music");
            System.out.println("\n");
            System.out.println("0- Exit Jukebox");
            System.out.println("\n");

            option = scanf.nextInt();
            
            switch(option){
                case 0:
                    break;
                case 1:
                    Musics music = new Musics();

                    System.out.println("Enter music name: ");
                    scanf.nextLine();
                    music.setName(scanf.nextLine());
                    System.out.println("Enter music artist: ");
                    music.setArtist(scanf.nextLine());
                    System.out.println("Enter music duration: ");
                    music.setDuration(scanf.nextLine());
                    System.out.println("Enter music category: ");
                    music.setCategory(scanf.nextLine());

                    MusicControl.insertNewMusic(music);
                    break;
                case 2:
                    MusicControl.listAllMusic();
                    break;
                case 3:
                    MusicControl.listAllMusic();
                    System.out.println("Select music id has be delete: ");
                    MusicControl.deleteMusic(scanf.nextInt());
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }while(option != 0);
        
        scanf.close();
    }
}
