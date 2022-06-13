package com.company.dao.impl;

import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.CountryAndNationality;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.EmploymentHistory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractUserDAO implements EmploymentHistoryDaoInter {

    private EmploymentHistory getEmploymentHistory(ResultSet rs)throws Exception{
        int id=rs.getInt("id");
        String header=rs.getString("header");
        Date beginDate=rs.getDate("begin_date");
        Date endDate=rs.getDate("end_date");
        String jobDescription=rs.getString("jobDescription");
        int userId=rs.getInt("user_id");
        
        return new EmploymentHistory(id,header,beginDate,endDate,jobDescription,new User(userId));
    }
    
    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryById(int id) {
        List<EmploymentHistory> result=new ArrayList();
        EmploymentHistory EH=null;
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("SELECT * from employment_history where user_id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            
            while(rs.next()){
                EH=getEmploymentHistory(rs);
                result.add(EH);
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
        }    
               
        return result;
    }
    
    
}