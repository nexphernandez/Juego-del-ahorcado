package es.nexphernandez.juego.ahorcado.controller.abstractas;
/**
 * @nexphernandez nexphernandez
 * @version 1.0.0
 */
public abstract class AbstractController {
    private String direccion = "";
    
    /**
     * Funcion para obtener la direccion guardada
     * @return direccion guardada
     */
    public String getDireccion(){
        return this.direccion;
    }

    /**
     * Metodo para modificar la direccion guardada
     * @param direccion nueva direccion
     */
    public void setDireccion(String direccion){
        this.direccion =  direccion;
    }
}
