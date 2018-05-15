package sample.connection;

import com.desitsa.websocketmanager.MessagesHandler;

public class Messages extends MessagesHandler {
    @Override
    public void onConnected(String connectionID) {
        int i = 0;
        long timer = 0;

        while (System.currentTimeMillis() - timer > 15) {
            timer = System.currentTimeMillis();

            invoke("Retorno", i).result((res, err) -> {
                if (res == null) return;
                int ress = (int)res;

                System.out.println("Resultado: " + connectionID + ">" + res);
            });

            i++;
            if (i == 40) break;
        }
    }

    @Override
    public void onTextMessage(String message) {
        System.out.println("Sv msg: " + message);
    }

    public void receiveMessage(String id, String msg) {
        System.out.println("[" + id + "] " + msg);
    }

    public int DoMath(int a, int b) {
        return a + b;
    }


}
