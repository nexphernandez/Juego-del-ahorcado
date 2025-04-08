package es.nexphernandez.juego.ahorcado.model.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import es.nexphernandez.juego.ahorcado.model.UsuarioEntity;
import es.nexphernandez.juego.ahorcado.model.abstractas.Conexion;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class UsuarioServiceModel extends Conexion {

    /**
     * Constructor vacio
     */
    public UsuarioServiceModel() {
    }
    
    /**
     * Constructor con la ruta de la bbdd
     * @param unaRutaArchivoBD ruta de la bbdd
     */
    public UsuarioServiceModel(String unaRutaArchivoBD) {
        super(unaRutaArchivoBD);
    }

    /**
     * Funcion que ejecuta la sentencia introducida
     * @param sql sentencia a ejecutar
     * @return lista de usuarios de la sentencia introducida 
     */
    public ArrayList<UsuarioEntity> leerSentencia(String sql){
        ArrayList<UsuarioEntity> usuarios = new ArrayList<>();
        try {
            PreparedStatement sentencia = conectar().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
    
            while (resultado.next()) {
                String userStr = resultado.getString("user");
                String emailStr = resultado.getString("email");
                String passwordStr = resultado.getString("password");
        
                UsuarioEntity usuario = new UsuarioEntity(userStr, emailStr, passwordStr);
                usuarios.add(usuario);
            }
        } catch (Exception e) { 
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return usuarios;
    }


}
