package es.nexphernandez.juego.ahorcado.controller;

import es.nexphernandez.juego.ahorcado.PrincipalApplication;
import es.nexphernandez.juego.ahorcado.controller.abstractas.AbstractController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class JugarController extends AbstractController {

    @FXML
    private Button regresarButton;
    @FXML
    private Button reiniciarButton;
    @FXML
    private TextField adivinarTextField;
    @FXML
    private Text palabraOcultaText;
    @FXML
    private Circle cabeza;
    @FXML
    private Rectangle torso;
    @FXML
    private Rectangle brazoZ;
    @FXML
    private Rectangle brazoD;
    @FXML
    private Rectangle piernaZ;
    @FXML
    private Rectangle piernaD;
    @FXML
    private Rectangle estructura;
    @FXML
    private Text palabraMostradaText;
    @FXML
    private Text vidasText;
    @FXML
    private Text puntosText;
    @FXML
    private Text usuarioText;

    private String palabraOculta;
    private StringBuilder palabraMostrada;
    private int vidas;
    private Rectangle[] partesCuerpo;

    /**
     * unicializa la lista con las partes del cuerpo
     */
    @FXML
    public void initialize() {
        usuarioText.setText(getUsuarioActual().getUser());
        partesCuerpo = new Rectangle[] { estructura, torso, brazoD, brazoZ, piernaD, piernaZ };
        reiniciarJuego();
        puntosText.setText(getUsuarioActual().getPuntos() + "");
    }

    /**
     * reinicia el juego
     */
    @FXML
    public void reiniciarOnClick() {
        reiniciarJuego();
    }

    /**
     * vuelve a la pantalla de inicio
     */
    @FXML
    public void juegoToInicioOnClick() {
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
     * elige la palabra oculta, crea las barras bajas con el tamaño de la palabra
     * oculta, da un valor a las vidas y oculta las partes del cuerpo
     */
    private void reiniciarJuego() {
        palabraOculta = getUsuarioServiceModel().obtenerPalabra(getUsuarioActual().getUser());
        palabraMostrada = new StringBuilder("_".repeat(palabraOculta.length()));
        palabraOcultaText.setText(palabraMostrada.toString());
        vidas = partesCuerpo.length;
        cabeza.setOpacity(0);
        for (Rectangle parte : partesCuerpo) {
            parte.setOpacity(0);
        }
    }

    /**
     * comprueba la entrada del usuario, si es una letra comprueba que esta en la
     * palabra oculta, si está la muestra;
     * si es una palabra comprueba que es la correcta,si lo es gana; si no es
     * ninguna de las dos
     * se resta una vida y se muestra una parte del cuerpo
     */
    @FXML
    public void adivinarOnClick() {
        String entrada = adivinarTextField.getText().trim().toLowerCase();
        adivinarTextField.clear();
        if (entrada.isEmpty()) {
            return;
        }
        if (entrada.length() == 1) {
            boolean acierto = false;
            for (int i = 0; i < palabraOculta.length(); i++) {
                if (palabraOculta.charAt(i) == entrada.charAt(0)) {
                    palabraMostrada.setCharAt(i, entrada.charAt(0));
                    acierto = true;
                }
            }
            if (acierto) {
                palabraOcultaText.setText(palabraMostrada.toString());
                if (!palabraMostrada.toString().contains("_")) {
                    ganarJuego();
                }
                return;
            }
        }
        if (entrada.equals(palabraOculta)) {
            palabraMostrada = new StringBuilder(palabraOculta);
            palabraOcultaText.setText(palabraMostrada.toString());
            ganarJuego();
            return;
        }
        perderVida();
    }

    /**
     * le resta una vida al contador de vidas del usuario
     */
    private void perderVida() {
        if (vidas > 0) {
            if (vidas == partesCuerpo.length) {
                cabeza.setOpacity(1);
            } else {
                partesCuerpo[partesCuerpo.length - vidas].setOpacity(1);
            }
            vidas--;
        }
        if (vidas == 0) {
            palabraOcultaText.setText(palabraOculta);
        }
    }

    /**
     * actualiza la informacion del usuario en la base de datos sumandole los puntos
     * correspondientes segun el nivel elegido
     */
    private void ganarJuego() {
        getUsuarioActual().setPuntos(getUsuarioActual().getPuntos() + (getUsuarioActual().getIdNivel() * 10));
        getUsuarioServiceModel().actualizarPuntos(getUsuarioActual().getUser(), getUsuarioActual().getPuntos());
        puntosText.setText(getUsuarioActual().getPuntos() + "");
    }
}