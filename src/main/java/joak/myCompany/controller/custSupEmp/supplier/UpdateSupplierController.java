
package joak.myCompany.controller.custSupEmp.supplier;

import java.awt.Color;
import joak.myCompany.controller.custSupEmp.interfaces.UpdateController;
import joak.myCompany.model.CorrectMatches;
import joak.myCompany.model.InfoUser;
import joak.myCompany.model.TableOperator;
import joak.myCompany.view.custSupEmp.suppliers.UpdateSupplierWindow;

/**
 * Esta clase controla la ventana UpdateSupplierWindow con la que el usuario puede actualizar datos correspondientes a los proveedores.
 * @author joak
 */
public class UpdateSupplierController implements UpdateController{
    
    private final String SUPPLIER_TABLE = "suppliers";
    private final String COLUMN_CIF = "cif_pk";
    private final String COLUMN_NAME = "corporate_name";
    private final String COLUMN_SHORT_NAME = "short_name";
    private final String COLUMN_CONTACT_PERSON = "contact_person";
    private final String COLUMN_CONTACT_EMAIL = "contact_email";
    private final String COLUMN_CONTACT_TELEPHONE = "contact_telephone";
    private final String COLUMN_CONTRACT_PRICE = "contract_price";
    
    UpdateSupplierWindow updateSupplierWindow;
    TableOperator tableOperator = new TableOperator();

    public UpdateSupplierController(UpdateSupplierWindow updateSupplierWindow) {
        this.updateSupplierWindow = updateSupplierWindow;
    }

    @Override
    public void update() {

        Boolean isUpdateCif, isUpdateCorpName, isUpdateShortName, isUpdatePerson, isUpdateEmail, isUpdateTelephone, isUpdatePrice = false;
        
        String contractPrice = updateSupplierWindow.getContractPriceField().getText();
        String contactEmail = updateSupplierWindow.getContactEmailField().getText();
        String name = updateSupplierWindow.getCorporateNameField().getText();
        String shortName = updateSupplierWindow.getShortNameField().getText();
        String cifLookFor = updateSupplierWindow.getCifLookFor().getText();
        String cif = updateSupplierWindow.getCifPKField().getText();
        String contactPerson = updateSupplierWindow.getContactPersonField().getText();
        String contactTelephone = updateSupplierWindow.getContactTelephoneField().getText();
               
        Boolean correctNumber = CorrectMatches.checkNumber(contractPrice);
        Boolean correctEmail = CorrectMatches.checkEmail(contactEmail);
        
        if(!name.equals("") && !shortName.equals("") && !cif.equals("")){
            
            if(correctNumber){
                
                if(correctEmail || contactEmail.equals("")){
            
                    isUpdateCif = tableOperator.updateRow(SUPPLIER_TABLE, COLUMN_CIF, cif, COLUMN_CIF, cifLookFor);
                    isUpdateCorpName = tableOperator.updateRow(SUPPLIER_TABLE, COLUMN_NAME, name, COLUMN_CIF, cif);
                    isUpdateShortName = tableOperator.updateRow(SUPPLIER_TABLE, COLUMN_SHORT_NAME, shortName, COLUMN_CIF, cif);
                    isUpdatePerson = tableOperator.updateRow(SUPPLIER_TABLE, COLUMN_CONTACT_PERSON, contactPerson, COLUMN_CIF, cif);
                    isUpdateEmail = tableOperator.updateRow(SUPPLIER_TABLE, COLUMN_CONTACT_EMAIL, contactEmail, COLUMN_CIF, cif);
                    isUpdateTelephone = tableOperator.updateRow(SUPPLIER_TABLE, COLUMN_CONTACT_TELEPHONE, contactTelephone, COLUMN_CIF, cif);
                    isUpdatePrice = tableOperator.updateRow(SUPPLIER_TABLE, COLUMN_CONTRACT_PRICE, contractPrice, COLUMN_CIF, cif);
            
                    if(isUpdateCif == true && isUpdateCorpName == true && isUpdateShortName == true && isUpdatePerson == true && isUpdateEmail == true && isUpdateTelephone == true && isUpdatePrice == true) {
                        updateSupplierWindow.getUpdateInfoLabel().setText(InfoUser.WELL_UPDATE_COMPANY.messageInfo());
                        updateSupplierWindow.getUpdateInfoLabel().setForeground(Color.GREEN);
                    } else{
                        updateSupplierWindow.getUpdateInfoLabel().setText(InfoUser.WRONG_UPDATE.messageInfo());
                        updateSupplierWindow.getUpdateInfoLabel().setForeground(Color.RED);
                    }
                } else {
                    updateSupplierWindow.getUpdateInfoLabel().setText(InfoUser.WRONG_EMAIL.messageInfo());
                    updateSupplierWindow.getUpdateInfoLabel().setForeground(Color.RED);
                }
            } else {
                updateSupplierWindow.getUpdateInfoLabel().setText(InfoUser.WRONG_PRICE.messageInfo());
                updateSupplierWindow.getUpdateInfoLabel().setForeground(Color.RED);
            }
            
        } else {
            updateSupplierWindow.getUpdateInfoLabel().setText(InfoUser.EMPTY_NAME_CIF.messageInfo());
            updateSupplierWindow.getUpdateInfoLabel().setForeground(Color.RED);
        }
    }

    @Override
    public void search() {
        
        String cifLookFor = updateSupplierWindow.getCifLookFor().getText();
        
        String corporateName = tableOperator.selectOneComponent(COLUMN_NAME, SUPPLIER_TABLE, COLUMN_CIF, cifLookFor);
        String shortName = tableOperator.selectOneComponent(COLUMN_SHORT_NAME, SUPPLIER_TABLE, COLUMN_CIF, cifLookFor);
        String cif = tableOperator.selectOneComponent(COLUMN_CIF, SUPPLIER_TABLE, COLUMN_CIF, cifLookFor);
        String contactPerson = tableOperator.selectOneComponent(COLUMN_CONTACT_PERSON, SUPPLIER_TABLE, COLUMN_CIF, cifLookFor);
        String contactEmail = tableOperator.selectOneComponent(COLUMN_CONTACT_EMAIL, SUPPLIER_TABLE, COLUMN_CIF, cifLookFor);
        String contactTelephone = tableOperator.selectOneComponent(COLUMN_CONTACT_TELEPHONE, SUPPLIER_TABLE, COLUMN_CIF, cifLookFor);
        String contractPrice = tableOperator.selectOneComponent(COLUMN_CONTRACT_PRICE, SUPPLIER_TABLE, COLUMN_CIF, cifLookFor);
        
        updateSupplierWindow.getCorporateNameField().setText(corporateName);
        updateSupplierWindow.getShortNameField().setText(shortName);
        updateSupplierWindow.getCifPKField().setText(cif);                
        updateSupplierWindow.getContactPersonField().setText(contactPerson);
        updateSupplierWindow.getContactEmailField().setText(contactEmail);
        updateSupplierWindow.getContactTelephoneField().setText(contactTelephone);
        updateSupplierWindow.getContractPriceField().setText(contractPrice);

        if(cif.equals("") || cif == null){
            updateSupplierWindow.getUpdateInfoLabel().setText(InfoUser.CIF_NOT_FOUND_SUPPLIER.messageInfo());
            updateSupplierWindow.getUpdateInfoLabel().setForeground(Color.RED);
        } else{
            updateSupplierWindow.getUpdateInfoLabel().setText(InfoUser.BE_ABLE_TO_UPDATE_SUPPLIER.messageInfo());
            updateSupplierWindow.getUpdateInfoLabel().setForeground(Color.GREEN);
        }
        
        
    }
    
    
}
