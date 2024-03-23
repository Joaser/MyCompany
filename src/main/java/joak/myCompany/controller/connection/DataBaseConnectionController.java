
package joak.myCompany.controller.connection;

import java.awt.Color;
import joak.myCompany.model.DataBaseConnection;
import joak.myCompany.model.InfoUser;
import joak.myCompany.view.connection.DataBaseConnectionWindow;


public class DataBaseConnectionController {
    
    DataBaseConnectionWindow dataBaseConnectionWindow;

    public DataBaseConnectionController(DataBaseConnectionWindow dataBaseConnectionWindow) {
        
        this.dataBaseConnectionWindow = dataBaseConnectionWindow;
    }
    
    
    public void connectToDataBase(){
        
        String dock = dataBaseConnectionWindow.getDockField().getText();
        String user = dataBaseConnectionWindow.getUserField().getText();        
        String password = "";
        Boolean isConnected;
        char [] charsFromPassword = dataBaseConnectionWindow.getPasswordField().getPassword();
        
        for(char c : charsFromPassword) password = password + String.valueOf(c);
        
        DataBaseConnection.setDb(dock);
        DataBaseConnection.setUser(user);
        DataBaseConnection.setPassword(password);

        isConnected = DataBaseConnection.connectionToDataBase();
        DataBaseConnection.closeConnection(isConnected);
        
        if(isConnected == true) {
            dataBaseConnectionWindow.getInfoLabel().setText(InfoUser.CONNECTED.messageInfo());
            dataBaseConnectionWindow.getInfoLabel().setForeground(Color.GREEN);         
        }
        else {
            dataBaseConnectionWindow.getInfoLabel().setText(InfoUser.CONNECTION_FAILS.messageInfo());
            dataBaseConnectionWindow.getInfoLabel().setForeground(Color.RED);
        }
        
    }



    
}
