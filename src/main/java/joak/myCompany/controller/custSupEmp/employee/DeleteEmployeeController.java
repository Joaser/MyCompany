
package joak.myCompany.controller.custSupEmp.employee;

import java.awt.Color;
import joak.myCompany.controller.custSupEmp.interfaces.DeleteController;
import joak.myCompany.model.InfoUser;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.employee.DeleteEmployeeWindow;

public class DeleteEmployeeController implements DeleteController{
    
    DeleteEmployeeWindow deleteEmployeeWindow;
    TableOperator tableOperator = new TableOperator();
    

    public DeleteEmployeeController(DeleteEmployeeWindow deleteEmployeeWindow) {
        this.deleteEmployeeWindow = deleteEmployeeWindow;
    }

    @Override
    public void search() {
        
        tableOperator.clearTable(deleteEmployeeWindow.getDataTable());
        tableOperator.selectView("empleados", deleteEmployeeWindow.getDataTable(), "dni", deleteEmployeeWindow.getDniSearchField().getText());
 
        if(deleteEmployeeWindow.getDniSearchField().getText().equals("") || deleteEmployeeWindow.getDniSearchField().getText() == null || deleteEmployeeWindow.getDataTable().getRowCount() == 0){
            deleteEmployeeWindow.getDeleteInfoLabel().setText(InfoUser.DNI_NOT_FOUND.messageInfo());
            deleteEmployeeWindow.getDeleteInfoLabel().setForeground(Color.RED);
            
        } else{

            deleteEmployeeWindow.getDeleteInfoLabel().setText(InfoUser.DELETE_EMPLOYEE.messageInfo());
            deleteEmployeeWindow.getDeleteInfoLabel().setForeground(Color.GREEN);
        }
    }

    @Override
    public void delete() {
        
        boolean isDeleted = false;
        
        if(deleteEmployeeWindow.getDniSearchField().getText().equals("") || deleteEmployeeWindow.getDniSearchField().getText() == null || deleteEmployeeWindow.getDataTable().getRowCount() == 0){
            deleteEmployeeWindow.getDeleteInfoLabel().setText(InfoUser.DNI_NOT_FOUND.messageInfo());
            deleteEmployeeWindow.getDeleteInfoLabel().setForeground(Color.RED);
            
        } else {
            isDeleted = tableOperator.deleteRow("employees", "id_pk", deleteEmployeeWindow.getDniSearchField().getText());
        }

        if(isDeleted == true) {  
            deleteEmployeeWindow.getDeleteInfoLabel().setText(InfoUser.WELL_DELETED_EMPLOYEE.messageInfo());
            deleteEmployeeWindow.getDeleteInfoLabel().setForeground(Color.GREEN);
            tableOperator.clearTable(deleteEmployeeWindow.getDataTable());
        } else{
            deleteEmployeeWindow.getDeleteInfoLabel().setText(InfoUser.WE_HAVE_A_PROBLEM.messageInfo());
            deleteEmployeeWindow.getDeleteInfoLabel().setForeground(Color.RED);
        }
    }
    
    
    
}
