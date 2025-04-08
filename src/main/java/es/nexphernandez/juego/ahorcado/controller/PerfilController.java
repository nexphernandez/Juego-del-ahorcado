package es.nexphernandez.juego.ahorcado.controller;

import java.sql.SQLException;
import java.util.ArrayList;

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
public class PerfilController extends AbstractController{
    @FXML
    private Text userText;

    @FXML
    private Text emailText;

    @FXML
    private Text RepetirPassword;

    @FXML
    private Text passwordText;

    @FXML
    private Text errorText;

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
        if (!comprobarRegistrar()) {
            return;
        }
        UsuarioEntity nuevoUsuario = new UsuarioEntity(userTextField.getText(), emailField.getText(),passwordField.getText());
        ArrayList<UsuarioEntity> usuarioEntityList;
            usuarioEntityList = getUsuarioServiceModel().obtenerTodosLosUsuarios();
        if (usuarioEntityList.contains(nuevoUsuario)) {
            errorText.setText("Ya hay una cuenta registrada con ese correo");
            return;
        }
        if (getUsuarioServiceModel().obtenerUsuariosPorUser(userTextField.getText()) != null) {
            errorText.setText("Ya hay una cuenta registrada con ese usuario");
            return;
        }
            getUsuarioServiceModel().aniadirUsuario(nuevoUsuario);
    }

    /**
     * comprueba que los campos sean validos
     * @return true/false
     */
    private boolean comprobarRegistrar(){
        if(!comprobarTextField(userTextField)){
            errorText.setText("Usuario no puede estar vacio");
            return false;
        }
        if(!comprobarTextField(passwordField)){
            errorText.setText("Contrasenia no puede estar vacio");
            return false;
        }
        if(!comprobarTextField(RepetirPasswordField)){
            errorText.setText("Repetir contrasenia no puede estar vacio");
            return false;
        }
        if (!passwordField.getText().equals(RepetirPasswordField.getText()) ) {
            errorText.setText("La contrasenia repetida debe ser igual");
            return false;
        }
        if(!comprobarTextField(emailField)){
            errorText.setText("El correo no puede estar vacio");
            return false;
        }
        if(!comprobarTextField(repetireEmailField)) {
            errorText.setText("Correo repetir de los valores puede estar vacio");
            return false;
        }
        if (!emailField.getText().equals(repetireEmailField.getText()) ) {
            errorText.setText("Los correos deben ser iguales");
            return false;
        }
        return true;
    }

    /**
     * Metodo para ir a la pantalla inicio
     */
    @FXML
    protected void regresarButtonClick() {
        try {
            Stage stage = (Stage) regresarButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(getDireccion()+".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla de inicio");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
