package com.company.dao.impl;

import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.User;
import com.company.entity.EmploymentHistory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

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
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int id) {
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

    @Override
    public void removeAllEmploymentHistoryByUserId(int id) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("delete from resume.employment_history where user_id=?");
            stmt.setInt(1, id);
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }     
    }

    @Override
    public int addEmploymentHistory(EmploymentHistory Eh) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("insert into resume.employment_history(header,begin_date,end_date,jobDescription,user_id) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, Eh.getHeader());
            stmt.setDate(2, Eh.getBeginDate());
            stmt.setDate(3, Eh.getEndDate());
            stmt.setString(4, Eh.getJobDescription());
            stmt.setInt(5, Eh.getUser().getId());
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
    public void updateEmploymentHistoryById(EmploymentHistory Eh) {
        try(Connection c = connect();){
            PreparedStatement stmt=c.prepareStatement("update resume.employment_history set  header=?,begin_date=?,end_date=?,jobDescription=?,user_id=? where id=?");
            stmt.setString(1, Eh.getHeader());
            stmt.setDate(2, Eh.getBeginDate());
            stmt.setDate(3, Eh.getEndDate());
            stmt.setString(4, Eh.getJobDescription());
            stmt.setInt(5, Eh.getUser().getId());
            stmt.setInt(6, Eh.getId());
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }    }
    
    
}