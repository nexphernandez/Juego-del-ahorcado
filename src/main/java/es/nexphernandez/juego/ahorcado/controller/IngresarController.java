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
public class IngresarController extends AbstractController{
    @FXML
    private Text userText;

    @FXML
    private Text emailText;

    @FXML
    private Text nivelText;

    @FXML
    private TextField userField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nivelField;

    @FXML
    private Button editarButton;

    @FXML
    private Button jugarButton;

    @FXML
    private Button regresarButton;

    @FXML
    private Button listarbutton;

    /**
     * Metodo para ir a la pantalla perfil
     */
    @FXML
    protected void openEditarClick() {
        try {
            Stage stage = (Stage) editarButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("perfil.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            PerfilController perfilController = fxmlLoader.getController();
            perfilController.setDireccion("ingresar");
            stage.setTitle("Pantalla Recuperar Contraseña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para ir a la pantalla jugar
     */
    @FXML
    protected void openjugarClick() {
        try {
            Stage stage = (Stage) jugarButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("jugar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Recuperar Contraseña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para ir a la pantalla inicio
     */
    @FXML
    protected void openRegresarClick() {
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
    /**
     * Metodo para ir a la pantalla listar
     */
    @FXML
    protected void openListarClick() {
        try {
            Stage stage = (Stage) listarbutton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("listarUsuarios.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Recuperar Contraseña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
