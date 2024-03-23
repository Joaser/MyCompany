
package joak.myCompany.model;

/**
 * Esta clase de tipo Enum almacena los mensajes con los que se informa al usuario sobre cualquiera de sus solicitudes.
 * @author joak
 */
public enum InfoUser {
    
    /**
     * <html>Notifica que se puede empezar a actualizar al cliente:<br>
     * <b>Modifica los campos que desees y pulsa el botón ACTUALIZAR CLIENTE.</b>.</html>
     */
    BE_ABLE_TO_UPDATE_CUSTOMER("Modifica los campos que desees y pulsa el botón ACTUALIZAR CLIENTE."),
    
    /**
     * <html>Notifica que se puede empezar a actualizar al cliente:<br>
     * <b>Modifica los campos que desees y pulsa el botón ACTUALIZAR PROVEEDOR</b>.</html>
     */
    BE_ABLE_TO_UPDATE_SUPPLIER("Modifica los campos que desees y pulsa el botón ACTUALIZAR PROVEEDOR."),
    
    /**
     * <html>Notifica que no se ha podido localizar una empresa con ese CIF:<br>
     * <b>Parece que ese CIF no se corresponde con ninguna empresa.<br>No olvides escribir CUST- delante del cif.</b>.</html>
     */
    CIF_NOT_FOUND("<html>Parece que ese CIF no se corresponde con ninguna empresa.<br>No olvides escribir CUST- delante del cif.</html>"),
    
    /**
     * <html>Notifica que no se ha podido localizar una empresa con ese CIF:<br>
     * <b>Parece que ese CIF no se corresponde con ninguna empresa.<br>No olvides escribir SUPP- delante del cif.</b>.</html>
     */
    CIF_NOT_FOUND_SUPPLIER("<html>Parece que ese CIF no se corresponde con ninguna empresa.<br>No olvides escribir SUPP- delante del cif.</html>"),
    
    /**
     * <html>Notifica que la conexión a la base de datos se ha realizado correctamente:<br>
     * <b>Conexión establecida a la base de datos</b></html>
     */
    CONNECTED("Conexión establecida a la base de datos"),
    
    /**
     * <html>Notifica que no se ha podido conectar correctamente a la base de datos:<br>
     * <b>No se ha podido realizar la conexión.<br>
     * Comprueba que el usuario y la contraseña sean exactos y la base de datos exista.</b></html>
     */
    CONNECTION_FAILS("<html>No se ha podido realizar la conexión.<br>Comprueba que el usuario y la contraseña sean exactos y la base de datos exista.</html>"),
    
    /**
     * <html>Notifica que se puede proceder al borrado de la empresa:<br>
     * <b>Pulsa en el botón ELIMINAR para eliminar la empresa.</b></html>
     */
    DELETE_COMPANY("<html>Pulsa en el botón ELIMINAR para eliminar la empresa.</html>"),
    
    /**
     * <html>Notifica que se puede proceder al borrado deL empleado:<br>
     * <b>Pulsa en el botón ELIMINAR para eliminar al empleado.</b></html>
     */
    DELETE_EMPLOYEE("Pulsa en el botón ELIMINAR para eliminar al empleado."),
    
    /**
     * <html>Notifica que no se ha podido localizar a un empleado con ese DNI:<br>
     * <b>Parece que ese DNI no se corresponde con ningún empleado.</b></html>
     */
    DNI_NOT_FOUND("Parece que ese DNI no se corresponde con ningún empleado."),
        
    /**
     * <html>Notifica que los campos obligatorios para una empresa están vacíos:<br>
     * <b>Los campos de nombre y cif no pueden quedar vacíos</b>.</html>
     */
    EMPTY_NAME_CIF("Los campos de nombre y cif no pueden quedar vacíos"),
    
    /**
     * <html>Notifica que los campos obligatorios para un empleado están vacíos:<br>
     * <b>Los campos de nombre y DNI no pueden quedar vacíos</b>.</html>
     */    
    EMPTY_NAME_DNI("Los campos de nombre y DNI no pueden quedar vacíos"),
    
    /**
     * <html>Notifica de la existencia de un problema:<br>
     * <b>Parece que hay un problema, pulsa buscar</b>.</html>
     */
    WE_HAVE_A_PROBLEM("Parece que hay un problema, pulsa buscar"),
    
    /**
     * <html>Notifica que la empresa ha sido eliminada correctamente:<br>
     * <b>Empresa eliminada correctamente.</b>.</html>
     */
    WELL_DELETED_COMPANY("Empresa eliminada correctamente."),
    
    /**
     * <html>Notifica que el empleado ha sido eliminado correctamente:<br>
     * <b>Empleado eliminado correctamente.</b>.</html>
     */
    WELL_DELETED_EMPLOYEE("Empleado eliminado correctamente."),
    
    /**
     * <html>Notifica que se ha insertado correctamente:<br>
     * <b>Insertado correctamente</b>.</html>
     */
    WELL_INSERT("Insertado correctamente."),
    
    /**
     * <html>Notifica que se ha actualizado una empresa correctamente:<br>
     * <b>Empresa actualizada correctamente</b>.</html>
     */
    WELL_UPDATE_COMPANY("Empresa actualizada correctamente."),
    
    /**
     * <html>Notifica que se ha actualizado un empleado correctamente:<br>
     * <b>Empleado actualizado correctamente.</b>.</html>
     */
    WELL_UPDATE_EMPLOYEE("Empleado actualizado correctamente."),
    
    /**
     * <html>Notifica que el email introducido no es correcto:<br>
     * <b>Parece que el email no es correcto, por favor corrígelo o quítalo</b>.</html>
     */
    WRONG_EMAIL("Parece que el email no es correcto, por favor corrígelo o quítalo."),
    
    /**
     * <html>Notifica que una empresa no ha podido insertarse debido a una duplicidad de clave primaria:<br>
     * <b>Parece que no se ha podido insertar... Por favor, revisa que no exista otra empresa con ese CIF</b>.</html>
     */
    WRONG_INSERT_COMPANY("Parece que no se ha podido insertar... Por favor, revisa que no exista otra empresa con ese CIF."),
    
    /**
     * <html>Notifica que un empleado no ha podido insertarse debido a una duplicidad de clave primaria:<br>
     * <b>Parece que no se ha podido insertar... Por favor, revisa que no exista otro empleado con ese DNI</b>.</html>
     */
    WRONG_INSERT_EMPLOYEE("Parece que no se ha podido insertar... Por favor, revisa que no exista otro empleado con ese DNI."),

    /**
     * <html>Notifica que el importe introducido no es correcto:<br>
     * <b>El importe tiene que seguir la estructura: 0.00</b>.</html>
     */
    WRONG_PRICE("El importe tiene que seguir la estructura: 0.00"),
    
    /**
     * <html>Notifica que el salario introducido no es correcto:<br>
     * <b>El salario tiene que seguir la estructura: 0.00</b>.</html>
     */
    WRONG_SALARY("El salario tiene que seguir la estructura: 0.00"),
    
    /**
     * <html>Notifica que no se ha podido actualizar correctamente:<br>
     * <b>Parece que ha habido un problema al actualizar, revisa todos los campos y la conexión a la base de datos</b>.</html>
     */
    WRONG_UPDATE("Parece que ha habido un problema al actualizar, revisa todos los campos y la conexión a la base de datos.")   
    ;
    
    private final String MESSAGE;
    
    private InfoUser(String message) {
        this.MESSAGE = message;
    }
    
    /**
     * Devuelve el mensaje asociado al objeto Enum seleccionado.
     * @return Devuelve un String con el mensaje asociado al objeto Enum.
     */
    public String messageInfo(){
        return MESSAGE;
    }       
    
}

