/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramil Abbaszade
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter{

    private Country getCountry(ResultSet rs) throws Exception{
        Integer id=rs.getInt("id");
        String country=rs.getString("name");
        return new Country(id,country);   
    }
    
    @Override
    public List<Country> getAllCountry() {
        List<Country> result=new ArrayList();
        Country C=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.country;");
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
            C=getCountry(rs);
            result.add(C);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        
        return result;
    }

    @Override
    public Country getCountryByName(String name) {
        Country country=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.country where name=?");
            stmt.setString(1, name);
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
                country=getCountry(rs);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return country;
    }

    @Override
    public Country getCountryById(int id) {
        Country country=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.country where id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
                country=getCountry(rs);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return country;    
    }

    @Override
    public void removeCountryById(int id) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("delete from resume.country where id=?");
            stmt.setInt(1, id);
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }    
    }

    @Override
    public void removeCountryByName(String name) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("delete from resume.country where name=?");
            stmt.setString(1, name);
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }        
    }

    @Override
    public void updateCountryById(Country country) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("update resume.country set  name=? where id=?");
            stmt.setString(1, country.getName());
            stmt.setInt(2, country.getId());
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }    
    }

    @Override
    public int addCountry(Country country) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("insert into resume.country(name) values(?)",Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, country.getName());
            stmt.execute();
            ResultSet generatedKeys=stmt.getGeneratedKeys();
            if(generatedKeys.next())
                return generatedKeys.getInt(1);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }
}
