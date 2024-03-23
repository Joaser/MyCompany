
package joak.myCompany.controller.departments;

import joak.myCompany.controller.departments.interfaces.Department;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.departments.ProdWindow;


public class ProdController implements Department{
    
    ProdWindow prodWindow;
    TableOperator tableOperator = new TableOperator();

    public ProdController(ProdWindow prodWindow) {
        this.prodWindow = prodWindow;
    }
    
    @Override
    public void lookFor() {
        tableOperator.clearTable(prodWindow.getDataTable());
        tableOperator.selectView("produccion", prodWindow.getDataTable(), prodWindow.getVariableField().getText());
    }

    @Override
    public void showAll() {
        tableOperator.clearTable(prodWindow.getDataTable());
        tableOperator.selectView("produccion", prodWindow.getDataTable());       
    }
    
}
