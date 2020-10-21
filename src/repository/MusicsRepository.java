package repository;

import java.sql.*;

import database.ConnectDataBase;
import models.Musics;

public class MusicsRepository {

    Musics music = new Musics();
    ConnectDataBase connect = new ConnectDataBase();


    public boolean insertNewMusic(Musics music){

        Connection conn = connect.connectDB();

        String countSql = "SELECT COUNT(*) FROM musics";
        String sql = "INSERT INTO musics(id, name, artist, duration, category) VALUES(?,?,?,?,?)";

        ResultSet musicsCount = null;
        int count = 0;

        try{
            Statement stmt  = conn.createStatement();
            musicsCount = stmt.executeQuery(countSql);
            
            while(musicsCount.next()){
                count = musicsCount.getInt(1);
            }

            music.setId(count++);
        } catch(SQLException err){
            System.err.println(err.getMessage());
        }

        

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

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
        Connection conn = connect.connectDB();

        String sql = "DELETE FROM musics WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Music deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Fail to delete this music");
        }
    }

    public void listAllMusic(){

        String sql = "SELECT * FROM musics";
        ResultSet musics = null;

        Connection conn = connect.connectDB();
        
        try{
            Statement stmt  = conn.createStatement();
            musics = stmt.executeQuery(sql);
            while (musics.next()) {
                System.out.println(musics.getInt("id") + "\t" + 
                                   musics.getString("name") + "\t" +
                                   musics.getString("duration") + "\t" +
                                   musics.getString("artist") + "\t" +
                                   musics.getString("category") + "\t");
            }

        }catch(SQLException err){
            System.err.println(err.getMessage());
            System.out.println("Nothing to see");
        }

    }
}
