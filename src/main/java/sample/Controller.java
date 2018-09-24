package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import sample.connection.Messages;
import sample.connection.ServerConnection;

public class Controller {

    @FXML
    private JFXTextField txtMensaje;

    @FXML
    private JFXButton btnEnviar;

    @FXML
    private JFXButton btnCon;

    @FXML
    private JFXButton btnDesc;

    @FXML
    void conectar(MouseEvent event) {
        ServerConnection.getInstance();
    }

    @FXML
    void desconectar(MouseEvent event) {
        ServerConnection.getInstance().close();
    }

    @FXML
    void enviar(MouseEvent event) {
        ServerConnection.getInstance().getConnection().invokeOnly("Mensaje", txtMensaje.getText());
    }
}
