
package joak.myCompany.controller.custSupEmp.employee;

import joak.myCompany.controller.custSupEmp.interfaces.PrincipalMenuController;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.employee.DeleteEmployeeWindow;
import joak.myCompany.view.custSupEmp.employee.EmployeeWindow;
import joak.myCompany.view.custSupEmp.employee.InsertEmployeeWindow;
import joak.myCompany.view.custSupEmp.employee.UpdateEmployeeWindow;

public class EmployeeController implements PrincipalMenuController {

    private final String EMPLOYEE_VW = "empleados";
    EmployeeWindow employeeWindow;
    TableOperator tableOperator = new TableOperator();

    public EmployeeController(EmployeeWindow employeeWindow) {
        this.employeeWindow = employeeWindow;
    }

    @Override
    public void lookFor() {
        tableOperator.clearTable(employeeWindow.getDataTable());
        tableOperator.selectView(EMPLOYEE_VW, employeeWindow.getDataTable(), employeeWindow.getVariableField().getText());
    }

    @Override
    public void showAll() {
        tableOperator.clearTable(employeeWindow.getDataTable());
        tableOperator.selectView(EMPLOYEE_VW, employeeWindow.getDataTable());
    }

    @Override
    public void delete() {
        DeleteEmployeeWindow deleteEmployeeWindow = new DeleteEmployeeWindow();
        deleteEmployeeWindow.setVisible(true);

        tableOperator.clearTable(employeeWindow.getDataTable()); 
    }

    @Override
    public void insert() { 
        InsertEmployeeWindow insertEmployeeWindow = new InsertEmployeeWindow();
        insertEmployeeWindow.setVisible(true);

        tableOperator.clearTable(employeeWindow.getDataTable());   
    }

    @Override
    public void update() {  
        UpdateEmployeeWindow updateEmployeeWindow = new UpdateEmployeeWindow();
        updateEmployeeWindow.setVisible(true);

        tableOperator.clearTable(employeeWindow.getDataTable());   
    }
    
    
}
