package com.company.entity;

import java.sql.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String profileDescription;
    Nationality nationality;
    Country birthplace;  
    Date birthdate;
    List<UserSkill> skills; 
    List<EmploymentHistory> employmentHistory;
    
    public User() {
    }
    
    public User(int id) {
        this.id=id;
    }
    public User(int id, String name, String surname, String email, String phone, String address, String profileDescription, Nationality nationality, Country birthplace, Date birthdate, List<UserSkill> skills, List<EmploymentHistory> employmentHistory) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.profileDescription = profileDescription;
        this.nationality = nationality;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
        this.skills = skills;
        this.employmentHistory = employmentHistory;
    }

    public List<EmploymentHistory> getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(List<EmploymentHistory> employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Country getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Country birthplace) {
        this.birthplace = birthplace;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + ", address=" + address + ", profileDescription=" + profileDescription + ", nationality=" + nationality + ", birthplace=" + birthplace + ", birthdate=" + birthdate + ", skills=" + skills + ", employmentHistory=" + employmentHistory + '}';
    }



    
}
