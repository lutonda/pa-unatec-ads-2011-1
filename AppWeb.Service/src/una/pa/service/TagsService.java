/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.service;
import una.pa.model.*;
import una.pa.repository.*;
import java.util.*;

/**
 *
 * @author Tiago
 */
public class TagsService {
    public static List<Tags> listarTags(int _id){
        return TagsDao.listarTags(_id);
    }

}
