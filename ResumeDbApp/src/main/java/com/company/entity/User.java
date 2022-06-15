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
    CountryAndNationality nationality;
    CountryAndNationality birthplace;  
    Date birthdate;
    List<UserSkill> skills; 
    
    public User() {
    }
    
    public User(int id) {
        this.id=id;
    }

    public User(int id, String name, String surname, String email, String phone,String address, String profile_description, CountryAndNationality nationality, CountryAndNationality birthplace, Date birthdate, List<UserSkill> skills) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address=address;
        this.profileDescription = profile_description;
        this.nationality = nationality;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
        this.skills = skills;
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

    public CountryAndNationality getNationality() {
        return nationality;
    }

    public void setNationality(CountryAndNationality nationality) {
        this.nationality = nationality;
    }

    public CountryAndNationality getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(CountryAndNationality birthplace) {
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
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone +", address=" + address + ", profile_description=" + profileDescription + ", nationality=" + nationality + ", birthplace=" + birthplace + ", birthdate=" + birthdate + ", skills=" + skills + '}';
    }


    
}
