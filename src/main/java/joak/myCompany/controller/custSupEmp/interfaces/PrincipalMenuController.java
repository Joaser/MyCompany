
package joak.myCompany.controller.custSupEmp.interfaces;



public interface PrincipalMenuController {
    
    /**
     * Busca en la tabla de la base de datos todos aquellos registros que contienen parte o totalmente de una variable dada.
     * Muestra el resultado en la tabla que ve el usuario.
     */
    public void lookFor();
    
    /**
     * Muestra todos los datos de una tabla en la base de datos en la tabla que se muestra al usuario
     */
    public void showAll();
    
    /**
     * Abre la ventana para borrar un elemento
     */
    public void delete();

    /**
     * Abre la ventana para insertar un elemento
     */
    public void insert();
    
    /**
     * Abre la ventana para actualizar un elemento
     */
    public void update();
    
}
