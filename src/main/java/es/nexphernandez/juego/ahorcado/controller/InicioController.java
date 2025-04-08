package es.nexphernandez.juego.ahorcado.controller;

import es.nexphernandez.juego.ahorcado.PrincipalApplication;
import es.nexphernandez.juego.ahorcado.controller.abstractas.AbstractController;
import es.nexphernandez.juego.ahorcado.model.UsuarioEntity;
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
public class InicioController extends AbstractController{
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
    
    @FXML 
    private Text errorText;

    /**
     * Metodom para ir a la pantalla ingresar
     */
    @FXML
    protected void OpenAceptarClick() {
        if (!comprobarTextField(userEmailField)) {
            errorText.setText("Usuario no puede estar vacio");
            return;
        }
        if (!comprobarTextField(passwordField)) {
            errorText.setText("Contraseña no puede estar vacio");
            return;
        }
        UsuarioEntity usuario = getUsuarioServiceModel().obtenerUsuariosPorUser(userEmailField.getText());
        if (usuario == null) {
            errorText.setText("el usuario no existe");
            return;
        }
        if (!(usuario.getPassword().equals(passwordField.getText()))) {
            errorText.setText("error en usuario o contraseña");
            return;
        }
        setUsuarioActual(usuario);
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
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            PerfilController perfilController = fxmlLoader.getController();
            perfilController.setDireccion("inicio");
            stage.setTitle("Pantalla de inicio");
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