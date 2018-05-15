package sample.connection;

import com.desitsa.websocketmanager.Connection;

import java.util.ArrayList;

public class ServerConnection {

    private ArrayList<Connection> cons;
    private static ServerConnection instance;

    public static ServerConnection getInstance() {
        if (instance == null) instance = new ServerConnection();
        return instance;
    }

    private ServerConnection() {

        cons = new ArrayList<>();
        for (int i = 0; i < 900; i++) {
            Connection c = new Connection("ws://localhost:54800/messages", Messages.class);
            c.start();
            cons.add(c);
        }

    }

    public void close() {
        for (Connection c : cons) c.close();
    }
}
