
package joak.myCompany.controller.accounting;

import joak.myCompany.model.TableOperator;
import joak.myCompany.view.accounting.AccountingWindow;


public class AccountingController {
    
    private final AccountingWindow accountingWindow;

    public AccountingController(AccountingWindow accountingWindow) {
        this.accountingWindow = accountingWindow;
    }
    
    public void accountingInfo (){
        
        TableOperator tableOperator = new TableOperator();
        
        String salary = tableOperator.selectOneComponent("salarios", "contabilidad", "1", "1");
        String suppliers = tableOperator.selectOneComponent("proveedores", "contabilidad", "1", "1");
        String expenses = tableOperator.selectOneComponent("gastos_totales", "contabilidad", "1", "1");
        String customers = tableOperator.selectOneComponent("clientes", "contabilidad", "1", "1");
        String benefit = tableOperator.selectOneComponent("beneficio", "contabilidad", "1", "1");
        
        accountingWindow.getSalaryField().setText(salary);
        accountingWindow.getSupplierField().setText(suppliers);
        accountingWindow.getExpensesField().setText(expenses);
        accountingWindow.getCustomersField().setText(customers);
        accountingWindow.getBenefitField().setText(benefit);
    }
    
    
    
}
