package com.zcon.mobileris.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ManojK
 */
@Entity
@Table(name = "DispatchRegions")
public class DispatchRegions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dispatch_region_id")
    private int dispatch_region_id;

    @Column(name = "dispatch_region_name")
    private String dispatch_region_name;

    public int getDispatch_region_id() {
        return dispatch_region_id;
    }

    public void setDispatch_region_id(int dispatch_region_id) {
        this.dispatch_region_id = dispatch_region_id;
    }

    public String getDispatch_region_name() {
        return dispatch_region_name;
    }

    public void setDispatch_region_name(String dispatch_region_name) {
        this.dispatch_region_name = dispatch_region_name;
    }

    @Override
    public String toString() {
        return "DispatchRegions{" + "dispatch_region_id=" + dispatch_region_id + ", dispatch_region_name=" + dispatch_region_name + '}';
    }

    
}
