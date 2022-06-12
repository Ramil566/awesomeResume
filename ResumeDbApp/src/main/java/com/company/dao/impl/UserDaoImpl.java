package com.company.dao.impl;

import com.company.bean.User;
import com.company.dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractUserDAO implements UserDaoInter {
    @Override
    public List<User> getAllUser() {
        List<User> L1=new ArrayList<>();

        try(Connection c=connect();){
        Statement st =c.createStatement();
        st.execute("Select  * from user");
        ResultSet rs=st.getResultSet();

        while (rs.next()) {
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            L1.add(new User(id, name, surname, email, phone));
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
        PreparedStatement st =c.prepareStatement("update user set name=?,surname=?,email=?,phone=? where id =?");
        st.setString(1,u.getName());
        st.setString(2,u.getSurname());
        st.setString(3,u.getEmail());
        st.setString(4,u.getPhone());
        st.setInt(5,u.getId());
        st.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        String name=null;
        String surname=null;
        String email=null;
        String phone=null;
        try(Connection c = connect();){
            Statement st =c.createStatement();
            st.execute("select * from user where id="+id);
            ResultSet rs=st.getResultSet();
            while (rs.next()) {
                name = rs.getString("name");
                surname = rs.getString("surname");
                email = rs.getString("email");
                phone = rs.getString("phone");
            }
            }catch (Exception ex){
            ex.printStackTrace();
        }
        return new User(id,name,surname,email,phone);
    }

}