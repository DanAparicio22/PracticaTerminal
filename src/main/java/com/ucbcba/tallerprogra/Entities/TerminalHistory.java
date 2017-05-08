package com.ucbcba.tallerprogra.Entities;

import javax.persistence.*;

/**
 * Created by da_20 on 8/5/2017.
 */
@Entity
public class TerminalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String serial;

    private Boolean active;

    private Integer category_id;

    private Integer user_id;

    @ManyToOne
    @JoinColumn(name="terminal_id")
    private Terminal terminalId;


    public TerminalHistory(String serial,Boolean active,Integer category_id,Integer user_id, Terminal terminalId){
        this.serial=serial;
        this.active=active;
        this.category_id=category_id;
        this.user_id=user_id;
        this.terminalId=terminalId;
    }

    public TerminalHistory(){

    }
    public Terminal getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Terminal terminalId) {
        this.terminalId = terminalId;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


}
