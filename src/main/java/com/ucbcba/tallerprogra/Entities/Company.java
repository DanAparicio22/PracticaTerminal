package com.ucbcba.tallerprogra.Entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by da_20 on 26/4/2017.
 */
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_company",joinColumns = @JoinColumn(name="company_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
