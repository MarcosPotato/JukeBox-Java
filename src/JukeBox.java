import repository.MusicsRepository;
import services.AddMusicQueue;
import services.SelectMusicService;

import java.util.ArrayList;
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
            System.out.println("4- Play Music");
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
                case 4:
                    SelectMusicService selectMusicService = new SelectMusicService();
                    
                    MusicControl.listAllMusic();
                    System.out.println("Select music id to play: ");
                    Musics selectedMusic = selectMusicService.execute(scanf.nextInt());

                    if(selectedMusic.getName() != null){
                        ArrayList<Musics> musicList = new ArrayList<Musics>();
                        int musicActions;

                        do{
                            System.out.println("\n");
                            System.out.println("Artist: " + selectedMusic.getArtist());
                            System.out.println("Play: " + selectedMusic.getName() + " " + selectedMusic.getDuration() + " min");
                            System.out.println("\n");
                            System.out.println("1- Stop");
                            System.out.println("2- Next");
                            System.out.println("3- Add music queue");
                            System.out.println("0- Exit");
    
                            musicActions = scanf.nextInt();
    
                            switch(musicActions){
                                case 0:
                                    musicActions = 0;
                                    break;
                                case 1:
                                    System.out.println("Music stoped");
                                    break;
                                case 2:
                                    if(musicList.size() == 0){
                                        System.out.println("No music to play");
                                    } else{
                                        System.out.println(musicList.size());
                                        selectedMusic = musicList.get(musicList.indexOf(selectedMusic) + 1);
                                    }
                                    break;
                                case 3:
                                    AddMusicQueue addMusicQueueService = new AddMusicQueue();
    
                                    MusicControl.listAllMusic();
                                    System.out.println("Select music id to play: ");
                                    Musics nextMusic = selectMusicService.execute(scanf.nextInt());
    
                                    musicList.add(selectedMusic);
    
                                    musicList = addMusicQueueService.execute(musicList, nextMusic);
    
                                    System.out.println("Music " + nextMusic.getName() + "add on queue");
    
                                    break;
                                default:
                                    System.out.println("Invalid Option");
                            }
                        }while(musicActions != 0);
                    }
                    
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }while(option != 0);
        
        scanf.close();
    }
}
