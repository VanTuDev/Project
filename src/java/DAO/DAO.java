/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataBase.AccountsDAO;
import DataBase.JDBCUtil;
import static DataBase.JDBCUtil.closeConnection;
import static DataBase.JDBCUtil.setConnection;
import DataBase.UserDAO;
import entity.Account;
import entity.Accounts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Accounts login(String user, String pass) {
        String query = "SELECT * FROM accounts\n"
                + "WHERE [user] = ?\n"
                + "AND pass = ?";
        try {
            conn = new JDBCUtil().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Accounts(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11));
            }
        } catch (Exception e) {
        }
        return null;

    }

    public Accounts checkAccountExist(String user) {
        String query = "SELECT * FROM accounts\n"
                + "WHERE [user] = ?\n";

        try {
            conn = new JDBCUtil().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);

            rs = ps.executeQuery();
            while (rs.next()) {
               return new Accounts(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11));
            }
        } catch (Exception e) {
        }
        return null;

    }

    public void singup(String user, String pass) {
        String query = "  insert into accounts \n"
                + "  values ('?','?',null, null,null,null,null,null,null,null,null)";
        try {
            conn = new JDBCUtil().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        setConnection();

        AccountsDAO AccountsDAO = new AccountsDAO();
        String user = "vantu";
        String pass = "123";

        System.out.println(AccountsDAO.dLogin(user, pass));

        closeConnection();
    }
}
