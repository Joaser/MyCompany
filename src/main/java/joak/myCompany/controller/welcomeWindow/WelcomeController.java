
package joak.myCompany.controller.welcomeWindow;

import joak.myCompany.view.accounting.AccountingWindow;
import joak.myCompany.view.connection.DataBaseConnectionWindow;
import joak.myCompany.view.custSupEmp.customers.CustomerWindow;
import joak.myCompany.view.departments.AdmWindow;
import joak.myCompany.view.departments.DirWindow;
import joak.myCompany.view.departments.ProdWindow;
import joak.myCompany.view.departments.SalesWindow;
import joak.myCompany.view.custSupEmp.employee.EmployeeWindow;
import joak.myCompany.view.custSupEmp.suppliers.SupplierWindow;

public class WelcomeController {
    
     public static void openDirWindow(){
        
        DirWindow dirWindow = new DirWindow();
        dirWindow.setVisible(true);
    }   
    
    public static void openAdmWindow(){
        
        AdmWindow admWindow = new AdmWindow();
        admWindow.setVisible(true);
    }
    
    public static void openProdWindow(){
        
        ProdWindow prodWindow = new ProdWindow();
        prodWindow.setVisible(true);
    }
    
    public static void openSalesWindow(){
        
        SalesWindow salesWindow = new SalesWindow();
        salesWindow.setVisible(true);
    }
    
    public static void openCustomerWindow(){
        
        CustomerWindow customerWindow = new CustomerWindow();
        customerWindow.setVisible(true);
    }
    
    public static void openSupplierWindow(){
        
        SupplierWindow supplierWindow = new SupplierWindow();
        supplierWindow.setVisible(true);
    }
    
    public static void openEmployeeWindow(){
        
        EmployeeWindow employeeWindow = new EmployeeWindow();
        employeeWindow.setVisible(true);
    }
    
    public static void openAccountingWindow(){
        
        AccountingWindow accountingWindow = new AccountingWindow();
        accountingWindow.setVisible(true);
    }
    
    public static void openConnectionWindow(){
        
        DataBaseConnectionWindow dataBaseConnectionWindow = new DataBaseConnectionWindow();
        dataBaseConnectionWindow.setVisible(true);
    }
    
}


