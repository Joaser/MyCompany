
package joak.myCompany.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableOperator {
    
    private static DefaultTableModel dtm;
    private ResultSet resultSet;
   
    public void selectView (String viewName, JTable table){

        dtm = (DefaultTableModel) table.getModel();
        String [] columns = new String [dtm.getColumnCount()];
        
        DataBaseConnection.connectionToDataBase();
        
        try {
            
            resultSet = DataBaseConnection.getStatement().executeQuery("SELECT * FROM " + viewName + ";");

            while(resultSet.next()) {
                
                for(int i = 0; i < columns.length; i++) columns[i] = resultSet.getString(i+1);
                
                dtm.addRow(columns);
            }
            
            table.setModel(dtm);
            
            DataBaseConnection.closeConnection(resultSet);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void selectView (String viewName, JTable table, String filter){
        
        String whereFilter = "";
        dtm = (DefaultTableModel) table.getModel();
        String [] columns = new String [dtm.getColumnCount()];
        
        for(int i = 0; i < columns.length; i++){
            whereFilter = whereFilter + table.getColumnName(i) + " LIKE '%" + filter + "%' OR ";
        }
        
        whereFilter = whereFilter.substring(0, whereFilter.length()-4);
        
        DataBaseConnection.connectionToDataBase();
        
        try {
            
            resultSet = DataBaseConnection.getStatement().executeQuery("SELECT * FROM " + viewName + " WHERE " + whereFilter + ";"); 
            
            while(resultSet.next()) {
                
                for(int i = 0; i < columns.length; i++) columns[i] = resultSet.getString(i+1);
                
                dtm.addRow(columns);
            }
            
            table.setModel(dtm);

            DataBaseConnection.closeConnection(resultSet);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void selectView (String viewName, JTable table, String columnPK, String filter){
        
        dtm = (DefaultTableModel) table.getModel();
        String [] columns = new String [dtm.getColumnCount()];

        String query = "SELECT * FROM " + viewName + " WHERE " + columnPK + " = '" + filter + "';";
        
        DataBaseConnection.connectionToDataBase();
        
        System.out.println(query);
        
        try {
            
            resultSet = DataBaseConnection.getStatement().executeQuery(query); 
            
            while(resultSet.next()) {
                
                for(int i = 0; i < columns.length; i++) columns[i] = resultSet.getString(i+1);
                
                dtm.addRow(columns);
            }
            
            table.setModel(dtm);

            DataBaseConnection.closeConnection(resultSet);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * La función devuelve un único registro de la columna de una tabla filtrado por un valor de otra columna que actúa como clave primaria.
     * @param column: columna de la que se quieren obtener los valores.
     * @param table: tabla a la que pertenece la columna.
     * @param columnPK: columna de la tabla que actúa como clave primaria.
     * @param filter: valor que se utiliza para filtrar por clave primaria los valores deseados.
     * @return Valor correspondiente a la columna seleccionada de la tabla como un String. 
     */
    public String selectOneComponent (String column, String table, String columnPK, String filter){
        
        String columnInfo = ""; 
        String query = "SELECT " + column + " FROM " + table + " WHERE " + columnPK + " = '" + filter + "';";
        System.out.println(query);

        DataBaseConnection.connectionToDataBase();
        
        try {
            
            resultSet = DataBaseConnection.getStatement().executeQuery(query);
            
            while(resultSet.next()) columnInfo = resultSet.getString(1);
 
            DataBaseConnection.closeConnection(resultSet);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return columnInfo;
    }
    
    public ArrayList selectComponents (String column, String table){
        
        ArrayList result = new ArrayList(); 
        String query = "SELECT " + column + " FROM " + table + ";";

        DataBaseConnection.connectionToDataBase();
        
        try {
            
            resultSet = DataBaseConnection.getStatement().executeQuery(query);
            
            while(resultSet.next()) result.add(resultSet.getString(1));

            DataBaseConnection.closeConnection(resultSet);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    /**
     * La función devuelve todos los registros de la columna de una tabla filtrado por un valor de otra columna que actúa como clave primaria. 
     * @param column: columna de la que se quieren obtener los valores. 
     * @param table: tabla a la que pertenece la columna.
     * @param columnPK: columna de la tabla que actúa como clave primaria.
     * @param filter: valor que se utiliza para filtrar por clave primaria los valores deseados.
     * @return Se devuelven todos los valores de la columna como un ArrayList
     */
    public ArrayList selectComponents (String column, String table, String columnPK, String filter){
        
        ArrayList result = new ArrayList(); 
        String query = "SELECT " + column + " FROM " + table + " WHERE " + columnPK + " = '" + filter + "';";

        DataBaseConnection.connectionToDataBase();
        
        try {
            
            resultSet = DataBaseConnection.getStatement().executeQuery(query);
            
            while(resultSet.next()) result.add(resultSet.getString(1));

            DataBaseConnection.closeConnection(resultSet);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    /**
     * Método que elimina todas las filas de un componente JTable
     * @param table JTable del que se desean eliminar todas las filas
     */
    public void clearTable(JTable table){
        
       int rowCount = table.getRowCount();       
        
       for(int i=0; i<rowCount; i++ ) dtm.removeRow(0);
    }   
    
    
    public boolean deleteRow(String table, String idColumn, String id){
        
       boolean isDeleted = false;
               
       boolean isConnected = DataBaseConnection.connectionToDataBase(); 
       
       String query = "DELETE FROM " + table + " WHERE " + idColumn + " = '" + id + "';";
       
        System.out.println(query);
       
       try {
           
           DataBaseConnection.getStatement().executeUpdate(query); 
           
           isDeleted = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            
            isDeleted = false;
        }
       
       DataBaseConnection.closeConnection(isConnected);
       
       return isDeleted;
       
    }  
    

    public boolean insertRow(String table, String corporateName, String shortName, String cifPK, String contactPerson, String contactEmail, String contactTelephone, String contractPrice){
        
       boolean isInserted = false;
       
       boolean isConnected = DataBaseConnection.connectionToDataBase(); 
       
       if(corporateName.equalsIgnoreCase("")) corporateName = null;
       else corporateName = "'" + corporateName + "'";
       
       if(shortName.equalsIgnoreCase("")) shortName = null;
       else shortName = "'" + shortName + "'";
       
       if(cifPK.equalsIgnoreCase("")) cifPK = null;
       else cifPK = "'" + cifPK + "'";
       
       if(contactPerson.equalsIgnoreCase("")) contactPerson = null;
       else contactPerson = "'" + contactPerson + "'";
       
       if(contactEmail.equalsIgnoreCase("")) contactEmail = null;
       else contactEmail = "'" + contactEmail + "'";
       
       if(contactTelephone.equalsIgnoreCase("")) contactTelephone = null;
       else contactTelephone = "'" + contactTelephone + "'";
              
       if(contractPrice.equalsIgnoreCase("")) contractPrice = null;
       
       String query = "INSERT INTO  " + table + " VALUES (" + corporateName +  "," + shortName +  "," + cifPK +  "," + contactPerson +  "," + contactEmail +  "," + contactTelephone +  "," + contractPrice + ");";
       System.out.println(query);
       try {
           
           DataBaseConnection.getStatement().executeUpdate(query); 
           
           isInserted = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            
            isInserted = false;
        }
       
       DataBaseConnection.closeConnection(isConnected);
       
       return isInserted;
       
    }  
    
    public boolean insertRow(String table, String dni, String name, String firstSurname, String secondSurname, String contactEmail, String contactTelephone, String salary, String customer, String position, String area){
        
       boolean isInserted = false;
       
       boolean isConnected = DataBaseConnection.connectionToDataBase(); 
       
       dni = "'" + dni + "'";
       
       name = "'" + name + "'";
       
       firstSurname = "'" + firstSurname + "'";
       
       secondSurname = "'" + secondSurname + "'";
       
       contactEmail = "'" + contactEmail + "'";
       
       contactTelephone = "'" + contactTelephone + "'";
              
       if(customer.equalsIgnoreCase("")) customer = null;
       else customer = "'" + customer + "'";
       
       if(position.equalsIgnoreCase("")) position = null;
       else position = "'" + position + "'";
       
       if(area.equalsIgnoreCase("")) area = null;
       else area = "'" + area + "'";
       
       String query = "INSERT INTO  " + table + " VALUES (" + dni +  "," + name +  "," + firstSurname +  "," + secondSurname +  "," + contactEmail +  "," + contactTelephone +  "," + salary + "," + customer + "," + position + "," + area + ");";
       System.out.println(query);
       try {
           
           DataBaseConnection.getStatement().executeUpdate(query); 
           
           isInserted = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            
            isInserted = false;
        }
       
       DataBaseConnection.closeConnection(isConnected);
       
       return isInserted;
       
    }  
    
    
    public Boolean updateRow(String table, String column, String newValue, String columnPK, String pk){
        
       boolean isUpdated = false;
               
       boolean isConnected = DataBaseConnection.connectionToDataBase();
       
       if (newValue.equalsIgnoreCase("")) newValue = null;
       else newValue = "'" + newValue + "'";
       
       String query = "UPDATE " + table + " SET " + column + " = " + newValue + " WHERE " + columnPK + " = '" + pk + "';";
       
       System.out.println(query);
       
       try {
           
           DataBaseConnection.getStatement().executeUpdate(query); 
           
           isUpdated = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            
            isUpdated = false;
        }
       
       DataBaseConnection.closeConnection(isConnected);
       
       return isUpdated;
       
    }  
    
    
}
