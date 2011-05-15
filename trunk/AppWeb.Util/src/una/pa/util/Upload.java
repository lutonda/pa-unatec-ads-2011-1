package una.pa.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Magno
 */
public class Upload {

    public static List<String> uploadImagem(HttpServletRequest request,
            HttpServletResponse response, String complete_path) {

        List<String> retorno = new ArrayList<String>();
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile file = multipartRequest.getFile("fileUploaded");
            File destination = new File(complete_path, file.getOriginalFilename());
            file.transferTo(destination);

            retorno.add(file.getOriginalFilename());
            retorno.add(complete_path);
            retorno.add(destination.getAbsolutePath());

        } catch (Exception e) {
            return null;
        }


        return retorno;
    }
}
