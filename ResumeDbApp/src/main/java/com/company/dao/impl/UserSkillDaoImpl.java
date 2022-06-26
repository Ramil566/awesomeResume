package com.company.dao.impl;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.dao.inter.UserSkillDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {
    
    private UserSkill getUserSkill(ResultSet rs)throws Exception{
        int user_id=rs.getInt("id");
        int skill_id=rs.getInt("skill_id");
        String skillName=rs.getString("skill_name");
        int power=rs.getInt("power");
        
        return new UserSkill(null,new User(user_id),new Skill(skill_id,skillName),power);
    }
    

    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {
        List<UserSkill> result=new ArrayList();
        UserSkill u=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT u.*,us.skill_id,s.name as skill_name,us.power FROM resume.user_skill  as us\n" +
                                                        "inner join resume.skills as s on us.skill_id=s.id\n" +
                                                        "inner join resume.user as u on u.id=us.user_id where us.user_id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while (rs.next()) {
            u=getUserSkill(rs);
            result.add(u);
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return result;
    }

    @Override
    public void removeAllSkillByUserId(int id) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("delete from resume.user_skill where user_id=?");
            stmt.setInt(1, id);
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }    
    }

    @Override
    public int addUserSkill(UserSkill us) {
        try(Connection c = connect()){
            PreparedStatement stmt=c.prepareStatement("insert into user_skill(user_id,skill_id,power) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,us.getUser().getId());
            stmt.setInt(2, us.getSkill().getId());
            stmt.setInt(3, us.getPower());
            stmt.execute();
            ResultSet generatedkeys=stmt.getGeneratedKeys();
            if(generatedkeys.next())
                return generatedkeys.getInt(1);
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

}