/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
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
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter{

    private Skill getSkill(ResultSet rs) throws Exception{
        Integer id=rs.getInt("id");
        String country=rs.getString("name");
        return new Skill(id,country);   
    }
    
    @Override
    public List<Skill> getAllSkill() {
        List<Skill> result=new ArrayList();
        Skill s=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.skills;");
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
            s=getSkill(rs);
            result.add(s);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        
        return result;
    }

    @Override
    public int addSkill(Skill s) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("insert into skills(name) values(?)",Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, s.getName());
            stmt.execute();
            ResultSet generatedKeys=stmt.getGeneratedKeys();
            if(generatedKeys.next())
                return generatedKeys.getInt(1);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Skill getSkillByName(String name) {
        Skill s=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.skills where name =?");
            stmt.setString(1, name);
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
            s=getSkill(rs);
            }
            return s;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return s;
    }

    @Override
    public Skill getSkillById(int id) {
        Skill skill=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.skills where id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
                skill=getSkill(rs);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return skill;    
    }

    @Override
    public void removeSkillByName(String name) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("delete from resume.skills where name=?");
            stmt.setString(1, name);
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }    
    }

    @Override
    public void removeSkillById(int id) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("delete from resume.skills where id=?");
            stmt.setInt(1, id);
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }    
    }

    @Override
    public void updateSkillById(Skill skill) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("update resume.skills set  name=? where id=?");
            stmt.setString(1, skill.getName());
            stmt.setInt(2, skill.getId());
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }    
    }
    
}
