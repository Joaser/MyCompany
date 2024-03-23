
package joak.myCompany.controller.custSupEmp.customer;

import java.awt.Color;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.customers.InsertCustomerWindow;
import joak.myCompany.controller.custSupEmp.interfaces.InsertController;
import joak.myCompany.model.CorrectMatches;
import joak.myCompany.model.InfoUser;

public class InsertCustomerController implements InsertController{
    
    InsertCustomerWindow insertCustomerWindow;

    public InsertCustomerController(InsertCustomerWindow insertCustomerWindow) {
        this.insertCustomerWindow = insertCustomerWindow;
    }

    /**
     * Inserta la nueva empresa cliente comprobando que los datos introducidos son correctos.
     */
    @Override
    public void insert() {
        
        Boolean isInsert = false;
        
        String customerTable = "customers";
        String name = insertCustomerWindow.getCorporateNameField().getText();
        String shortName = insertCustomerWindow.getShortNameField().getText();
        String cif = insertCustomerWindow.getCifPKField().getText();
        String contactPerson = insertCustomerWindow.getContactPerson().getText();
        String contactEmail = insertCustomerWindow.getContactEmail().getText();
        String contactTelephone = insertCustomerWindow.getContactTelephone().getText();
        String contractPrice = insertCustomerWindow.getContractPriceField().getText();
        
        Boolean correctNumber = CorrectMatches.checkNumber(contractPrice);
        Boolean correctEmail = CorrectMatches.checkEmail(contactEmail);

        
        if(!name.equals("") && !shortName.equals("") && !cif.equals("")){
            
            if(correctNumber == true){
                
                if (correctEmail == true || contactEmail.equals("")){
                    TableOperator tableOperator = new TableOperator();
                    isInsert = tableOperator.insertRow(customerTable, name, shortName, cif, contactPerson, contactEmail, contactTelephone, contractPrice);
                    
                    if(isInsert == true) {
                        insertCustomerWindow.getInsertInfoLabel().setText(InfoUser.WELL_INSERT.messageInfo());
                        insertCustomerWindow.getInsertInfoLabel().setForeground(Color.GREEN);
                    } else {
                        insertCustomerWindow.getInsertInfoLabel().setText(InfoUser.WRONG_INSERT_COMPANY.messageInfo());
                        insertCustomerWindow.getInsertInfoLabel().setForeground(Color.RED);
                    }
                    
                } else{
                    insertCustomerWindow.getInsertInfoLabel().setText(InfoUser.WRONG_EMAIL.messageInfo());
                    insertCustomerWindow.getInsertInfoLabel().setForeground(Color.RED);
                } 
                
            } else {
                insertCustomerWindow.getInsertInfoLabel().setText(InfoUser.WRONG_PRICE.messageInfo());
                insertCustomerWindow.getInsertInfoLabel().setForeground(Color.RED);
            }
  
        } else {
            insertCustomerWindow.getInsertInfoLabel().setText(InfoUser.EMPTY_NAME_CIF.messageInfo());
            insertCustomerWindow.getInsertInfoLabel().setForeground(Color.RED);
        }
    }
    
    
    
}
