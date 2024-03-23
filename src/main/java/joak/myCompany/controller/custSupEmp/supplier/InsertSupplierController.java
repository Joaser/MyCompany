
package joak.myCompany.controller.custSupEmp.supplier;

import java.awt.Color;
import joak.myCompany.controller.custSupEmp.interfaces.InsertController;
import joak.myCompany.model.CorrectMatches;
import joak.myCompany.model.InfoUser;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.suppliers.InsertSupplierWindow;

/**
 * Esta clase controla la ventana InsertSupplierWindow con la que el usuario puede insertar datos correspondientes a los proveedores.
 *
 * @author joak
 */
public class InsertSupplierController implements InsertController{
    
    InsertSupplierWindow insertSupplierWindow;

    public InsertSupplierController(InsertSupplierWindow insertSupplierWindow) {
        this.insertSupplierWindow = insertSupplierWindow;
    }

     /**
     * Inserta la nueva empresa proveedor comprobando que los datos introducidos son correctos.
     */
    @Override
    public void insert() {
        
        Boolean isInsert = false;
        
        String supplierTable = "suppliers";
        String name = insertSupplierWindow.getCorporateNameField().getText();
        String shortName = insertSupplierWindow.getShortNameField().getText();
        String cif = insertSupplierWindow.getCifPKField().getText();
        String contactPerson = insertSupplierWindow.getContactPerson().getText();
        String contactEmail = insertSupplierWindow.getContactEmail().getText();
        String contactTelephone = insertSupplierWindow.getContactTelephone().getText();
        String contractPrice = insertSupplierWindow.getContractPriceField().getText();
               
        Boolean correctNumber = CorrectMatches.checkNumber(contractPrice);
        Boolean correctEmail = CorrectMatches.checkEmail(contactEmail);

        
            if(!name.equals("") && !shortName.equals("") && !cif.equals("")){
                
                if(correctNumber){
                    
                    if(correctEmail || contactEmail.equals("")) {
                        TableOperator tableOperator = new TableOperator();
                        isInsert = tableOperator.insertRow(supplierTable, name, shortName, cif, contactPerson, contactEmail, contactTelephone, contractPrice);
                        
                        if(isInsert == true) {
                            insertSupplierWindow.getInsertInfoLabel().setText(InfoUser.WELL_INSERT.messageInfo());
                            insertSupplierWindow.getInsertInfoLabel().setForeground(Color.GREEN);
                        } else {
                            insertSupplierWindow.getInsertInfoLabel().setText(InfoUser.WRONG_INSERT_COMPANY.messageInfo());
                            insertSupplierWindow.getInsertInfoLabel().setForeground(Color.RED);
                        }
                        
                    } else {
                        insertSupplierWindow.getInsertInfoLabel().setText(InfoUser.WRONG_EMAIL.messageInfo());
                        insertSupplierWindow.getInsertInfoLabel().setForeground(Color.RED);
                    }
                      
                } else {
                    insertSupplierWindow.getInsertInfoLabel().setText(InfoUser.WRONG_PRICE.messageInfo());
                    insertSupplierWindow.getInsertInfoLabel().setForeground(Color.RED);
                }
                
            } else {
                insertSupplierWindow.getInsertInfoLabel().setText(InfoUser.EMPTY_NAME_CIF.messageInfo());
                insertSupplierWindow.getInsertInfoLabel().setForeground(Color.RED);
            }
        
    }
    
    
    
}
