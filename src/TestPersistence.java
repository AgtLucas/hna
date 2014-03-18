
import gov.nsa.mi6.Role;
import gov.nsa.mi6.RoleDAO;
import gov.nsa.mi6.User;
import gov.nsa.mi6.UserDAO;
import java.util.ArrayList;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AgtLucas
 */
public class TestPersistence {
    
    public static void main(String ...args) {
        
        try {
    
        } catch (Exception e) {
            System.out.println("The system has failed! Kick the chair! " + e.getMessage());
        }
        
    }
    
    
    // Create roles
    private static Role createRoles(String name) throws Exception {
        
        System.out.println("Creating roles...");
        RoleDAO rd = new RoleDAO();
        
        Role r = new Role();
        r.setName(name);
        rd.save(r);
        
        return r;
        
    }
    
    // Create users
    private static User createUsers(String name) throws Exception {
        
        System.out.println("Creating users...");
        UserDAO ud = new UserDAO();
        
        User u = new User();
        u.setName(name);
        ud.save(u);
        
        return u;
        
    }
    
    // assigning roles to user
    private static void assigningRoleToUser(Set role, User user) throws Exception {
        
        UserDAO ud = new UserDAO();
        
        user.setRole(role);
        ud.update(user);
        
    }
    
    // Show all roles
    private static void showAllRoles() throws Exception {
        
        RoleDAO rd = new RoleDAO();
        ArrayList roles = (ArrayList) rd.findAll();
        Role r;
        
        for (int i = 0; i < roles.size(); i++) {
            r = (Role) roles.get(i);
            System.out.println(r);
        }
        
    }
    
    // Show all users
    private static void showAllUsers() throws Exception {
        
        UserDAO ud = new UserDAO();
        ArrayList users = (ArrayList) ud.findAll();
        User u;
        
        for (int i = 0; i < users.size(); i++) {
            u = (User) users.get(i);
            System.out.println(u);
        }
        
    }
    
}
