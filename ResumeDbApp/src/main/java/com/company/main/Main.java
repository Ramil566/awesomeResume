/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.company.main;
import com.company.dao.inter.EmploymentHistoryDaoInter;


/**
 *
 * @author Ramil Abbaszade
 */
public class Main {

    public static void main(String[] args) throws Exception {

        //UserDaoInter impl1=Context.InstanceUserDao();
        EmploymentHistoryDaoInter impl1=Context.InstanceEmploymentHistoryDao();
        System.out.println(impl1.getAllEmploymentHistoryById(1));
        
        /*User u1=impl1.getUserById(1);
        System.out.println(u1);
        u1.setSurname("Abbaszada");
        impl1.updateUser(u1);
        System.out.println(impl1.getUserById(1));*/

        //List<UserSkill> l1=impl1.getAllSkillByUserId(1);
        //System.out.println(l1);
        
    }

}
