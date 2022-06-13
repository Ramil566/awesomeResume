/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity.CountryAndNationality;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramil Abbaszade
 */
public class CountryDaoImpl extends AbstractUserDAO implements CountryDaoInter{

    private CountryAndNationality getCountry(ResultSet rs) throws Exception{
        Integer id=rs.getInt("id");
        String country=rs.getString("coutry_name");
        return new CountryAndNationality(id,country,null);   
    }
    
    @Override
    public List<CountryAndNationality> getAllCountry() {
        List<CountryAndNationality> result=new ArrayList();
        CountryAndNationality CAN=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.country_and_nationality;");
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
            CAN=getCountry(rs);
            result.add(CAN);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        
        return result;
    }
    
}
