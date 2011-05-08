/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.service.upload;

import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;


public class uploadServices {

    private Object multipartFile;
    private File file2;
  

    public  String fazUpload(MultipartFile multipartFile, String PATH, String URL) throws IOException, Exception {

        String fileName = "";
  
        
      if(uploadValidator.validar(multipartFile))  {
                      
        if (multipartFile != null) {
            fileName = multipartFile.getOriginalFilename();
            file2 = new File(PATH+""+Guid.getString()+"-"+fileName);
            multipartFile.transferTo(file2);
            
        }
           
       
        return URL+""+file2.getName();
        
    }
      return null;
         }  
   
}
