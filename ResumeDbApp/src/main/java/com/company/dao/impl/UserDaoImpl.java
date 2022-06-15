package com.company.dao.impl;

import com.company.entity.CountryAndNationality;
import com.company.entity.User;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
        
    private User getUser(ResultSet rs)throws Exception{
        UserSkillDaoInter impl1=new UserSkillDaoImpl();
        String name=null;
        String surname=null;
        String email=null;
        String phone=null;
        String address=null;
        String profileDescription=null;
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
        address=rs.getString("address");
        profileDescription=rs.getString("profile_description");
        nationalityStr=rs.getString("nationality");
        birthplaceStr =rs.getString("birthplace");
        nationality_id  =rs.getInt("nationality_id");
        birthplace_id=rs.getInt("birthplace_id");
        birthdate=rs.getDate("birthdate");
        
        CountryAndNationality nationality=new CountryAndNationality(nationality_id,null,nationalityStr);
        CountryAndNationality birthplace=new CountryAndNationality(birthplace_id,birthplaceStr,null);
        
        return new User(id,name,surname,email,phone,address,profileDescription,nationality,birthplace,birthdate,impl1.getAllSkillByUserId(id));
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
        PreparedStatement st =c.prepareStatement("update user set name=?,surname=?,email=?,phone=?,birthplace_id=?,nationality_id=?,profile_description=?,address=?,birthdate=? where id =?");
        st.setString(1,u.getName());
        st.setString(2,u.getSurname());
        st.setString(3,u.getEmail());
        st.setString(4,u.getPhone());
        st.setInt(5,u.getBirthplace().getId());
        st.setInt(6,u.getNationality().getId());
        st.setString(7,u.getProfileDescription());
        st.setString(8, u.getAddress());
        st.setDate(9, u.getBirthdate());
        st.setInt(10,u.getId());
        st.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        User u=null;
        try(Connection c = connect();){
            PreparedStatement st =c.prepareStatement("SELECT u.*, c.country_name as birthplace ,n.nationality as nationality " +
                        "from resume.user u " +
                        "left join resume.country_and_nationality c on u.birthplace_id =c.id " +
                        "left join resume.country_and_nationality n on u.nationality_id =n.id where u.id=?");
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
    public boolean addUser(User u) {
        try(Connection c = connect()){
            PreparedStatement pstmt=c.prepareStatement("insert into user(name,surname,phone,email,profile_description,address,birthdate,birthplace_id,nationality_id) values(?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setString(3, u.getPhone());
            pstmt.setString(4, u.getEmail());
            pstmt.setString(5, u.getProfileDescription());
            pstmt.setString(6, u.getAddress());
            pstmt.setDate(7, u.getBirthdate());
            pstmt.setInt(8, u.getBirthplace().getId());
            pstmt.setInt(9, u.getNationality().getId());
            return pstmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }


}