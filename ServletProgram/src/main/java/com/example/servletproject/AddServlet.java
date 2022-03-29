package com.example.servletproject;
import com.example.db.DBConnection;
//import com.demo.db.DBConnection;

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

/**
 * @author xie
 * @create 2022-03-2022/3/23 11:11
 */
@WebServlet(
        name = "AddServlet",  //servlet����
        loadOnStartup = -1,  //������ʽ
        urlPatterns = "/add"  //����·��
//        initParams = @WebInitParam(name = "encoding",value = "GBK")  //��ʼ������
)
public class AddServlet extends HttpServlet {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement =null;
    private static ResultSet resultSet = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String num = req.getParameter("num");
        String price = req.getParameter("price");
        String factory = req.getParameter("factory");
//        System.out.println("name = "+name);
//if(name.equals("null")){
//    resp.sendRedirect(req.getContextPath()+"/add");
//}else {
         connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into test01 (o_name,o_num,o_price,o_factory) value (?,?,?,?)");
//            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, Integer.parseInt(num));
            preparedStatement.setDouble(3,Double.parseDouble(price));
            preparedStatement.setString(4,factory);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        req.getRequestDispatcher("/show").forward(req, resp);
        resp.sendRedirect(req.getContextPath()+"/show");

    }


    }


//}
