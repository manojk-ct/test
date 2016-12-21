///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.zcon.mobileris.entity;
//
//import java.util.Set;
//import javax.persistence.Column;
//import javax.persistence.Embedded;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;
//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;
//
///**
// *
// * @author PradnyaS
// */
//@Entity
//@Table(name = "Lists")
//public class Lists {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ListId")
//    private int listId;
//    
//    @Column(name = "ListCode")
//    private String listCode;
//    
//    @Column(name = "ListName")
//    private String listName;
//    
//    @OneToMany(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SELECT)
//    @Cascade(CascadeType.SAVE_UPDATE)
//    @JoinColumn(name = "ListId")
//    private Set<ListValues> listValuesObject;
//    
////    @Embedded
////    private AbstractCommonEntity commonComponent;  
//
//    public int getListId() {
//        return listId;
//    }
//
//    public void setListId(int listId) {
//        this.listId = listId;
//    }
//
//    public String getListCode() {
//        return listCode;
//    }
//
//    public void setListCode(String listCode) {
//        this.listCode = listCode;
//    }
//
//    public String getListName() {
//        return listName;
//    }
//
//    public void setListName(String listName) {
//        this.listName = listName;
//    }
//
////    public AbstractCommonEntity getCommonComponent() {
////        return commonComponent;
////    }
////
////    public void setCommonComponent(AbstractCommonEntity commonComponent) {
////        this.commonComponent = commonComponent;
////    }
//
//    public Set<ListValues> getListValuesObject() {
//        return listValuesObject;
//    }
//
//    public void setListValuesObject(Set<ListValues> listValuesObject) {
//        this.listValuesObject = listValuesObject;
//    }
//
//    @Override
//    public String toString() {
//        return "Lists{" + "listId=" + listId + ", listCode=" + listCode + ", listName=" + listName + ", listValuesObject=" + listValuesObject + '}';
//    }
//
//   
//}
