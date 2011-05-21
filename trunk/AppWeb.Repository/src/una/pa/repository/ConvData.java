/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvData{

   public static String parseDataBra(String dataIso)
   {
      SimpleDateFormat formatIso = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat formatBra = new SimpleDateFormat("dd/MM/yyyy");
      try
      {
         Date date = formatIso.parse(dataIso);
         return(formatBra.format(date));
      }
      catch(ParseException e)
      {
         return("Parse Date Error");
      }
   }
}