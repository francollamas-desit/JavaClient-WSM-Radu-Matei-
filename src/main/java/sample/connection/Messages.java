package sample.connection;

import com.desitsa.websocketmanager.MessagesHandler;

public class Messages extends MessagesHandler {

    private boolean autentified;

    @Override
    public void onConnected(String connectionID) {

        // Conexión con el servidor
        invoke("Handshake", "SR-A01", "asdasd").result((r, e) -> {
            if (e != null || r == null) return;

            autentified = (boolean)r;
            if (autentified) {
                System.out.println("Autenticado!!");
            }
        });
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
