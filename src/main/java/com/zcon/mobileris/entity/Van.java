package com.zcon.mobileris.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PravinP
 */
@Entity
@Table(name = "Van")
public class Van {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VanId")
    private int vanId;
      
    @Column(name = "VanDispatchID", length = 45)
    private String vanDispatchId;
    
    @Column(name = "VanNumber", length = 45)
    private String vanNumber;
    
    @Column(name = "FromLocation", length = 45)
    private String fromLocation;
    
    @Column(name = "ToLocation", length = 45)
    private String toLocation;
    
    @Column(name = "CurrentLocation", length = 45)
    private String currentLocation;
    
    @Column(name = "VanStatus",length = 1)
    private int vanStatus;
    
    @Column(name = "OtherDetails")
    private String otherDetails;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
        
    @Embedded
    private AbstractCommonEntity commonComponent;

    public int getVanId() {
        return vanId;
    }

    public void setVanId(int vanId) {
        this.vanId = vanId;
    }

    public String getVanDispatchId() {
        return vanDispatchId;
    }

    public void setVanDispatchId(String vanDispatchId) {
        this.vanDispatchId = vanDispatchId;
    }

    public String getVanNumber() {
        return vanNumber;
    }

    public void setVanNumber(String vanNumber) {
        this.vanNumber = vanNumber;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }
    
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
   
    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getVanStatus() {
        return vanStatus;
    }

    public void setVanStatus(int vanStatus) {
        this.vanStatus = vanStatus;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Van{" + "vanId=" + vanId + ", vanDispatchId=" + vanDispatchId + ", vanNumber=" + vanNumber + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", currentLocation=" + currentLocation + ", vanStatus=" + vanStatus + ", otherDetails=" + otherDetails + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }

    
}
