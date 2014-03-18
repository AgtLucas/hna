/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.nsa.mi6;

import java.util.Set;
import org.hibernate.HibernateException;

/**
 *
 * @author AgtLucas
 */
public class RoleDAO extends AbstractDAO implements IRoleDAO {

    @Override
    protected String getNamedQueryToFindAll() {
        return "role.find.all";
    }

    @Override
    protected String getNamedQueryToFindById() {
        return "role.id.equals";
    }

    @Override
    protected String getNamedQueryToFindByName() {
        return "role.name.equals";
    }

    @Override
    protected String getNamedQueryToCountAll() {
        return "role.count.all";
    }

    @Override
    protected String getNamedQueryToRemoveAll() {
        return "role.remove.all";
    }

    @Override
    protected String getNamedQueryToFindByRange() {
        return "role.find.range";
    }

    @Override
    public Object getNewInstance() {
        return new Role();
    }
    

    public Object find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(Integer theId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set findUser(Role o) throws Exception {
        
        try {
            Role r = (Role) find(String.valueOf(o.getId()));
            return r.getUser();
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getLocalizedMessage());
        } finally {
            releaseSession(session);
        }
    }
    
}
