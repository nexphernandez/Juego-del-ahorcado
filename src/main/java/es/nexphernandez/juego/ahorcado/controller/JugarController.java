package es.nexphernandez.juego.ahorcado.controller;

import es.nexphernandez.juego.ahorcado.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class JugarController {

    @FXML
    private Text userIdText;

    @FXML
    private Text nivelText;

    @FXML
    private Text POcultaText;

    @FXML
    private Text palabraText;

    @FXML
    private Button aceptarButton;

    @FXML
    private Button atrasButton;

    /**
     * Metodo para ir a la pantalla ingresar
     */
    @FXML
    protected void regresarButtonClick() {
        try {
            Stage stage = (Stage) atrasButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("ingresar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla de ingreso");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void aniadirLetra() {

    }
}
