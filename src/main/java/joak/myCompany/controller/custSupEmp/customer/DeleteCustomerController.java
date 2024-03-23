
package joak.myCompany.controller.custSupEmp.customer;

import java.awt.Color;
import joak.myCompany.controller.custSupEmp.interfaces.DeleteController;
import joak.myCompany.model.InfoUser;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.customers.DeleteCustomerWindow;

public class DeleteCustomerController implements DeleteController{
    
    DeleteCustomerWindow deleteCustomerWindow;
    TableOperator tableOperator = new TableOperator();

    public DeleteCustomerController(DeleteCustomerWindow deleteCustomerWindow) {
        this.deleteCustomerWindow = deleteCustomerWindow;
    }

    @Override
    public void search() {
        
        tableOperator.clearTable(deleteCustomerWindow.getDataTable());
        tableOperator.selectView("clientes", deleteCustomerWindow.getDataTable(), "codigo_cliente", deleteCustomerWindow.getCifLookForField().getText());
 
        if(deleteCustomerWindow.getCifLookForField().getText().equals("") || deleteCustomerWindow.getCifLookForField().getText() == null || deleteCustomerWindow.getDataTable().getRowCount() == 0){
            deleteCustomerWindow.getDeleteInfoLabel().setText(InfoUser.CIF_NOT_FOUND.messageInfo());
            deleteCustomerWindow.getDeleteInfoLabel().setForeground(Color.RED);
            
        } else{

            deleteCustomerWindow.getDeleteInfoLabel().setText(InfoUser.DELETE_COMPANY.messageInfo());
            deleteCustomerWindow.getDeleteInfoLabel().setForeground(Color.GREEN);
        }
        
    }

    @Override
    public void delete() {
        
        boolean isDeleted = false;
        
        if(deleteCustomerWindow.getCifLookForField().getText().equals("") || deleteCustomerWindow.getCifLookForField().getText() == null || deleteCustomerWindow.getDataTable().getRowCount() == 0){
            deleteCustomerWindow.getDeleteInfoLabel().setText(InfoUser.CIF_NOT_FOUND.messageInfo());
            deleteCustomerWindow.getDeleteInfoLabel().setForeground(Color.RED);
            
        } else {
            isDeleted = tableOperator.deleteRow("customers", "cif_pk", deleteCustomerWindow.getCifLookForField().getText());
        }

        if(isDeleted == true) {  
            deleteCustomerWindow.getDeleteInfoLabel().setText(InfoUser.WELL_DELETED_COMPANY.messageInfo());
            deleteCustomerWindow.getDeleteInfoLabel().setForeground(Color.GREEN);
            tableOperator.clearTable(deleteCustomerWindow.getDataTable());
        } else{
            deleteCustomerWindow.getDeleteInfoLabel().setText(InfoUser.WE_HAVE_A_PROBLEM.messageInfo());
            deleteCustomerWindow.getDeleteInfoLabel().setForeground(Color.RED);
        }
        
    }
    
    
    
}
