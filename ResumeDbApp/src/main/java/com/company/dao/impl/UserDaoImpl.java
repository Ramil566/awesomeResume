package com.company.dao.impl;

import com.company.entity.CountryAndNationality;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractUserDAO implements UserDaoInter {
    
    private User getUser(ResultSet rs)throws Exception{
        UserSkillDaoInter impl1=new UserSkillDaoImpl();
        String name=null;
        String surname=null;
        String email=null;
        String phone=null;
        String nationalityStr=null;
        String birthplaceStr=null;
        Integer nationality_id=null;
        Integer birthplace_id=null;
        Date  birthdate=null;
        int id=rs.getInt("id");
        name = rs.getString("name");
        surname = rs.getString("surname");
        email = rs.getString("email");
        phone = rs.getString("phone");
        nationalityStr=rs.getString("nationality");
        birthplaceStr =rs.getString("birthplace");
        nationality_id  =rs.getInt("nationality_id");
        birthplace_id=rs.getInt("birthplace_id");
        birthdate=rs.getDate("birthdate");
        
        CountryAndNationality nationality=new CountryAndNationality(nationality_id,null,nationalityStr);
        CountryAndNationality birthplace=new CountryAndNationality(birthplace_id,birthplaceStr,null);
        
        return new User(id,name,surname,email,phone,nationality,birthplace,birthdate,impl1.getAllSkillByUserId(id));
    }
    
    
    
    @Override
    public List<User> getAllUser() {
        List<User> L1=new ArrayList<>();

        try(Connection c=connect();){
        Statement st =c.createStatement();
                    st.execute("SELECT u.*, c.country_name as birthplace ,n.nationality as nationality " +
                        "from resume.user u " +
                        "left join resume.country_and_nationality c on u.birthplace_id =c.id " +
                        "left join resume.country_and_nationality n on u.nationality_id =n.id");
                    
        ResultSet rs=st.getResultSet();

        while (rs.next()) {
            L1.add(getUser(rs));
        }}catch (Exception ex){ex.printStackTrace();}
        return L1;
    }

    @Override
    public void removeUserById(int id) {
        try(Connection c = connect();){
        Statement st =c.createStatement();
        st.execute("delete user where  where id ="+id);}catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public  void updateUser(User u) throws Exception{
        try(Connection c = connect();){
        PreparedStatement st =c.prepareStatement("update user set name=?,surname=?,email=?,phone=?,birdthplace_id=?,nationality_id=? where id =?");
        st.setString(1,u.getName());
        st.setString(2,u.getSurname());
        st.setString(3,u.getEmail());
        st.setString(4,u.getPhone());
        st.setInt(5,u.getBirthplace().getId());
        st.setInt(6,u.getNationality().getId());
        st.setInt(7,u.getId());
        st.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        User u=null;
        try(Connection c = connect();){
            Statement st =c.createStatement();
            st.execute("SELECT u.*, c.country_name as birthplace ,n.nationality as nationality " +
                        "from resume.user u " +
                        "left join resume.country_and_nationality c on u.birdthplace_id =c.id " +
                        "left join resume.country_and_nationality n on u.nationality_id =n.id where u.id="+id);
            ResultSet rs=st.getResultSet();
            while (rs.next()) {
                u=getUser(rs);
            }
            }catch (Exception ex){
            ex.printStackTrace();
        }
        return u;
    }


}