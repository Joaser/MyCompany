
package joak.myCompany.controller.custSupEmp.supplier;

import joak.myCompany.controller.custSupEmp.interfaces.PrincipalMenuController;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.suppliers.DeleteSupplierWindow;
import joak.myCompany.view.custSupEmp.suppliers.InsertSupplierWindow;
import joak.myCompany.view.custSupEmp.suppliers.SupplierWindow;
import joak.myCompany.view.custSupEmp.suppliers.UpdateSupplierWindow;

public class SupplierController implements PrincipalMenuController{
    
    private final String SUPPLIER_VW = "proveedores";
    SupplierWindow supplierWindow;
    TableOperator tableOperator = new TableOperator();

    public SupplierController(SupplierWindow supplierWindow) {
        this.supplierWindow = supplierWindow;
    }

    @Override
    public void lookFor() {
        tableOperator.clearTable(supplierWindow.getDataTable());
        tableOperator.selectView(SUPPLIER_VW, supplierWindow.getDataTable(), supplierWindow.getVariableField().getText());
    }

    @Override
    public void showAll() {
        tableOperator.clearTable(supplierWindow.getDataTable());
        tableOperator.selectView(SUPPLIER_VW, supplierWindow.getDataTable());
    }

    @Override
    public void delete() {
        DeleteSupplierWindow deleteSupplierWindow = new DeleteSupplierWindow();
        deleteSupplierWindow.setVisible(true);
        
        tableOperator.clearTable(supplierWindow.getDataTable());
    }

    @Override
    public void insert() {
        InsertSupplierWindow insertSupplierWindow = new InsertSupplierWindow();
        insertSupplierWindow.setVisible(true);
        
        tableOperator.clearTable(supplierWindow.getDataTable());
    }

    @Override
    public void update() {
        UpdateSupplierWindow updateSupplierWindow = new UpdateSupplierWindow();
        updateSupplierWindow.setVisible(true);
        
        tableOperator.clearTable(supplierWindow.getDataTable());
    }
    
    
    
}
