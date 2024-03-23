
package joak.myCompany.controller.departments;

import joak.myCompany.controller.departments.interfaces.Department;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.departments.SalesWindow;


public class SalesController implements Department{
    
    SalesWindow salesWindow;
    TableOperator tableOperator = new TableOperator();

    public SalesController(SalesWindow salesWindow) {
        this.salesWindow = salesWindow;
    }
    
    @Override
    public void lookFor() {
        tableOperator.clearTable(salesWindow.getDataTable());
        tableOperator.selectView("ventas", salesWindow.getDataTable(), salesWindow.getVariableField().getText());
    }

    @Override
    public void showAll() {
        tableOperator.clearTable(salesWindow.getDataTable());
        tableOperator.selectView("ventas", salesWindow.getDataTable());
    }
    
}
