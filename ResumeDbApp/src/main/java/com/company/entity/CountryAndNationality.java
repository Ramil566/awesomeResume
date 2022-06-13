/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.entity;

/**
 *
 * @author Ramil Abbaszade
 */
public class CountryAndNationality {
    private Integer id;
    private String country_name;
    private String nationality;

    public CountryAndNationality(int id, String country_name, String nationality) {
        this.id = id;
        this.country_name = country_name;
        this.nationality = nationality;
    }

    public CountryAndNationality() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "CountryAndNationality{" + "id=" + id + ", country_name=" + country_name + ", nationality=" + nationality + '}';
    }
    
    
}
