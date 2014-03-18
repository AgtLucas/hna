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
public interface IUserDAO extends IDAO {
    
    void addRole(User u, Role r) throws Exception;
    
    void removeRole(User u, Role r) throws Exception;
    
    boolean hasRole(User u, Role r) throws Exception;
    
    Set findRole(User o) throws Exception;
    
}
