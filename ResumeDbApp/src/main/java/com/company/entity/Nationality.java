/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.entity;

import java.util.Objects;

/**
 *
 * @author Ramil Abbaszade
 */
public class Nationality {
    private Integer id;
    private String name;

    public Nationality(int id, String nationality) {
        this.id = id;
        this.name = nationality;
    }

    public Nationality() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.name);
        return hash;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nationality other = (Nationality) obj;
        if (this.id==other.id) 
            return true;
        
        return false;
    }

    
    
    @Override
    public String toString() {
            return name;
    }
    
    
}
