/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.company.main;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.NationalityDaoInter;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;

/**
 *
 * @author Ramil Abbaszade
 */
public class Main {

    public static void main(String[] args) throws Exception {
        /*CountryDaoInter countryDaoInter=Context.InstanceCountryDao();
        System.out.println(countryDaoInter.getAllCountry());
        System.out.println("---------------------------------------------------");
        System.out.println();
        
        NationalityDaoInter nationalityDaoInter=Context.InstanceNationalityDao();
        System.out.println(nationalityDaoInter.getAllNationality());
        System.out.println("---------------------------------------------------");
        System.out.println();
        
        EmploymentHistoryDaoInter employmentHistoryDaoInter=Context.InstanceEmploymentHistoryDao();
        System.out.println(employmentHistoryDaoInter.getAllEmploymentHistoryById(1));
        System.out.println("---------------------------------------------------");
        System.out.println();
        */
        SkillDaoInter skillDaoInter=Context.InstanceSkillDao();
        System.out.println(skillDaoInter.getAllSkill());
        System.out.println("---------------------------------------------------");
        skillDaoInter.addSkill(new Skill(null, "SCADA"));
        System.out.println();
        
        /*UserSkillDaoInter userSkillDaoInter=Context.InstanceUserSkillDao();
        System.out.println(userSkillDaoInter.getAllSkillByUserId(1));
        System.out.println("---------------------------------------------------");
        System.out.println();
        
        UserDaoInter userDaoInter=Context.InstanceUserDao();
        System.out.println(userDaoInter.getUserById(1));
        System.out.println("---------------------------------------------------");
        System.out.println();*/
        
    }

}
