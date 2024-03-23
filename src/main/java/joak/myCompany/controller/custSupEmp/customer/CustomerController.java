
package joak.myCompany.controller.custSupEmp.customer;

import joak.myCompany.controller.custSupEmp.interfaces.PrincipalMenuController;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.customers.CustomerWindow;
import joak.myCompany.view.custSupEmp.customers.DeleteCustomerWindow;
import joak.myCompany.view.custSupEmp.customers.InsertCustomerWindow;
import joak.myCompany.view.custSupEmp.customers.UpdateCustomerWindow;


public class CustomerController implements PrincipalMenuController{
    
    private final String CUSTOMER_VW = "clientes";
    CustomerWindow customerWindow;
    TableOperator tableOperator = new TableOperator();

    public CustomerController(CustomerWindow customerWindow) {
        this.customerWindow = customerWindow;
    }

    @Override
    public void lookFor() {

        String filter = customerWindow.getVariableField().getText();
        
        tableOperator.clearTable(customerWindow.getDataTable());
        tableOperator.selectView(CUSTOMER_VW, customerWindow.getDataTable(), filter);      
    }

    @Override
    public void showAll() {
        tableOperator.clearTable(customerWindow.getDataTable());
        tableOperator.selectView(CUSTOMER_VW, customerWindow.getDataTable());
    }

    @Override
    public void delete() {
        DeleteCustomerWindow deleteCustomerWindow = new DeleteCustomerWindow();
        deleteCustomerWindow.setVisible(true);

        tableOperator.clearTable(customerWindow.getDataTable());
    }

    @Override
    public void insert() {
        InsertCustomerWindow insertCustomerWindow = new InsertCustomerWindow();
        insertCustomerWindow.setVisible(true);

        tableOperator.clearTable(customerWindow.getDataTable());
    }

    @Override
    public void update() {
        UpdateCustomerWindow updateCustomerWindow = new UpdateCustomerWindow();
        updateCustomerWindow.setVisible(true);

        tableOperator.clearTable(customerWindow.getDataTable());
    }
    
    
}
