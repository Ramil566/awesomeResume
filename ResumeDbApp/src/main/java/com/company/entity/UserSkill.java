/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.entity;

/**
 *
 * @author Ramil Abbaszade
 */
public class UserSkill {
    private Integer id;
    private User user;
    private Skill skill;
    private int power;

    public UserSkill() {
    }

    public UserSkill(Integer id, User user, Skill skill, int power) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "UserSkill{" + "id=" + id + ", user=" + user + ", skill=" + skill + ", power=" + power + '}';
    }
    
    
    
}
