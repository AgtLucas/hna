/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.nsa.mi6;

import java.util.Set;

/**
 *
 * @author AgtLucas
 */
public interface IRoleDAO extends IDAO {
    
    Set findUser(Role o) throws Exception;
    
}
