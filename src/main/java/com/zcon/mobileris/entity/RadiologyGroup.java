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
@Table(name = "RadiologyGroup")
public class RadiologyGroup {
    
    @Id
    @Column(name = "RadiologyGroupId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int radiologyGroupId;
    
    @Column(name="GroupName")
    private String groupName;
    
    @Column(name = "PACServer")
    private String pacServer;
    
    @Column(name = "ServerIP")
    private String serverIP;
    
    @Column(name = "ServerPort")
    private int serverPort;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  
    
    public int getRadiologyGroupId() {
        return radiologyGroupId;
    }

    public void setRadiologyGroupId(int radiologyGroupId) {
        this.radiologyGroupId = radiologyGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPacServer() {
        return pacServer;
    }

    public void setPacServer(String pacServer) {
        this.pacServer = pacServer;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "RadiologyGroup{" + "radiologyGroupId=" + radiologyGroupId + ", groupName=" + groupName + ", pacServer=" + pacServer + ", serverIP=" + serverIP + ", serverPort=" + serverPort + ", commonComponent=" + commonComponent + '}';
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    
}
