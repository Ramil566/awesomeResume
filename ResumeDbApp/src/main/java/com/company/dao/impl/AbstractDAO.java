package com.company.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {
    public Connection connect() throws Exception{
        //Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "root";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
