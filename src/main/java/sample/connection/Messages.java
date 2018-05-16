package sample.connection;

import com.desitsa.websocketmanager.MessagesHandler;

public class Messages extends MessagesHandler {
    @Override
    public void onConnected(String connectionID) {
        System.out.println("conectado");
    }

    @Override
    public void onTextMessage(String message) {
        System.out.println("Sv msg: " + message);
    }

    public void receiveMessage(String id, String msg) {
        System.out.println(id + " - " + msg);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("cerrado");
    }
}
