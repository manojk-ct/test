package com.zcon.mobileris.exceptions;

/**
 * @author ManojK
 */
public class RecordNotFoundException extends RuntimeException{
    
    private int id;
    private String recordName;

    public RecordNotFoundException(int id, String recordName) {
        this.id = id;
        this.recordName = recordName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }
}
