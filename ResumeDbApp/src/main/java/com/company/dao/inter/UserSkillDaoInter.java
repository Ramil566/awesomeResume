package com.company.dao.inter;


import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {

    public List<UserSkill> getAllSkillByUserId(int id);
    
    public void removeAllSkillByUserId(int id);
    
    public int addUserSkill(UserSkill us);
}
