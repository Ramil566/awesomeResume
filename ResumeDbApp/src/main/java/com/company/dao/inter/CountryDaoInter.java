/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.Country;
import java.util.List;

/**
 *
 * @author Ramil Abbaszade
 */
public interface CountryDaoInter {
    public List<Country> getAllCountry();
    
    public Country getCountryByName(String name);
    
    public Country getCountryById(int id);
    
    public void removeCountryById(int id);
    
    public void removeCountryByName(String name);
    
    public void updateCountryById(Country c);
    
    public int addCountry(Country c);
}
