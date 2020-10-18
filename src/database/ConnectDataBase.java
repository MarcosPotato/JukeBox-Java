package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDataBase {
    private Connection connect;


    public boolean connectDB() {

        try {

            String url = "jdbc:sqlite:banco_de_dados/banco_sqlite.db";

            this.connect = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        System.out.println("conectou!!!");
        
        return true;
    }

    public boolean disconnectDB(){
        try{
            if(this.connect.isClosed() == false){
                this.connect.close();
            }

        }catch(SQLException err){
            System.err.println(err.getMessage());
            return false;
        }


        return true;
    }
}