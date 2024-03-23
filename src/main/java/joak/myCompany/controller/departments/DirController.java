
package joak.myCompany.controller.departments;

import joak.myCompany.controller.departments.interfaces.Department;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.departments.DirWindow;


public class DirController implements Department{
    
    DirWindow dirWindow;
    TableOperator tableOperator = new TableOperator();

    public DirController(DirWindow dirWindow) {
        this.dirWindow = dirWindow;
    }

    @Override
    public void lookFor() {
        tableOperator.clearTable(dirWindow.getDataTable());
        tableOperator.selectView("direccion", dirWindow.getDataTable(), dirWindow.getVariableField().getText());
    }

    @Override
    public void showAll() {
        tableOperator.clearTable(dirWindow.getDataTable());
        tableOperator.selectView("direccion", dirWindow.getDataTable());
    }
    
}
