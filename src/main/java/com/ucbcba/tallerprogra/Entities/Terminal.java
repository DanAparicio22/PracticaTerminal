package com.ucbcba.tallerprogra.Entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by da_20 on 26/4/2017.
 */
@Entity
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String serial;

    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @OneToMany(mappedBy="terminalId", cascade = CascadeType.ALL)
    private Set<Location> locations;

    @OneToMany(mappedBy="terminalId", cascade = CascadeType.ALL)
    private Set<TerminalHistory> TerminalHistories;

    public Set<TerminalHistory> getTerminalHistories() {
        return TerminalHistories;
    }

    public void setTerminalHistories(Set<TerminalHistory> terminalHistories) {
        TerminalHistories = terminalHistories;
    }

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userId;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> lcoations) {
        this.locations = lcoations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
