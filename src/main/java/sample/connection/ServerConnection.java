package sample.connection;

import com.desitsa.websocketmanager.Connection;

public class ServerConnection {

    private static ServerConnection instance;

    private Connection connection;

    public static ServerConnection getInstance() {
        if (instance == null) instance = new ServerConnection();
        return instance;
    }

    private ServerConnection() {
            connection = new Connection("wss://desitsa.com/messages", Messages.class);
            connection.start();
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        connection.close();
    }
}
