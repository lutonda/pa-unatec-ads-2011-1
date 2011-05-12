/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.util.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Felipe
 */
public class uploadValidator {
    
    public static boolean validar(MultipartFile multipartFile){
        
        if((multipartFile.getContentType().equals("image/jpeg")) ||
                (multipartFile.getContentType().equals("image/png"))){
            
            if(multipartFile.getSize() < 2100000){
                return true;
            }
        
    }else{
        return false;
        }
        return false;
    }
    
    
}
