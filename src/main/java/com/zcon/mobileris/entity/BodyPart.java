package com.zcon.mobileris.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author ManojK
 */
@Entity
@Table(name = "BodyPart")
public class BodyPart {
    
    @Id
    @Column(name = "BodyPartId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bodyPartId;
    
    @Column(name = "BodyPartName")
    private String bodyPartName;
    
    @Column(name = "BodyPartCode")
    private Long bodyPartCode;
    
    @Column(name = "Description")
    private String description;
    
    @Column(name = "Status")
    private char status;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "BodyPartModality",joinColumns = {@JoinColumn(name = "BodyPartId",referencedColumnName = "BodyPartId",unique = false)},inverseJoinColumns = {@JoinColumn(name = "ModalityId",referencedColumnName = "ModalityId")})
    private Set<Modality> modality;
         
    @Embedded
    private AbstractCommonEntity commonComponent;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
    public int getBodyPartId() {
        return bodyPartId;
    }

    public void setBodyPartId(int bodyPartId) {
        this.bodyPartId = bodyPartId;
    }

    public String getBodyPartName() {
        return bodyPartName;
    }

    public void setBodyPartName(String bodyPartName) {
        this.bodyPartName = bodyPartName;
    }

    public Long getBodyPartCode() {
        return bodyPartCode;
    }

    public void setBodyPartCode(Long bodyPartCode) {
        this.bodyPartCode = bodyPartCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Set<Modality> getModality() {
        return modality;
    }

    public void setModality(Set<Modality> modality) {
        this.modality = modality;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "BodyPart{" + "bodyPartId=" + bodyPartId + ", bodyPartName=" + bodyPartName + ", bodyPartCode=" + bodyPartCode + ", description=" + description + ", status=" + status + ", modality=" + modality + ", commonComponent=" + commonComponent + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
