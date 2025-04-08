package es.nexphernandez.juego.ahorcado.model.abstractas;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Conexion {
    
    private String rutaArchivoBD;

    private Connection connection;
    
    /**
     * Cosntructor vacio
     */
    public Conexion(){}


    /**
     * Constructor con el path de la bbdd
     * @param unaRutaArchivoBD path de la bbdd
     */
    public Conexion(String unaRutaArchivoBD){
        try {
            if (unaRutaArchivoBD == null || unaRutaArchivoBD.isEmpty()) {
                throw new SQLException("el ficero no exxiste");
            }
            File file = new File(unaRutaArchivoBD);
            if (!file.exists()) {
                throw new SQLException("No existe la bbdd: " + unaRutaArchivoBD);
            }
            rutaArchivoBD = unaRutaArchivoBD;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter de la ruta de la bd
     * @return
     */
    public String getRutaArchivoBD(){
        return this.rutaArchivoBD;
    }

    /**
     * Metodo para abrir la conexion a la bbdd
     * @return conexion a la bbdd
     */
    public Connection conectar(){
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:sqlite:" + rutaArchivoBD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return this.connection;
    }

    /**
     * Metodo para cerra la coneccion a la bbdd
     */
    public void cerrar(){
        try {
            if (connection == null) {
                return;
            }
            connection.close();
            connection = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
