package com.ucbcba.tallerprogra.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    //terminales
    @OneToMany(mappedBy="userId", cascade = CascadeType.ALL)
    private Set<Terminal> terminals;

    //usuarios
    @OneToMany(mappedBy="usersId", cascade = CascadeType.ALL)
    private Set<User> users;

    //usuario
    @ManyToOne
    @JoinColumn(name="user_id")
    private User usersId;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_company",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="company_id"))
    private Set<Company> companies;

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public User getUsersId() {
        return usersId;
    }

    public void setUsersId(User usersId) {
        this.usersId = usersId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public User getUserId() {
        return usersId;
    }

    public void setUserId(User userId) {
        this.usersId = userId;
    }

    public Set<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(Set<Terminal> terminals) {
        this.terminals = terminals;
    }

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
