/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;


import com.company.entity.Skill;
import java.util.List;

/**
 *
 * @author Ramil Abbaszade
 */
public interface SkillDaoInter {
    public List<Skill> getAllSkill();
    public int addSkill(Skill s);
    public Skill getSkillByName(String name);
    public Skill getSkillById(int id);
    public void removeSkillByName(String name);
    public void removeSkillById(int id);
    public void updateSkillById(Skill s);
}
