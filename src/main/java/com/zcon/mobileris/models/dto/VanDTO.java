package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author PravinP
 */
public class VanDTO implements Serializable{
    @NotNull
    private int vanId;
    @NotNull
    @Length(min=1,max = 35)
    private String vanDispatchId;
    @NotNull
    @Length(min=1,max = 35)
    private String vanNumber;
    private String fromLocation;
    private String toLocation;
    private String currentLocation;
    @NotNull
    private int vanStatus;    
    private String otherDetails;

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

    public int getVanStatus() {
        return vanStatus;
    }

    public void setVanStatus(int vanStatus) {
        this.vanStatus = vanStatus;
    }

    @Override
    public String toString() {
        return "VanDTO{" + "vanId=" + vanId + ", vanDispatchId=" + vanDispatchId + ", vanNumber=" + vanNumber + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", currentLocation=" + currentLocation + ", vanStatus=" + vanStatus + ", otherDetails=" + otherDetails + '}';
    }
    
}
