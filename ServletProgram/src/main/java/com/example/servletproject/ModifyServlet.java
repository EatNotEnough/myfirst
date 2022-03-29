package com.example.servletproject;

//import com.demo.db.DBConnection;
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


@WebServlet(
        name = "ModifyServlet",
        loadOnStartup = -1,
        urlPatterns = "/modify"
)
public class ModifyServlet extends HttpServlet {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement =null;
    private static ResultSet resultSet = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String num = req.getParameter("num");
        String price = req.getParameter("price");
        String factory = req.getParameter("factory");
        System.out.println(id+name+price+factory);
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update test01  set o_name=?,o_num=?,o_price=?,o_factory=?,o_id=? where o_id=?");
            preparedStatement.setInt(6, Integer.parseInt(id));
            preparedStatement.setInt(5, Integer.parseInt(id));
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2, Integer.parseInt(num));
            preparedStatement.setDouble(3,Double.parseDouble(price));
            preparedStatement.setString(4,factory);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getRequestDispatcher("/show").forward(req, resp);
    }
}
