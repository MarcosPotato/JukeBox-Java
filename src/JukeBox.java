import database.ConnectDataBase;

public class JukeBox {
    public static void main(String[] args) {
        ConnectDataBase connect = new ConnectDataBase();

        connect.connectDB();
    }
}
