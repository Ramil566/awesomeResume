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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramil Abbaszade
 */
public class SkillDaoImpl extends AbstractUserDAO implements SkillDaoInter{

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
            PreparedStatement stmt=c.prepareStatement("SELECT * from resume.skill;");
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
    
}
