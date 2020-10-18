import java.sql.ResultSet;
import java.sql.SQLException;

import repository.MusicsRepository;

public class JukeBox {
    public static void main(String[] args) {
        MusicsRepository MusicControl = new MusicsRepository();

        MusicControl.insertNewMusic(1, "Name 1", "Artist1", "2:45", "Rock");

        try{
            ResultSet rows = MusicControl.listAllMusic();

            while (rows.next()) {
                System.out.println(rows.getInt("id") +  "\t" + 
                                   rows.getString("name") + "\t" +
                                   rows.getDouble("capacity"));
            }
        } catch(SQLException err){
            System.err.println(err.getMessage());
        }
    }
}
