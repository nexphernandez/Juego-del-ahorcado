package es.nexphernandez.juego.ahorcado.controller;

import es.nexphernandez.juego.ahorcado.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class PerfilController {
    @FXML
    private Text userText;

    @FXML
    private Text emailText;

    @FXML
    private Text RepetirPassword;

    @FXML
    private Text passwordText;

    @FXML
    private Text repetireEmailText;

    @FXML
    private TextField userTextField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField repetireEmailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField RepetirPasswordField;

    @FXML
    private Button guardarButton;

    @FXML
    private Button regresarButton;

    @FXML
    protected void guardarButtonClick() {
        
    }

    @FXML
    protected void regresarButtonClick() {
        try {
            Stage stage = (Stage) regresarButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("inicio.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla de inicio");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
