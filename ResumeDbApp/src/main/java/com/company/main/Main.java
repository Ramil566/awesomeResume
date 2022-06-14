/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.company.main;
import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.SkillDaoInter;



/**
 *
 * @author Ramil Abbaszade
 */
public class Main {

    public static void main(String[] args) throws Exception {

        //UserDaoInter impl1=Context.InstanceUserDao();
        CountryDaoInter impl1=Context.InstanceCountryDao();
        System.out.println(impl1.getAllCountry());
        
        /*User u1=impl1.getUserById(1);
        System.out.println(u1);
        u1.setSurname("Abbaszada");
        impl1.updateUser(u1);
        System.out.println(impl1.getUserById(1));*/

        //List<UserSkill> l1=impl1.getAllSkillByUserId(1);
        //System.out.println(l1);
        
    }

}
