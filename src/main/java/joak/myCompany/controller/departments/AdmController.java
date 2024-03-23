
package joak.myCompany.controller.departments;



import joak.myCompany.controller.departments.interfaces.Department;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.departments.AdmWindow;

public class AdmController implements Department{
    
    AdmWindow admWindow;
    TableOperator tableOperator = new TableOperator();

    public AdmController(AdmWindow admWindow) {
        this.admWindow = admWindow;
    }

    @Override
    public void lookFor() {          
        tableOperator.clearTable(admWindow.getDataTable());
        tableOperator.selectView("administracion", admWindow.getDataTable(), admWindow.getVariableField().getText()); 
    }

    @Override
    public void showAll() {
        tableOperator.clearTable(admWindow.getDataTable());
        tableOperator.selectView("administracion", admWindow.getDataTable());  
    }

   
    
    
    
    
    

  
    
    


    

 
    
}
