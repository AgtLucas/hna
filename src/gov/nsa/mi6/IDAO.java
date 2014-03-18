/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.nsa.mi6;

import java.util.List;

/**
 *
 * @author AgtLucas
 */
public interface IDAO {
    
    Long countAll() throws Exception;

//    Object create(Object o) throws Exception;

//    void delete(Object o) throws Exception;

    List findAll() throws Exception;

    Object findById(Integer theId) throws Exception;

    Object getNewInstance();

    List list(Integer firstResult, Integer maxResults) throws Exception;

    void removeAll() throws Exception;

    Object save(Object o) throws Exception;
    
    void update(Object o) throws Exception;
    
    void remove(Object o) throws Exception;
    
    Object find(String id) throws Exception;
    
}
