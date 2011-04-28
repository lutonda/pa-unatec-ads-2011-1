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
 * @author Magno
 */
public class ConsoleService {

    public static List<Console> listar() {
        return ConsoleDal.listarDal();
    }
    public static boolean alterar(Console _obj){
        return ConsoleDal.alteraConsole(_obj);
    }
    public static boolean incluir(Console _obj){
        return ConsoleDal.incluiConsole(_obj);
    }
    public static boolean excluir(int id){
        return ConsoleDal.excluiConsole(id);
    }
}
