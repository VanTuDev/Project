///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package context.database;
//
//import entity.Product;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import context.SQLDatabase;
//
///**
// *
// * @author admin
// */
//public class ProductDAO extends SQLDatabase {
//    
//    public ProductDAO(Connection connection) {
//        super(connection);
//    }
//    
//    public void add(Product t) {
//        executeUpdatePreparedStatement(
//            "INSERT INTO Product( name, image, price, title, description)"
//                + " VALUES (?, ?, ?, ?, ?)",
//            t.getName(),
//            t.getImage(),
//            t.getPrice(),
//            t.getTitle(),
//            t.getDescription()
//            );
//    }
//
//}
