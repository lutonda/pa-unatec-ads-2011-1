/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.service;

import una.pa.model.*;
import una.pa.repository.*;
/**
 *
 * @author Tiago
 */
public class EnderecoService {
    public static Endereco listarEndereco(int _id){
        return EnderecoDao.listarEndereco(_id);
    }

}
