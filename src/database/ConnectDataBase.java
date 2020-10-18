package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import database.migrations.CreateTableMusics;

public class ConnectDataBase {
    private Connection connect;

    CreateTableMusics create = new CreateTableMusics();

    public Connection connectDB() {

        try {

            String url = "jdbc:sqlite:src/database/jukebox.db";

            this.connect = DriverManager.getConnection(url);

            create.tableMusics(url);

        } catch (SQLException e) {
            throw new Error(e.getMessage());
        }

        System.out.println("conectou!!!");
        
        return this.connect;
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