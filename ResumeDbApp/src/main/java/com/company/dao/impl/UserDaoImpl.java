package com.company.dao.impl;

import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.Nationality;
import com.company.entity.User;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Country;
import com.company.entity.EmploymentHistory;
import com.company.entity.UserSkill;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    SimpleDateFormat SDF=new SimpleDateFormat("yyyy-MM-dd");
    UserSkillDaoInter UserSkillDao=new UserSkillDaoImpl();
    EmploymentHistoryDaoInter EmploymentHistoryDao= new EmploymentHistoryDaoImpl();
    
    private User getUser(ResultSet rs)throws Exception{
        UserSkillDaoInter USImpl=new UserSkillDaoImpl();
        EmploymentHistoryDaoInter EHImpl=new EmploymentHistoryDaoImpl(); 
        int id=rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String address=rs.getString("address");
        String profileDescription=rs.getString("profile_description");
        String nationalityStr=rs.getString("nationality");
        String birthplaceStr =rs.getString("birthplace");
        Integer nationality_id  =rs.getInt("nationality_id");
        Integer birthplace_id=rs.getInt("birthplace_id");
        Date birthdate=rs.getDate("birthdate");
        
        Nationality nationality=new Nationality(nationality_id,nationalityStr);
        Country birthplace=new Country(birthplace_id,birthplaceStr);
        
        return new User(id,name,surname,email,phone,address,profileDescription,nationality,birthplace,birthdate,USImpl.getAllSkillByUserId(id),EHImpl.getAllEmploymentHistoryByUserId(id));
    } 
    
    @Override
    public List<User> getAllUser() {
        List<User> L1=new ArrayList<>();
    
        try(Connection c=connect();){
        Statement st =c.createStatement();
            st.execute("SELECT u.*, c.name as birthplace ,n.name as nationality " +
                "from resume.user u " +
                "left join resume.country c on u.birthplace_id =c.id " +
                "left join resume.nationality n on u.nationality_id =n.id");
                    
        ResultSet rs=st.getResultSet();
        
        while (rs.next()) 
            L1.add(getUser(rs));
        
        }catch (Exception ex){ex.printStackTrace();}
        return L1;
    }

    @Override
    public void removeUserById(int id) {
        try(Connection c = connect();){
        PreparedStatement st =c.prepareStatement("delete from user where id = ?");
        st.setInt(1, id);
        st.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public  void updateUserById(User u) throws Exception{
        try(Connection c = connect();){
        PreparedStatement st1 =c.prepareStatement("update user set name=?,surname=?,email=?,phone=?,birthplace_id=?,nationality_id=?,profile_description=?,address=?,birthdate=? where id =?");
        st1.setString(1,u.getName());
        st1.setString(2,u.getSurname());
        st1.setString(3,u.getEmail());
        st1.setString(4,u.getPhone());
        st1.setInt(5,u.getBirthplace().getId());
        st1.setInt(6,u.getNationality().getId());
        st1.setString(7,u.getProfileDescription());
        st1.setString(8, u.getAddress());
        st1.setDate(9, u.getBirthdate());
        st1.setInt(10,u.getId());
        st1.execute();
        
             
        UserSkillDao.removeAllSkillByUserId(u.getId());
        
        for(UserSkill us:u.getSkills()){
            UserSkillDao.addUserSkill(us);
        }
        
        EmploymentHistoryDao.removeAllEmploymentHistoryByUserId(u.getId());
        
        for(EmploymentHistory eh:u.getEmploymentHistory()){ 
            EmploymentHistoryDao.addEmploymentHistory(eh);
        }

        }catch (Exception ex){
            ex.printStackTrace();
        }
                
    }

    @Override
    public User getUserById(int id) {
        User u=null;
        try(Connection c = connect();){
            PreparedStatement st =c.prepareStatement("SELECT u.*, c.name as birthplace ,n.name as nationality " +
                        "from resume.user u " +
                        "left join resume.country c on u.birthplace_id =c.id " +
                        "left join resume.nationality n on u.nationality_id =n.id where u.id=?");
            st.setInt(1, id);
            st.execute();
            ResultSet rs=st.getResultSet();
            while (rs.next()) {
                u=getUser(rs);
            }
            }catch (Exception ex){
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public int addUser(User u) {
        try(Connection c = connect()){
            PreparedStatement stmt=c.prepareStatement("insert into user(name,surname,phone,email,profile_description,address,birthdate,birthplace_id,nationality_id) values(?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDescription());
            stmt.setString(6, u.getAddress());
            stmt.setDate(7, u.getBirthdate());
            stmt.setInt(8, u.getBirthplace().getId());
            stmt.setInt(9, u.getNationality().getId());
            if(!stmt.execute()) return -1;
            ResultSet generatedKeys=stmt.getGeneratedKeys();
            if(generatedKeys.next())
                return generatedKeys.getInt(1);
            
            for(UserSkill us:u.getSkills()){
                UserSkillDao.addUserSkill(us);
            } 
            
            for(EmploymentHistory eh:u.getEmploymentHistory()){ 
               EmploymentHistoryDao.addEmploymentHistory(eh);
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        return -1;
    }


}