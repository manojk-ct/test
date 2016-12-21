package com.zcon.mobileris.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ManojK
 */

@Embeddable
public class AbstractCommonEntity{
 
    @Column(name = "CreatedBy",length = 50,nullable = false,insertable = true,updatable = false)
    private String createdBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedDateTime",nullable = false,insertable = true,updatable = false)
    private Date createdDateTime = new Date();
    
    @Column(name = "UpdatedBy", length = 50, nullable = false,insertable = true,updatable = true)
    private String updatedBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdatedDateTime", nullable = false,insertable = true,updatable = true)
    private Date updatedDateTime = new Date();    
    
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Date updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }    
}
