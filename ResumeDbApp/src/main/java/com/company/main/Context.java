package com.company.main;

import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.UserDaoInter;

public class Context {
    public static UserDaoInter InstanceDao(){
        return new UserDaoImpl();
    }
}