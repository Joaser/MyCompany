
package joak.myCompany.controller.custSupEmp.employee;

import java.awt.Color;
import java.util.ArrayList;
import joak.myCompany.controller.custSupEmp.interfaces.InsertController;
import joak.myCompany.model.CorrectMatches;
import joak.myCompany.model.InfoUser;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.employee.InsertEmployeeWindow;


public class InsertEmployeeController implements InsertController {
    
    private final String employeeTable = "employees";
    private final String customerTable = "customers";
    private final String columnShortNameCustomer = "short_name";
    private final String departmentTable = "departments";
    private final String columnAreaDepartment = "dep_area";
    private final String positionsTable = "positions";
    
    private ArrayList <String> shortNameClient = new ArrayList<>();
    private ArrayList <String> area = new ArrayList<>();
    InsertEmployeeWindow insertEmployeeWindow;

    public InsertEmployeeController(InsertEmployeeWindow insertEmployeeWindow) {
        this.insertEmployeeWindow = insertEmployeeWindow;
    }
    
    /**
     * Método que rellena los comboBox nada más iniciar la ventana employee. 
     * El método se inicia en el constructor de la clase InsertEmployeeWindow
     * De esta forma el usuario puede seleccionar desde un principio el valor que considere.
     * @see InsertEmployeeWindow
     */
    public void startFillComboBox(){

        shortNameClient.addAll(new TableOperator().selectComponents(columnShortNameCustomer, customerTable));
        area.addAll(new TableOperator().selectComponents(columnAreaDepartment, departmentTable));
        
        insertEmployeeWindow.getClientComboBox().insertItemAt("-",0);
        for(String s : shortNameClient) insertEmployeeWindow.getClientComboBox().addItem(s);
        insertEmployeeWindow.getClientComboBox().setSelectedIndex(0);
        insertEmployeeWindow.getClientComboBox().setEnabled(false);
        
        for(String s : area) insertEmployeeWindow.getAreaComboBox().addItem(s);
    }

    @Override
    public void insert() {
        
        Boolean isInsert = false;
        
        String columnCustomerWanted = "cif_pk";
        String columnCustomerPK = columnShortNameCustomer;
        String columnPositionWanted = "position_id_pk";
        String columnPositionPK = "position";
        String columnDepartemntWanted = "area_pk";
        String columnDepartemntPK = columnAreaDepartment;
        String dni = insertEmployeeWindow.getDNIField().getText();
        String name = insertEmployeeWindow.getNameField().getText();
        String firstSurname = insertEmployeeWindow.getFirstSurnameField().getText();
        String secondSurname = insertEmployeeWindow.getSecondSurnameField().getText();
        String contactTelephone = insertEmployeeWindow.getContactTelephone().getText();
        String contactEmail = insertEmployeeWindow.getContactEmail().getText();
        String salary = insertEmployeeWindow.getSalaryField().getText();
        String client; 
        String position;
        String department;

        if ((Boolean)insertEmployeeWindow.getClientComboBox().getSelectedItem().equals("-")) client = "";
        else client = new TableOperator().selectOneComponent(columnCustomerWanted, customerTable, columnCustomerPK, (String)insertEmployeeWindow.getClientComboBox().getSelectedItem());
        
        position = new TableOperator().selectOneComponent(columnPositionWanted, positionsTable, columnPositionPK, (String)insertEmployeeWindow.getPositionComboBox().getSelectedItem());
        department = new TableOperator().selectOneComponent(columnDepartemntWanted, departmentTable, columnDepartemntPK, (String)insertEmployeeWindow.getAreaComboBox().getSelectedItem());     
        
        Boolean correctNumber = CorrectMatches.checkNumber(salary);
        Boolean correctEmail = CorrectMatches.checkEmail(contactEmail);

        if(!name.equals("") && !dni.equals("") && !firstSurname.equals("") && !secondSurname.equals("")){
            
            if(correctNumber){
                
                if (correctEmail || contactEmail.equals("")){                 
                    TableOperator tableOperator = new TableOperator();
                    isInsert = tableOperator.insertRow(employeeTable, dni, name, firstSurname, secondSurname, contactEmail, contactTelephone, salary, client, position, department);
            
                    if(isInsert == true) {
                        insertEmployeeWindow.getInsertInfoLabel().setText(InfoUser.WELL_INSERT.messageInfo());
                        insertEmployeeWindow.getInsertInfoLabel().setForeground(Color.GREEN); 
                    } else{
                        insertEmployeeWindow.getInsertInfoLabel().setText(InfoUser.WRONG_INSERT_EMPLOYEE.messageInfo());
                        insertEmployeeWindow.getInsertInfoLabel().setForeground(Color.RED); 
                    }
                    
                } else {
                    insertEmployeeWindow.getInsertInfoLabel().setText(InfoUser.WRONG_EMAIL.messageInfo());
                    insertEmployeeWindow.getInsertInfoLabel().setForeground(Color.RED); 
                }
                
            } else {
                insertEmployeeWindow.getInsertInfoLabel().setText(InfoUser.WRONG_SALARY.messageInfo());
                insertEmployeeWindow.getInsertInfoLabel().setForeground(Color.RED); 
            }

        } else {
            insertEmployeeWindow.getInsertInfoLabel().setText(InfoUser.EMPTY_NAME_DNI.messageInfo());
            insertEmployeeWindow.getInsertInfoLabel().setForeground(Color.RED);
        }
    }
    
    /**
     * Método que rellena el comboBox de posiciones en función del departamento/área seleccionada.
     */
    public void fillPosition(){
        
        String view = "puestos";
        String columnWanted = "puesto";
        String columnPK = "area";
        
        ArrayList <String> position = new ArrayList();
        
        for(String filterArea : area) {
            
            if((Boolean)insertEmployeeWindow.getAreaComboBox().getSelectedItem().equals(filterArea)){
                
                position.addAll(new TableOperator().selectComponents(columnWanted, view, columnPK, filterArea));
                
                insertEmployeeWindow.getPositionComboBox().removeAllItems();
                
                for(String pos : position) insertEmployeeWindow.getPositionComboBox().addItem(pos);
            }
        }
        
        /*
        
        if((Boolean)areaComboBox.getSelectedItem().equals("DIRECCION")) {
            positionComboBox.removeAllItems();
            positionComboBox.insertItemAt("CEO", 0);
            positionComboBox.insertItemAt("SUBDIRECTOR", 1);
         */   
    }
    
    /**
     * Método que habilita la opción de poder asignar un cliente en función del departamento/área seleccionado
     */
    public void enableClientSelection(){
        
        String departmentEnableClient = "PRODUCCION";
        
        if((Boolean)insertEmployeeWindow.getAreaComboBox().getSelectedItem().equals(departmentEnableClient)) insertEmployeeWindow.getClientComboBox().setEnabled(true);
        else {
            insertEmployeeWindow.getClientComboBox().setEnabled(false);
            insertEmployeeWindow.getClientComboBox().setSelectedIndex(0);
        }
    }
    
    
    
}
