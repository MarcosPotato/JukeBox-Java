package repository;

import java.sql.*;

import database.ConnectDataBase;
import models.Musics;

public class MusicsRepository {
    Musics music = new Musics();
    ConnectDataBase connect = new ConnectDataBase();


    public boolean insertNewMusic(int id, String name, String artist, String duration, String category){
        music.setId(id);
        music.setName(name);
        music.setArtist(artist);
        music.setDuration(duration);
        music.setCategory(category);

        Connection conn = connect.connectDB();
        
        String sql = "INSERT INTO musics(id, name, artist, duration, category) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, music.getId());
            pstmt.setString(2, music.getName());
            pstmt.setString(3, music.getArtist());
            pstmt.setString(4, music.getDuration());
            pstmt.setString(5, music.getCategory());
            pstmt.executeUpdate();

            System.out.println("Musica inserida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public void deleteMusic(int id){
        /**
         * Deletar musica no banco
         */
    }

    public ResultSet listAllMusic(){

        String sql = "SELECT * FROM musics";
        ResultSet musics = null;

        Connection conn = connect.connectDB();
        
        try{
            Statement stmt  = conn.createStatement();
            musics = stmt.executeQuery(sql);
            return musics;

        }catch(SQLException err){
            System.err.println(err.getMessage());
            return musics;
        }

    }
}
