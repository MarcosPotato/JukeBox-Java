package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Musics;
import database.ConnectDataBase;

public class SelectMusicService {
    public Musics execute(int id) {
        Musics music = new Musics();
        ConnectDataBase connect = new ConnectDataBase();

        ResultSet musics = null;

        Connection conn = connect.connectDB();
        
        String sql = "SELECT * FROM musics WHERE id = " + id;

        try {
            Statement stmt  = conn.createStatement();
            musics = stmt.executeQuery(sql);

            while (musics.next()) {
                music.setId((musics.getInt("id"))); 
                music.setName(musics.getString("name"));
                music.setDuration(musics.getString("duration"));
                music.setArtist(musics.getString("artist"));
                music.setCategory(musics.getString("category"));
            }

            System.out.println("Music selected");
        } catch (SQLException e) {
            System.out.println("This music is not exists");
        }

        return music;
    }
}
