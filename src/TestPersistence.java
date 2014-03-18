
import gov.nsa.mi6.Role;
import gov.nsa.mi6.RoleDAO;
import gov.nsa.mi6.User;
import gov.nsa.mi6.UserDAO;
import java.util.ArrayList;
import java.util.HashSet;
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
            
            removeAllUsers();
            removeAllUsers();
            
            User u = createUsers("Jason Bourne");
            Role r = createRoles("Spy");
            
            Set role = new HashSet();
            role.add(r);
            
            assigningRoleToUser(role, u);
            
            showAllUsers();
            showAllRoles();
            showAllUserRole(u);
            
            findUser(r);
            
            addNewRole(u, r);
            
            removeRole(r, u);
            
            hasRole(u, r);
            
            findRoles(u);
    
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
    
    // Add role
    private static void addNewRole(User user, Role role) throws Exception {
        System.out.println("Adding roles to users");
        UserDAO ud = new UserDAO();
        ud.addRole(user, role);
    }
    
    
    // Assigning roles to user
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
    
    // Show all UserRole
    private static void showAllUserRole(User user) {
        
        System.out.println("Users and roles: ");
        Set ur = user.getRole();
        
        Role role;
        
        for (Object u: ur) {
            role = (Role) u;
            System.out.println(role);
        }
        
    }
    
    // Find user
    private static void findUser(Role role) throws Exception {
        
        System.out.println("Users with role " + role.getName());
        
        RoleDAO rd = new RoleDAO();
        
        Set ur = rd.findUser(role);
        
        User o;
        
        for (Object u: ur) {
            o = (User) u;
            System.out.println(o);
        }
        
    }
    
    // Remove role
    private static void removeRole(Role role, User user) throws Exception {
        
        System.out.println("Removing roles...");
        UserDAO ud = new UserDAO();
        ud.removeRole(user, role);
        
    }
    
    // Has role
    private static boolean hasRole(User user, Role role) throws Exception {
        
        System.out.println("Checking roles...");
        UserDAO ud = new UserDAO();
        return ud.hasRole(user, role);
        
    }
    
    // Find roles
    private static void findRoles(User user) throws Exception {
        
        UserDAO ud = new UserDAO();
        Set role = ud.findRole(user);
        Role o;
        
        for (Object u: role) {
            o = (Role) u;
            System.out.println(o);
        }
        
    }
    
    // Removing users
    private static void removeAllUsers() throws Exception {
        
        UserDAO ud = new UserDAO();
        ud.removeAll();
        
    }
    
    // Removing roles
    private static void removeAllRoles() throws Exception {
        
        RoleDAO rd = new RoleDAO();
        rd.removeAll();
        
    }
    
}
