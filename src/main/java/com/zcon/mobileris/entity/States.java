package com.zcon.mobileris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ManojK
 */
@Entity
@Table(name = "States")
public class States{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int state_id;

    @Column(name = "country_id")
    private int country_id;

    @NotEmpty
    @Column(name = "state_name")
    private String state_name;

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

//    public int getCountry_id() {
//        return country_id;
//    }
    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "States{" + "state_id=" + state_id + ", country_id=" + country_id + ", state_name=" + state_name + '}';
    }

     
}
