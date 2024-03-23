
package joak.myCompany.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * En Esta clase se almacenan los distintos Regex para las cifras o email y sirve para comprobar si estos
 * han sido bien introducidos por el usuario.
 *
 * @author joak
 */
public class CorrectMatches {
    
    private static final String NUMBER_REGEX = "^[0-9]+([.][0-9]+)?$";
    private static final String EMAIL_REGEX = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private CorrectMatches() {
    }
    
    /**
     * Comprueba que la estructura de la cifra que se le pase coincida con el regex para números.
     * @param number: cifra que se quiere comprobar.
     * @return Devuelve un tipo Booleano para indicar si la cifra es correcta (true) o no (false) 
     */
    public static Boolean checkNumber(String number){
        
        Pattern patternNumber = Pattern.compile(NUMBER_REGEX);
        Matcher matcherNumber = patternNumber.matcher(number);
        
        Boolean correctNumber = matcherNumber.matches();
        
        return correctNumber;
    }
    
    /**
     * Comprueba que la estructura del email que se le pase coincida con el regex para emails.
     * @param email: email que se quire comprobar.
     * @return Devuelve un tipo Booleano para indicar si el email es correcto (true) o no (false) 
     */
    public static Boolean checkEmail(String email){
        
        Pattern patternEmail = Pattern.compile(EMAIL_REGEX);
        Matcher matcherEmail = patternEmail.matcher(email);
        
        Boolean correctEmail = matcherEmail.matches();
        
        return correctEmail;
    }
    
    
}
