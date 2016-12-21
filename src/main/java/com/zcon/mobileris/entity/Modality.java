package com.zcon.mobileris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ManojK
 */

@Entity
@Table(name = "Modality")
public class Modality {
    
    @Id
    @Column(name = "ModalityId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modalityId;
    
    @Column(name = "ModalityName")
    private String modalityName;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
    public int getModalityId() {
        return modalityId;
    }

    public void setModalityId(int modalityId) {
        this.modalityId = modalityId;
    }

    public String getModalityName() {
        return modalityName;
    }

    public void setModalityName(String modalityName) {
        this.modalityName = modalityName;
    }

    @Override
    public String toString() {
        return "Modality{" + "modalityId=" + modalityId + ", modalityName=" + modalityName + ", isDeleted=" + isDeleted + '}';
    }

   

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

  
    
    
}
