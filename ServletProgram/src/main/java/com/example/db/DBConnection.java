package com.example.db;

import java.sql.*;

public class DBConnection {


    private static String URL= "jdbc:mysql://localhost:3308/test01?characterEncoding=utf8";
    private static String className = "com.mysql.jdbc.Driver";
    private static Connection connection =null;
    private static PreparedStatement preparedStatement =null;
    private static ResultSet resultSet =null;
    private static String USERNAME = "root";
    private static String PASSWORD = "123456";

    public static Connection getConnection(){
        try {
//            1、加载驱动
            Class.forName(className);
//            2、获取连接
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

////    数据库查询
//    public static void  select(Connection connection){
//        try {
//            preparedStatement = connection.prepareStatement("select * from test01 where s_score >= ? and s_score <= ?");
//            preparedStatement.setDouble(1,70);
//            preparedStatement.setDouble(2,90);
//            resultSet = preparedStatement.executeQuery();
////            遍历结果集
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("s_name"));
//                System.out.println(resultSet.getString("s_sex"));
//                System.out.println(resultSet.getDate("s_birthday"));
//                System.out.println("----------------------------------");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
////    释放资源
//    public static void closeResource(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection) throws SQLException {
//        if(resultSet != null){
//            resultSet.close();
//        }
//        if(preparedStatement != null){
//            preparedStatement.close();
//        }
//        if(connection != null){
//            connection.close();
//        }
//    }
////    测试
//public static void main(String[] args) throws SQLException {
//    connection = getConnection();
//    if(connection != null){
//        System.out.println("------连接成功--------success--");
//    }
//    else{
//        System.out.println("-------连接失败------------");
//    }
////    select(connection);
//    closeResource(resultSet,preparedStatement,connection);
//}
}
