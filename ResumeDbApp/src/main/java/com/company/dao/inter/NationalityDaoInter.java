/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.Nationality;
import java.util.List;

/**
 *
 * @author Ramil Abbaszade
 */
public interface NationalityDaoInter {
    public List<Nationality> getAllNationality();
    
    public Nationality getNationalityByName(String name);
    
    public Nationality getNationalityById(int id);
    
    public void removeNationalityById(int id);
    
    public void removeNationalityByName(String name);
    
    public void updateNationalityById(Nationality n);
    
    public int addCountry(Nationality n);
}
