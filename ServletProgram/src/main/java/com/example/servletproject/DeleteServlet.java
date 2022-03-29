package com.example.servletproject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.db.DBConnection;

@WebServlet(value = "/delete")
public class DeleteServlet extends HttpServlet {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement =null;
    private static ResultSet resultSet = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer orderid= Integer.parseInt(req.getParameter("orderId"));
        System.out.println("=====order======");
        connection = DBConnection.getConnection();
        System.out.println("----------sql--------------");
        try {

            preparedStatement = connection.prepareStatement("delete from test01 where o_id = ?");
            preparedStatement.setInt(1,orderid);
            int result = preparedStatement.executeUpdate();
            if(result >0 ){
//                req.getRequestDispatcher("/show").forward(req,resp);
                resp.sendRedirect(req.getContextPath()+"/show");
            }
            else{
                req.setAttribute("message","删除失败！");
//                req.getRequestDispatcher("/show").forward(req,resp);
                resp.sendRedirect(req.getContextPath()+"/show");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          doGet(req,resp);
    }
}
