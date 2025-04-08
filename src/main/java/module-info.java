module es.nexphernandez.juego.ahorcado{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    requires javafx.graphics;

    opens es.nexphernandez.juego.ahorcado to javafx.fxml;
    exports es.nexphernandez.juego.ahorcado;
    exports es.nexphernandez.juego.ahorcado.controller;
    exports es.nexphernandez.juego.ahorcado.controller.abstractas;
    exports es.nexphernandez.juego.ahorcado.model;
    opens es.nexphernandez.juego.ahorcado.controller to javafx.fxml;
}