package com.company.dao.inter;

import com.company.entity.User;
import com.company.entity.UserSkill;

import java.util.List;

public interface UserDaoInter {

    public List<User> getAllUser() throws Exception;
    public void removeUserById(int id) throws Exception;
    public void updateUser(User u) throws Exception;
    public User getUserById(int id);
    public boolean addUser(User u);


}
