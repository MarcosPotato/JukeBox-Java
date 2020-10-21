package database.migrations;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateTableMusics {
    public void tableMusics(String url) {

        String sql = "CREATE TABLE IF NOT EXISTS musics (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name varchar(50) NOT NULL,\n"
                + "	artist varchar(50) NOT NULL,\n"
                + "	duration varchar(10) NOT NULL,\n"
                + "	category varchar(50) NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
