package services;

import java.util.ArrayList;

import models.Musics;
public class AddMusicQueue {
    public ArrayList<Musics> execute(ArrayList<Musics> list, Musics nextMusic) {

        if(!list.contains(nextMusic)){
            list.add(nextMusic);
        } else{
            System.out.println("This music is already on queue");
        }

        return list;
    }
}