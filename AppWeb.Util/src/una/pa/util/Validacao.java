/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tiago
 */
public class Validacao {
    public static boolean validaEmail(String  _email){

     //Set the email pattern string
     Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

     //Match the given string with the pattern
     Matcher m = p.matcher(_email);

     //check whether match is found
     boolean matchFound = m.matches();

     if (matchFound)
       return true;
     else
       return false;
  }

}
