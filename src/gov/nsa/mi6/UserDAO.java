/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.nsa.mi6;

import java.util.Set;
import org.hibernate.Query;

/**
 *
 * @author AgtLucas
 */
public class UserDAO extends AbstractDAO {

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
    
    public void addRole(User user, Role role) {
        try {
            if (hasRole(user, role) == true) {
                User user2 = (User) find(String.valueOf(user.getId()));
                Set roles = user2.getRole();
                roles.add(role);
                user2.setRole((Set) roles);
                update(user2);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public boolean hasRole(User user, Role role) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.getNamedQuery(getNameQueryToHasRole());
            q.setInteger("roleid", role.getID());
            q.setInteger("userid", user.getId());

            if (q.uniqueResult() != null) {
                return false;
            } else {
                return true;
            }
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }

    }
    
}
