/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.NationalityDaoInter;
import com.company.entity.Nationality;
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
public class NationalityDaoImpl extends AbstractDAO implements NationalityDaoInter{

    private Nationality getNationality(ResultSet rs)throws Exception{
        Integer id=rs.getInt("id");
        String nationality=rs.getString("name");
        return new Nationality(id,nationality); 
    }
    
    @Override
    public List<Nationality> getAllNationality() {
        List<Nationality> result=new ArrayList();
        Nationality N=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.nationality;");
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
                N=getNationality(rs);
                result.add(N);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        
        return result;
    }

    @Override
    public Nationality getNationalityByName(String name) {
        Nationality nationality=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.nationality where name=?");
            stmt.setString(1, name);
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
                nationality=getNationality(rs);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return nationality;   
    }

    @Override
    public Nationality getNationalityById(int id) {
        Nationality nationality=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.nationality where id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
                nationality=getNationality(rs);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return nationality;      
    }

    @Override
    public void removeNationalityById(int id) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("delete from resume.nationality where id=?");
            stmt.setInt(1, id);
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }     
    }

    @Override
    public void removeNationalityByName(String name) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("delete from resume.nationality where name=?");
            stmt.setString(1, name);
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }    
    }

    @Override
    public void updateNationalityById(Nationality nationality) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("update resume.nationality set  name=? where id=?");
            stmt.setString(1, nationality.getName());
            stmt.setInt(2, nationality.getId());
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int addCountry(Nationality nationality) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("insert into resume.nationality(name) values(?)",Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nationality.getName());
            stmt.execute();
            ResultSet generatedKeys=stmt.getGeneratedKeys();
            if(generatedKeys.next())
                return generatedKeys.getInt(1);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return -1;    }
   
}
