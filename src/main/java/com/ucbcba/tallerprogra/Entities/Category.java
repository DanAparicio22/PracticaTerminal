package com.ucbcba.tallerprogra.Entities;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by da_20 on 26/4/2017.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String name;

    @OneToMany(mappedBy="categoryId", cascade = CascadeType.ALL)
    private Set<Terminal> terminals;


    public Set<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(Set<Terminal> terminals) {
        this.terminals = terminals;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
