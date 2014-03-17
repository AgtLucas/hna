/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.nsa.mi6;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author AgtLucas
 */
@Entity
@Table(name = "Role")
@NamedQueries({
    @NamedQuery(name = "role.id.equals", query = "SELECT o FROM Role o WHERE o.id=:id"),
    @NamedQuery(name = "role.name.equals", query = "SELECT o FROM Role o WHERE o.name=:name"),
    @NamedQuery(name = "role.find.all", query = "SELECT o from Role o"),
    @NamedQuery(name = "role.count.all", query = "SELECT COUNT (o.id) FROM Role o"),
    @NamedQuery(name = "role.remove.all", query = "DELETE FROM Role o"),
    @NamedQuery(name = "role.find.range", query = "SELECT o FROM Role o WHERE o.id BETWEEN :minId and :maxId")
})

public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    public Role() {
        setId(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "User(" + "id=" + id + ", name=" + name + ")";
    }
}
