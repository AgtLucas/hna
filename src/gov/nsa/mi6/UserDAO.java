/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.nsa.mi6;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AgtLucas
 */
public class UserDAO extends AbstractDAO implements IUserDAO {

    @Override
    protected String getNamedQueryToFindAll() {
        return "user.find.all";
    }

    @Override
    protected String getNamedQueryToFindById() {
        return "user.id.equals";
    }

    @Override
    protected String getNamedQueryToFindByName() {
        return "user.name.equals";
    }

    @Override
    protected String getNamedQueryToCountAll() {
        return "user.count.all";
    }

    @Override
    protected String getNamedQueryToRemoveAll() {
        return "user.remove.all";
    }

    @Override
    protected String getNamedQueryToFindByRange() {
        return "user.find.range";
    }

    @Override
    public Object getNewInstance() {
        return new User();
    }

    String getNameQueryToFindUser() {
        return "user.find.role";
    }
    
    private String getNameQueryToHasRole() {
        return "user.has.role";
    }
    
    @Override
    public void addRole(User user, Role role) {
        try {
            if (hasRole(user, role) == true) {
                User u = (User) find(String.valueOf(user.getId()));
                Set roles = u.getRole();
                roles.add(role);
                u.setRole((Set) roles);
                update(u);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public boolean hasRole(User user, Role role) throws Exception {
        try {
            User u = (User) find(String.valueOf(user.getId()));
            Set roles = u.getRole();
            return roles.contains(role);
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }

    }

    @Override
    public Object create(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(Integer theId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findByName(String theName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRole(User u, Role r) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set findRole(User o) throws Exception {
        try {
            User u = (User) find(String.valueOf(o.getId()));
            return u.getRole();
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getLocalizedMessage());
        } finally {
            releaseSession(session);
        }
    }
    
}
