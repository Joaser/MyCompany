
package joak.myCompany.controller.custSupEmp.supplier;

import java.awt.Color;
import joak.myCompany.controller.custSupEmp.interfaces.DeleteController;
import joak.myCompany.model.InfoUser;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.suppliers.DeleteSupplierWindow;

public class DeleteSupplierController implements DeleteController{
    
    DeleteSupplierWindow deleteSupplierWindow;
    TableOperator tableOperator = new TableOperator();

    public DeleteSupplierController(DeleteSupplierWindow deleteSupplierWindow) {
        this.deleteSupplierWindow = deleteSupplierWindow;
    }

    @Override
    public void search() {
        
        tableOperator.clearTable(deleteSupplierWindow.getDataTable());
        tableOperator.selectView("proveedores", deleteSupplierWindow.getDataTable(), "codigo_proveedor", deleteSupplierWindow.getCifLookForField().getText());
 
        if(deleteSupplierWindow.getCifLookForField().getText().equals("") || deleteSupplierWindow.getCifLookForField().getText() == null || deleteSupplierWindow.getDataTable().getRowCount() == 0){
            deleteSupplierWindow.getDeleteInfoLabel().setText(InfoUser.CIF_NOT_FOUND.messageInfo() + " SUPP ");
            deleteSupplierWindow.getDeleteInfoLabel().setForeground(Color.RED);
            
        } else{

            deleteSupplierWindow.getDeleteInfoLabel().setText(InfoUser.DELETE_COMPANY.messageInfo());
            deleteSupplierWindow.getDeleteInfoLabel().setForeground(Color.GREEN);
        }
    }

    @Override
    public void delete() {
        
        boolean isDeleted = false;
        
        if(deleteSupplierWindow.getCifLookForField().getText().equals("") || deleteSupplierWindow.getCifLookForField().getText() == null || deleteSupplierWindow.getDataTable().getRowCount() == 0){
            deleteSupplierWindow.getDeleteInfoLabel().setText(InfoUser.CIF_NOT_FOUND.messageInfo() + " SUPP ");
            deleteSupplierWindow.getDeleteInfoLabel().setForeground(Color.RED);
            
        } else {
            isDeleted = tableOperator.deleteRow("suppliers", "cif_pk", deleteSupplierWindow.getCifLookForField().getText());
        }

        if(isDeleted == true) {  
            deleteSupplierWindow.getDeleteInfoLabel().setText(InfoUser.WELL_DELETED_COMPANY.messageInfo());
            deleteSupplierWindow.getDeleteInfoLabel().setForeground(Color.GREEN);
            tableOperator.clearTable(deleteSupplierWindow.getDataTable());
        } else{
            deleteSupplierWindow.getDeleteInfoLabel().setText(InfoUser.WE_HAVE_A_PROBLEM.messageInfo());
            deleteSupplierWindow.getDeleteInfoLabel().setForeground(Color.RED);
        }
    }
    
    
    
}
