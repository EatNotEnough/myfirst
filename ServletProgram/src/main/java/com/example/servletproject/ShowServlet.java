package com.example.servletproject;
import com.example.db.DBConnection;


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
import java.util.ArrayList;
import java.util.List;
import com.example.model.Order;
@WebServlet(value = "/show")
public class ShowServlet extends HttpServlet {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connection = DBConnection.getConnection();
        System.out.println(req.getSession());
        List<Order> orderList = new ArrayList<Order>();
        try {
            preparedStatement = connection.prepareStatement("select * from test01");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("o_id"));
                order.setOrderName(resultSet.getString("o_name"));
                order.setOrderNum(resultSet.getInt("o_num"));
                order.setOrderPrice(resultSet.getDouble("o_price"));
                order.setFactory(resultSet.getString("o_factory"));
                orderList.add(order); //封装到集合
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("orderList", orderList);  //传递集合到页面
        req.getRequestDispatcher("success3.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }
}
