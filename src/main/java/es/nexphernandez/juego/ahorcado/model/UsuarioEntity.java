package es.nexphernandez.juego.ahorcado.model;
import java.util.Objects;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class UsuarioEntity {
    private String user;
    private String email;
    private String password;
    private int puntos;
    private int idNivel;

    /**
     * Cosntructor vacio
     */
    public UsuarioEntity() {
    }

    /**
     * Constructor con los atributos
     * @param user de la clase
     * @param email de la clase
     * @param password de la clase
     */
    public UsuarioEntity(String user, String email, String password) {
        if (!email.contains("@") || !email.contains(".") ) {
            throw new ExceptionInInitializerError("El email debe tener un formato correcto");
        }
        this.user = user;
        this.email = email;
        this.password = password;
        this.puntos = 0;
        this.idNivel = 1;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (!email.contains("@") || !email.contains(".") ) {
            throw new ExceptionInInitializerError("El email debe tener un formato correcto");
        }
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getIdNivel() {
        return this.idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity usuarioEntity = (UsuarioEntity) o;
        return  Objects.equals(email, usuarioEntity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return getUser() + 
            "," + getEmail() +
            "," + getPassword() + 
            "," + getPuntos() + 
            "," + getIdNivel();
    }
    

}
