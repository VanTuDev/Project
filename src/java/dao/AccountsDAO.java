/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import context.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import context.SQLDatabase;
import entity.Accounts;

/**
 *
 * @author admin
 */
public class AccountsDAO extends SQLDatabase {
    
    public AccountsDAO(Connection connection) {
        super(connection);
    }
    
    public void add(Accounts accounts) {
        executeUpdatePreparedStatement(
            "INSERT INTO accounts ( user, pass, gmail, renter, lessor)"
                + " VALUES (?, ?, ?, ?, ?)",
            accounts.getUser(),
            accounts.getPass(),
            accounts.getGmail(),
            accounts.getRenter(),
            accounts.getLessor()
            );
    }
    
public static void main(String[] args) {
    try {
        // Tạo một đối tượng Accounts mới
        Accounts newAccount = new Accounts();
        newAccount.setUser("vanhau");
        newAccount.setPass("123");
        newAccount.setGmail("nguyenuser@example.com");
        newAccount.setRenter(1); // Đặt giá trị cho renter
        newAccount.setLessor(0); // Đặt giá trị cho lessor

        // Tạo một kết nối đến cơ sở dữ liệu
        Connection conn = DBContext.getConnection();

        // Kiểm tra xem kết nối đã được thiết lập thành công
        if (conn != null) {
            // Tạo một đối tượng AccountsDAO với kết nối đã tạo
            AccountsDAO accountsDAO = new AccountsDAO(conn);

            // Gọi phương thức add để thêm tài khoản
            accountsDAO.add(newAccount);

            // Đóng kết nối
            conn.close();

            // In ra thông báo nếu thêm thành công
            System.out.println("Thêm tài khoản thành công.");
        } else {
            System.out.println("Không thể thiết lập kết nối đến cơ sở dữ liệu.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


}
