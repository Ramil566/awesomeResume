package com.company.main;

import com.company.dao.impl.CountryDaoImpl;
import com.company.dao.impl.EmploymentHistoryDaoImpl;
import com.company.dao.impl.NationalityDaoImpl;
import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserSkillDaoImpl;
import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.NationalityDaoInter;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;

public class Context {
    public static UserDaoInter InstanceUserDao(){
        return new UserDaoImpl();
    }
    public static UserSkillDaoInter InstanceUserSkillDao(){
        return new UserSkillDaoImpl();
    }
    
    public static EmploymentHistoryDaoInter InstanceEmploymentHistoryDao(){
        return new EmploymentHistoryDaoImpl();
    }
    
    public static SkillDaoInter InstanceSkillDao(){
         return new SkillDaoImpl();
    }
    
    public static CountryDaoInter InstanceCountryDao(){
        return new CountryDaoImpl();
    }
    
    public static NationalityDaoInter InstanceNationalityDao(){
        return new NationalityDaoImpl();
    }
     
 
}
