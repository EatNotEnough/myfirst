package com.example.servletproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/login")
public class login extends HttpServlet {
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
    public void getdata(HttpServletRequest req, HttpServletResponse resp){
        List<user> users= new ArrayList<user>();
        try {
            preparedStatement=connection.prepareStatement("select * from user");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user user1=new user();
                user1.setUsername(resultSet.getString("username"));
                user1.setPassword(resultSet.getString("password"));
                users.add(user1);
            }
            boolean index=false;
            for (user user2 : users) {
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                System.out.println(user2.getUsername());
                System.out.println(user2.getPassword());
                if (username.equals(user2.getUsername())&&password.equals(user2.getPassword()))
                {
                    System.out.println("登录成功");
                    req.getSession().setAttribute("nowusername",user2.getUsername());//Session 创建

                    req.getSession().setAttribute("return","登录成功!");
//                        resp.sendRedirect(req.getContextPath()+"/show");
                        index=true;
                    break;
                }
                else {
                    System.out.println("登录失败");
                    req.getSession().setAttribute("return","登录失败,账号或者密码错误!");
//                    req.getRequestDispatcher("index.jsp").forward(req,resp);
//                    resp.sendRedirect("index.jsp");
                }
            }
//            resp.sendRedirect("index.jsp");
            if (index==true){
                HttpSession httpSession = req.getSession(true); //获取session对象，如果为true将创建session，如果false不创建session

                resp.sendRedirect(req.getContextPath()+"/show");
            }
            else { req.getRequestDispatcher("index.jsp").forward(req,resp);}

        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connection = getConnection();
        if(connection != null){
            System.out.println("--------连接成功--------");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            getdata(req,resp);
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
