package com.example.servletproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(value = "/register")
public class register extends HttpServlet {
    private static String URL= "jdbc:mysql://localhost:3308/test01?characterEncoding=utf8";
    private static String className = "com.mysql.jdbc.Driver";   //针对6.0以下
    private static Connection connection =null;
    private static PreparedStatement preparedStatement =null;
    private static ResultSet resultSet =null;
    private static String USERNAME = "root";
    private static String PASSWORD = "123456";
    public static  Connection getConnection(){
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connection = getConnection();
        if(connection != null){
            System.out.println("--------连接成功--------");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            try {
                preparedStatement=connection.prepareStatement("insert into user values (?,?)");
                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                preparedStatement.executeUpdate();
                req.getSession().setAttribute("return","注册成功!");
                resp.sendRedirect("register.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("----------连接失败---------");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
