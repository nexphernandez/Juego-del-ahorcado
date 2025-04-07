package es.nexphernandez.juego.ahorcado.controller;

import es.nexphernandez.juego.ahorcado.PrincipalApplication;
import es.nexphernandez.juego.ahorcado.controller.abstractas.AbstractController;
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
public class InicioController {
    @FXML
    private Text userEmailText;

    @FXML
    private Text passwordText;

    @FXML
    private TextField userEmailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button aceptarButton;

    @FXML
    private Button registrarButton;

    @FXML
    private Button recuperarContraseniaButton;


    /**
     * Metodom para ir a la pantalla ingresar
     */
    @FXML
    protected void OpenAceptarClick() {
        try {
            Stage stage = (Stage) aceptarButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("ingresar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Recuperar Contraseña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para ir a la pantalla perfil
     */
    @FXML
    protected void OpenRegistrarClick() {
        try {
            Stage stage = (Stage) registrarButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("perfil.fxml"));
            PerfilController perfilController = fxmlLoader.getController();
            perfilController.setDireccion("ingresar");
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Recuperar Contraseña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo para ir a la pantalla recuperar
     */
    @FXML
    protected void OpenRecuperarContraseniaClick() {
        try {
            Stage stage = (Stage) recuperarContraseniaButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("recuperar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Recuperar Contraseña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}