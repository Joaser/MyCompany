
package joak.myCompany.controller.custSupEmp.customer;

import java.awt.Color;
import joak.myCompany.controller.custSupEmp.interfaces.UpdateController;
import joak.myCompany.model.CorrectMatches;
import joak.myCompany.model.InfoUser;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.customers.UpdateCustomerWindow;

/**
 *
 * @author joase
 */
public class UpdateCustomerController implements UpdateController{
    
    private final String CUSTOMER_TABLE = "customers";
    private final String COLUMN_CIF = "cif_pk";
    private final String COLUMN_NAME = "corporate_name";
    private final String COLUMN_SHORT_NAME = "short_name";
    private final String COLUMN_CONTACT_PERSON = "contact_person";
    private final String COLUMN_CONTACT_EMAIL = "contact_email";
    private final String COLUMN_CONTACT_TELEPHONE = "contact_telephone";
    private final String COLUMN_CONTRACT_PRICE = "contract_price";
    
    UpdateCustomerWindow updateCustomerWindow;
    TableOperator tableOperator = new TableOperator();

    public UpdateCustomerController(UpdateCustomerWindow updateCustomerWindow) {
        this.updateCustomerWindow = updateCustomerWindow;
    }

    @Override
    public void update() {
        
        Boolean isUpdateCif, isUpdateCorpName, isUpdateShortName, isUpdatePerson, isUpdateEmail, isUpdateTelephone, isUpdatePrice = false;

        String contractPrice = updateCustomerWindow.getContractPriceField().getText();
        String contactEmail = updateCustomerWindow.getContactEmailField().getText();
        String name = updateCustomerWindow.getCorporateNameField().getText();
        String shortName = updateCustomerWindow.getShortNameField().getText();
        String cifLookFor = updateCustomerWindow.getCifLookFor().getText();
        String cif = updateCustomerWindow.getCifPKField().getText();
        String contactPerson = updateCustomerWindow.getContactPersonField().getText();
        String contactTelephone = updateCustomerWindow.getContactTelephoneField().getText();
        
        Boolean correctNumber = CorrectMatches.checkNumber(contractPrice);
        Boolean correctEmail = CorrectMatches.checkEmail(contactEmail);
        
        if(!name.equals("") && !shortName.equals("") && !cif.equals("")){
            
            if(correctNumber == true){
                
                if(correctEmail == true || contactEmail.equals("")){

                    isUpdateCif = tableOperator.updateRow(CUSTOMER_TABLE, COLUMN_CIF, cif, COLUMN_CIF, cifLookFor);
                    isUpdateCorpName = tableOperator.updateRow(CUSTOMER_TABLE, COLUMN_NAME, name, COLUMN_CIF, cif);
                    isUpdateShortName = tableOperator.updateRow(CUSTOMER_TABLE, COLUMN_SHORT_NAME, shortName, COLUMN_CIF, cif);
                    isUpdatePerson = tableOperator.updateRow(CUSTOMER_TABLE, COLUMN_CONTACT_PERSON, contactPerson, COLUMN_CIF, cif);
                    isUpdateEmail = tableOperator.updateRow(CUSTOMER_TABLE, COLUMN_CONTACT_EMAIL, contactEmail, COLUMN_CIF, cif);
                    isUpdateTelephone = tableOperator.updateRow(CUSTOMER_TABLE, COLUMN_CONTACT_TELEPHONE, contactTelephone, COLUMN_CIF, cif);
                    isUpdatePrice = tableOperator.updateRow(CUSTOMER_TABLE, COLUMN_CONTRACT_PRICE, contractPrice, COLUMN_CIF, cif);
                
                    if(isUpdateCif == true && isUpdateCorpName == true && isUpdateShortName == true && isUpdatePerson == true && isUpdateEmail == true && isUpdateTelephone == true && isUpdatePrice == true) {
                       updateCustomerWindow.getUpdateInfoLabel().setText(InfoUser.WELL_UPDATE_COMPANY.messageInfo());
                       updateCustomerWindow.getUpdateInfoLabel().setForeground(Color.GREEN);
                    } else {
                       updateCustomerWindow.getUpdateInfoLabel().setText(InfoUser.WRONG_UPDATE.messageInfo());
                       updateCustomerWindow.getUpdateInfoLabel().setForeground(Color.RED);
                    }
                
                } else {
                    updateCustomerWindow.getUpdateInfoLabel().setText(InfoUser.WRONG_EMAIL.messageInfo());
                    updateCustomerWindow.getUpdateInfoLabel().setForeground(Color.RED);
                }
            
            } else {
                updateCustomerWindow.getUpdateInfoLabel().setText(InfoUser.WRONG_PRICE.messageInfo());
                updateCustomerWindow.getUpdateInfoLabel().setForeground(Color.RED);
            }
            
        } else {
            updateCustomerWindow.getUpdateInfoLabel().setText(InfoUser.EMPTY_NAME_CIF.messageInfo());
            updateCustomerWindow.getUpdateInfoLabel().setForeground(Color.RED);
        }
    }

    @Override
    public void search() {
        
        String cifLookFor = updateCustomerWindow.getCifLookFor().getText();
        
        String corporateName = tableOperator.selectOneComponent(COLUMN_NAME, CUSTOMER_TABLE, COLUMN_CIF, cifLookFor);
        String shortName = tableOperator.selectOneComponent(COLUMN_SHORT_NAME, CUSTOMER_TABLE, COLUMN_CIF, cifLookFor);
        String cif = tableOperator.selectOneComponent(COLUMN_CIF, CUSTOMER_TABLE, COLUMN_CIF, cifLookFor);
        String contactPerson = tableOperator.selectOneComponent(COLUMN_CONTACT_PERSON, CUSTOMER_TABLE, COLUMN_CIF, cifLookFor);
        String contactEmail = tableOperator.selectOneComponent(COLUMN_CONTACT_EMAIL, CUSTOMER_TABLE, COLUMN_CIF, cifLookFor);
        String contactTelephone = tableOperator.selectOneComponent(COLUMN_CONTACT_TELEPHONE, CUSTOMER_TABLE, COLUMN_CIF, cifLookFor);
        String contractPrice = tableOperator.selectOneComponent(COLUMN_CONTRACT_PRICE, CUSTOMER_TABLE, COLUMN_CIF, cifLookFor);
        
        updateCustomerWindow.getCorporateNameField().setText(corporateName);
        updateCustomerWindow.getShortNameField().setText(shortName);
        updateCustomerWindow.getCifPKField().setText(cif);                
        updateCustomerWindow.getContactPersonField().setText(contactPerson);
        updateCustomerWindow.getContactEmailField().setText(contactEmail);
        updateCustomerWindow.getContactTelephoneField().setText(contactTelephone);
        updateCustomerWindow.getContractPriceField().setText(contractPrice);
        
        if(cif.equals("") || cif == null) {
            updateCustomerWindow.getUpdateInfoLabel().setText(InfoUser.CIF_NOT_FOUND.messageInfo());
            updateCustomerWindow.getUpdateInfoLabel().setForeground(Color.RED);
        } else{
            updateCustomerWindow.getUpdateInfoLabel().setText(InfoUser.BE_ABLE_TO_UPDATE_CUSTOMER.messageInfo());
            updateCustomerWindow.getUpdateInfoLabel().setForeground(Color.GREEN);
        }
    }
    
    
    
}
