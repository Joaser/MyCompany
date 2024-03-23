
package joak.myCompany.controller.custSupEmp.employee;

import java.awt.Color;
import java.util.ArrayList;
import joak.myCompany.controller.custSupEmp.interfaces.UpdateController;
import joak.myCompany.model.CorrectMatches;
import joak.myCompany.model.InfoUser;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.employee.UpdateEmployeeWindow;

/**
 *  Esta clase controla la ventana UpdateEmployeeWindow con la que el usuario puede actualizar datos correspondientes a los empleados.
 *
 * @author joak
 */
public class UpdateEmployeeController implements UpdateController{
    
    private final String employeeTable = "employees";
    private final String customerTable = "customers";
    private final String columnShortNameCustomer = "short_name";
    private final String departmentTable = "departments";
    private final String columnAreaDepartment = "dep_area";
    private final String positionsTable = "positions";
    
    private ArrayList <String> shortNameClient = new ArrayList<>();
    private ArrayList <String> area = new ArrayList<>();
    
    UpdateEmployeeWindow updateEmployeeWindow;

    public UpdateEmployeeController(UpdateEmployeeWindow updateEmployeeWindow) {
        this.updateEmployeeWindow = updateEmployeeWindow;
    }
    
    /**
     * Método que rellena los comboBox nada más iniciar la ventana employee. 
     * El método se inicia en el constructor de la clase UpdateEmployeeWindow
     * De esta forma el usuario puede seleccionar desde un principio el valor que considere.
     * @see UpdateEmployeeWindow
     */
    public void startFillComboBox(){

        shortNameClient.addAll(new TableOperator().selectComponents(columnShortNameCustomer, customerTable));
        area.addAll(new TableOperator().selectComponents(columnAreaDepartment, departmentTable));
        
        updateEmployeeWindow.getClientComboBox().insertItemAt("-",0);
        for(String s : shortNameClient) updateEmployeeWindow.getClientComboBox().addItem(s);
        updateEmployeeWindow.getClientComboBox().setSelectedIndex(0);
        updateEmployeeWindow.getClientComboBox().setEnabled(false);
        
        for(String s : area) updateEmployeeWindow.getAreaComboBox().addItem(s);
    }

    @Override
    public void update() {
        
        Boolean isUpdateDni, isUpdateName, isUpdateFirstSurname, isUpdateSecondSurname, isUpdateEmail, isUpdateTelephone, isUpdateCustomer, isUpdateDepartment, isUpdatePosition, isUpdateSalary = false;
        
        String columnCustomerWanted = "cif_pk";
        String columnCustomerPK = columnShortNameCustomer;
        String columnPositionWanted = "position_id_pk";
        String columnPositionPK = "position";
        String columnDepartemntWanted = "area_pk";
        String columnDepartemntPK = columnAreaDepartment;
        String dni = updateEmployeeWindow.getDNIField().getText();
        String dniLookFor = updateEmployeeWindow.getDniSearchField().getText();
        String name = updateEmployeeWindow.getNameField().getText();
        String firstSurname = updateEmployeeWindow.getFirstSurnameField().getText();
        String secondSurname = updateEmployeeWindow.getSecondSurnameField().getText();
        String contactTelephone = updateEmployeeWindow.getContactTelephone().getText();
        String contactEmail = updateEmployeeWindow.getContactEmail().getText();
        String salary = updateEmployeeWindow.getSalaryField().getText();
        String client; 
        String position;
        String department;
        
        if ((Boolean)updateEmployeeWindow.getClientComboBox().getSelectedItem().equals("-")) client = "";
        else client = new TableOperator().selectOneComponent(columnCustomerWanted, customerTable, columnCustomerPK, (String)updateEmployeeWindow.getClientComboBox().getSelectedItem());
        
        position = new TableOperator().selectOneComponent(columnPositionWanted, positionsTable, columnPositionPK, (String)updateEmployeeWindow.getPositionComboBox().getSelectedItem());
        department = new TableOperator().selectOneComponent(columnDepartemntWanted, departmentTable, columnDepartemntPK, (String)updateEmployeeWindow.getAreaComboBox().getSelectedItem());     
        
        Boolean correctNumber = CorrectMatches.checkNumber(salary);
        Boolean correctEmail = CorrectMatches.checkEmail(contactEmail);

        if(!name.equals("") && !dni.equals("") && !firstSurname.equals("") && !secondSurname.equals("")){
            
            if(correctNumber){
                
                if (correctEmail || contactEmail.equals("")){                 
                    TableOperator tableOperator = new TableOperator();
                    
                    isUpdateDni = tableOperator.updateRow(employeeTable, "id_pk", dni, "id_pk", dniLookFor);
                    isUpdateName = tableOperator.updateRow(employeeTable, "emp_name", name, "id_pk", dni);
                    isUpdateFirstSurname = tableOperator.updateRow(employeeTable, "emp_surname1", firstSurname, "id_pk", dni);
                    isUpdateSecondSurname = tableOperator.updateRow(employeeTable, "emp_surname2", secondSurname, "id_pk", dni);
                    isUpdateEmail = tableOperator.updateRow(employeeTable, "email", contactEmail, "id_pk", dni);
                    isUpdateTelephone = tableOperator.updateRow(employeeTable, "telephone", contactTelephone, "id_pk", dni);
                    isUpdateCustomer = tableOperator.updateRow(employeeTable, "customer_fk", client, "id_pk", dni);
                    isUpdateDepartment = tableOperator.updateRow(employeeTable, "area_fk", department, "id_pk", dni);
                    isUpdatePosition = tableOperator.updateRow(employeeTable, "position_fk", position, "id_pk", dni);
                    isUpdateSalary = tableOperator.updateRow(employeeTable, "salary", salary, "id_pk", dni);
                    
            
                    if(isUpdateDni == true && isUpdateName == true && isUpdateFirstSurname == true && isUpdateSecondSurname == true && isUpdateEmail == true && isUpdateTelephone == true && isUpdateCustomer == true && isUpdateDepartment == true && isUpdatePosition ==true && isUpdateSalary == true) {
                        updateEmployeeWindow.getUpdateInfoLabel().setText(InfoUser.WELL_UPDATE_EMPLOYEE.messageInfo());
                        updateEmployeeWindow.getUpdateInfoLabel().setForeground(Color.GREEN); 
                    } else{
                        updateEmployeeWindow.getUpdateInfoLabel().setText(InfoUser.WELL_UPDATE_EMPLOYEE.messageInfo());
                        updateEmployeeWindow.getUpdateInfoLabel().setForeground(Color.RED); 
                    }
                    
                } else {
                    updateEmployeeWindow.getUpdateInfoLabel().setText(InfoUser.WRONG_EMAIL.messageInfo());
                    updateEmployeeWindow.getUpdateInfoLabel().setForeground(Color.RED); 
                }
                
            } else {
                updateEmployeeWindow.getUpdateInfoLabel().setText(InfoUser.WRONG_SALARY.messageInfo());
                updateEmployeeWindow.getUpdateInfoLabel().setForeground(Color.RED); 
            }

        } else {
            updateEmployeeWindow.getUpdateInfoLabel().setText(InfoUser.EMPTY_NAME_DNI.messageInfo());
            updateEmployeeWindow.getUpdateInfoLabel().setForeground(Color.RED);
        }
    }

    @Override
    public void search() {
        
        TableOperator tableOperator = new TableOperator();
        
        String name = tableOperator.selectOneComponent("emp_name", "employees", "id_pk", updateEmployeeWindow.getDniSearchField().getText());
        String firstSurname = tableOperator.selectOneComponent("emp_surname1", "employees", "id_pk", updateEmployeeWindow.getDniSearchField().getText());
        String secondSurname = tableOperator.selectOneComponent("emp_surname2", "employees", "id_pk", updateEmployeeWindow.getDniSearchField().getText());
        String dni = tableOperator.selectOneComponent("id_pk", "employees", "id_pk", updateEmployeeWindow.getDniSearchField().getText());
        String email = tableOperator.selectOneComponent("email", "employees", "id_pk", updateEmployeeWindow.getDniSearchField().getText());
        String telephone = tableOperator.selectOneComponent("telephone", "employees", "id_pk", updateEmployeeWindow.getDniSearchField().getText());
        String customer = tableOperator.selectOneComponent("cliente", "empleados", "dni", updateEmployeeWindow.getDniSearchField().getText());
        String department = tableOperator.selectOneComponent("area", "empleados", "dni", updateEmployeeWindow.getDniSearchField().getText());
        String position = tableOperator.selectOneComponent("puesto", "empleados", "dni", updateEmployeeWindow.getDniSearchField().getText());
        String salary = tableOperator.selectOneComponent("salary", "employees", "id_pk", updateEmployeeWindow.getDniSearchField().getText());
        
        updateEmployeeWindow.getNameField().setText(name);
        updateEmployeeWindow.getFirstSurnameField().setText(firstSurname);
        updateEmployeeWindow.getSecondSurnameField().setText(secondSurname);
        updateEmployeeWindow.getDNIField().setText(dni);
        updateEmployeeWindow.getContactEmail().setText(email);
        updateEmployeeWindow.getContactTelephone().setText(telephone);
        updateEmployeeWindow.getClientComboBox().setSelectedItem(customer);
        updateEmployeeWindow.getAreaComboBox().setSelectedItem(department);
        updateEmployeeWindow.getPositionComboBox().setSelectedItem(position);
        updateEmployeeWindow.getSalaryField().setText(salary);
        
        if(updateEmployeeWindow.getDNIField().getText().equals("") || updateEmployeeWindow.getDNIField().getText() == null) {           
            updateEmployeeWindow.getUpdateInfoLabel().setText("Parece que ese DNI no se corresponde con ningún empleado.");
            updateEmployeeWindow.getUpdateInfoLabel().setForeground(Color.RED);
        } else{
            updateEmployeeWindow.getUpdateInfoLabel().setText("Modifica los campos que desees y pulsa el botón ACTUALIZAR EMPLEADO.");
            updateEmployeeWindow.getUpdateInfoLabel().setForeground(Color.GREEN);
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
            
            if((Boolean)updateEmployeeWindow.getAreaComboBox().getSelectedItem().equals(filterArea)){
                
                position.addAll(new TableOperator().selectComponents(columnWanted, view, columnPK, filterArea));
                
                updateEmployeeWindow.getPositionComboBox().removeAllItems();
                
                for(String pos : position) updateEmployeeWindow.getPositionComboBox().addItem(pos);
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
        
        if((Boolean)updateEmployeeWindow.getAreaComboBox().getSelectedItem().equals(departmentEnableClient)) updateEmployeeWindow.getClientComboBox().setEnabled(true);
        else {
            updateEmployeeWindow.getClientComboBox().setEnabled(false);
            updateEmployeeWindow.getClientComboBox().setSelectedIndex(0);
        }
    }
    
    
    
}
