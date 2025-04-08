package es.nexphernandez.juego.ahorcado.controller;

import es.nexphernandez.juego.ahorcado.PrincipalApplication;
import es.nexphernandez.juego.ahorcado.controller.abstractas.AbstractController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class RecuperarController extends AbstractController{
    @FXML
    private Text emailText;

    @FXML
    private Label texto;

    @FXML
    private TextField emailField;

    @FXML
    private Button enviarButton;

    @FXML
    private Button regresarButton;

    /**
     * Metodo que escribe una cadena de texto al pulsar un boton
     */
    @FXML
    protected void onEnviarClick() {
        if (emailField.getText() == null || emailField.getText().isEmpty()) {
            texto.setText("no puedes dejar el campo vacio");
            return;
        }
        if (getUsuarioServiceModel().obtenerUsuariosPorEmail(emailField.getText()) == null) {
            texto.setText("no hay usuarios registrados con ese email");
            return;
        }
        texto.setText("Su contraseña es: "
                + getUsuarioServiceModel().obtenerUsuariosPorEmail(emailField.getText()).getPassword());
    }

    /**
     * metodo para volver a la pagina anterior
     */
    @FXML
    protected void onRegresarClick() {
        try {
            Stage stage = (Stage) regresarButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("inicio.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Recuperar Contraseña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
