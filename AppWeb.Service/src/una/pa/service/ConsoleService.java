/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.service;

import una.pa.model.Console;
import una.pa.repository.*;
import java.util.*;


/**
 *
 * @author Magno
 */
public class ConsoleService {

    public static List<Console> listar() {
        return ConsoleDal.listarDal();
    }
}
