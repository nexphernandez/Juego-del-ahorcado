package es.nexphernandez.juego.ahorcado.model.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    try (PreparedStatement sentencia = conectar().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery()) {

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

    /**
     * Funcion que actualiza los datos segun la secuencia introducida
     * @param sql sentencia a realizar
     * @param usuario datos para actualizar
     * @return true/false
     */
    public boolean actualizarDatos(String sql, UsuarioEntity usuario){
        try {
            PreparedStatement sentencia = conectar().prepareStatement(sql);
            sentencia.setString(1, usuario.getUser());
            sentencia.setString(2, usuario.getEmail());
            sentencia.setString(3, usuario.getPassword());
            sentencia.setInt(4, usuario.getPuntos());
            sentencia.setInt(5, usuario.getIdNivel());
            sentencia.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            cerrar();
        }
    }

    /**
     * Funcion para aniadir un usuario a la app
     * @param usuario a aniadir
     * @return true/false
     */
    public boolean aniadirUsuario(UsuarioEntity usuario){
        if (usuario == null) {
            return false;
        }
        String sql = "INSERT INTO usuarios (user, email, password, puntos, id_Nivel) Values (?,?,?,?,?)";
        return actualizarDatos(sql, usuario);
    }

    /**
     * Metodo para obtener los datos de un usuario por el nombre de usuario
     * @param user nombre de usuario
     * @return Usuario buscado
     */
    public UsuarioEntity obtenerUsuariosPorUser(String user){
        String sql = "SELECT * FROM usuarios WHERE user = '" + user + "'";
        ArrayList<UsuarioEntity> usuarios = leerSentencia(sql);
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(0);
    }

    /**
     * Metodo para obtener los datos de un usuario por el email
     * @param email email del usuario buscado
     * @return usuario buscado
     */
    public UsuarioEntity obtenerUsuariosPorEmail(String email){
        String sql = "SELECT * FROM usuarios WHERE email = '" + email + "'";
        ArrayList<UsuarioEntity> usuarios = leerSentencia(sql);
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(0);
    }

    /**
     * Funcion que te devuleve todos los usuarios de la base de datos
     * @return lista de usuarios
     */
    public ArrayList<UsuarioEntity> obtenerTodosLosUsuarios(){
        String sql = "SELECT * FROM usuarios";
        return leerSentencia(sql);
    }

    /**
     * Funcion para obtener una palabra segun el nivel del usuario
     * @param nombreUsuario nombre del usuarop
     * @return palabra buscada
     */
    public String obtenerPalabra (String nombreUsuario){
        String palabra = null;
        UsuarioEntity usuario = obtenerUsuariosPorUser(nombreUsuario);
        try {
            if (usuario == null) {
                throw new SQLException("No se encontro el usuario =" + nombreUsuario);
            }
            int idNivel = usuario.getIdNivel();
            String sql = "SELECT palabra FROM palabras WHERE id_nivel = ? ORDER BY RANDOM() LIMIT 1";
            PreparedStatement sentencia = conectar().prepareStatement(sql);
            sentencia.setInt(1, idNivel);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                palabra = resultado.getString("palabra");
            }
            if (palabra == null || palabra.isEmpty()) {
                throw new SQLException("No se encontro ninguna palabra para el nivel: " + idNivel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return palabra;
    }

    public void actualizarPuntos(String nombreUsuario, int nuevosPuntos){
        String sql = "UPDATE usuarios SET puntos = ? WHERE user = ?";
        try (PreparedStatement stmt = conectar().prepareStatement(sql)) {
            stmt.setInt(1, nuevosPuntos);
            stmt.setString(2, nombreUsuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
    }
}
