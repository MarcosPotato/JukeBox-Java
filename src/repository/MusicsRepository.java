package repository;

import models.Musics;

public class MusicsRepository {
    Musics music = new Musics();

    public void insertNewMusic(int id, String name, String artist, String duration, String category){
        music.setId(id);
        music.setName(name);
        music.setArtist(artist);
        music.setDuration(duration);
        music.setCategory(category);
        /**
         * Inserir objeto musica no banco
         */
    }

    public void deleteMusic(int id){
        /**
         * Deletar musica no banco
         */
    }

    public Musics[] listAllMusic(){
        Musics musics[] = new Musics[2];

        musics[0] = new Musics();
        musics[0].setId(1);
        musics[0].setName("Name 1");
        musics[0].setArtist("Artist 1");
        musics[0].setDuration("2:38");
        musics[0].setCategory("rock");

        musics[1] = new Musics();
        musics[1].setId(1);
        musics[1].setName("Name 2");
        musics[1].setArtist("Artist 2");
        musics[1].setDuration("3:38");
        musics[1].setCategory("brega funk");

        return musics;
    }
}
