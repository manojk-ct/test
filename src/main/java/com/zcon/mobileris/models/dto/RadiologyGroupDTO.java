/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;

/**
 *
 * @author PradnyaS
 */
public class RadiologyGroupDTO implements Serializable{
    private int radiologyGroupId;
    private String groupName;
    private String pacServer;
    private String serverIP;
    private int serverPort;
    private boolean isDeleted;

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

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    
}
