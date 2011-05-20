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
 * @author ADS - FACULDADE
 */
public class ConfiguracaoService {

    public static Configuracao unico (int id){
         return ConfiguracaoDal.getConfiguracao();
    }
    public static boolean alterar (Configuracao _Obj){
        return ConfiguracaoDal.alteraConfiguracao(_Obj);
    }
    public static boolean incluir (Configuracao _Obj){
        return ConfiguracaoDal.incluirConfiguracao(_Obj);
    }
    public static boolean excluir (int id){
        return ConfiguracaoDal.excluirConfiguracao(id);
    }
}
