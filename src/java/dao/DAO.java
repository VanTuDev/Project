package dao;

import context.DBContext;
import static context.DBContext.closeConnection;
import static context.DBContext.setConnection;

import entity.Accounts;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    Connection conn = DBContext.getConnection(); // câu lệnh kết nối 
    PreparedStatement ps = null; //ném câu lệnh query 
    ResultSet rs = null; // nhận kết quả trả về

    public ArrayList<Accounts> selectAllAccounts() {
        ArrayList<Accounts> listAccounts = new ArrayList<Accounts>();
        String query = "SELECT * FROM Accounts";

        try {
            // bước 1: kết nối đến CSDL
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listAccounts.add(new Accounts(rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6)));

            }
        } catch (Exception ex) {
            // Thông báo lỗi ra 
            ex.printStackTrace();
        }
        return listAccounts;

    }

//      public static void main(String[] args) {
//        DBContext.setConnection();
//        DAO dao = new DAO();
//        List<Accounts> listAccounts = dao.selectAllAccounts();
//        for (Accounts accounts : listAccounts) {
//            System.out.println(accounts);
//
//        }
//    }
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product";

        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4),
                    rs.getString(5),
                    rs.getString(6)));
            }
            // in ra lỗi nếu không thể seclect table "product"
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    //test đã đẩy dữ liệu từ sql Products lên chưa
//    public static void main(String[] args) {
//        DBContext.setConnection();
//        DAO dao = new DAO();
//        List<Product> listP = dao.getAllProduct();
//        for (Product Product : listP) {
//            System.out.println(Product);
//            
//        }
//    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                    rs.getString(2)));
            }
            // in ra lỗi nếu không thể seclect table "Category"
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    // test đã đẩy dữ liệu từ sql Category lên chưa
//    public static void main(String[] args) {
//        DBContext.setConnection();
//        DAO dao = new DAO();
//        List<Category> listCC = dao.getAllCategory();
//        for (Category Category : listCC) {
//            System.out.println(Category);
//
//        }
//
//        // in ra  Product
//        List<Product> listP = dao.getAllProduct();
//        for (Product Product : listP) {
//            System.out.println(Product);
//        }
//    }
    public Product getLast() {

        String query = " select top 1 *  from product\n"
            + "order by id desc ";

        try {

            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4),
                    rs.getString(5),
                    rs.getString(6));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where cateID = ?";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);

            if (cid != null) {
                ps.setString(1, cid);
                rs = ps.executeQuery();

                while (rs.next()) {
                    list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
                }
            } else {

                System.out.println("CID không hợp lệ");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
//    public static void main(String[] args) {
//        // Mở kết nối đến cơ sở dữ liệu
//        DBContext.setConnection();
//        
//        DAO dao = new DAO();
//        
//        // Thay thế "your_cid_here" bằng giá trị mã danh mục (Category ID) mà bạn muốn truy vấn
//        String cid = "2";
//        
//        List<Product> productsByCategory = dao.getProductByCID(cid);
//        
//        if (productsByCategory.isEmpty()) {
//            System.out.println("Không tìm thấy sản phẩm cho Category ID: " + cid);
//        } else {
//            System.out.println("Danh sách sản phẩm cho Category ID: " + cid);
//            for (Product product : productsByCategory) {
//                System.out.println("ID: " + product.getId());
//                System.out.println("Tên sản phẩm: " + product.getName());
//                System.out.println("Giá: " + product.getPrice());
//                System.out.println("Mô tả: " + product.getDescription());
//                System.out.println("-------------------------------");
//            }
//        }
//        
//        // Đóng kết nối đến cơ sở dữ liệu
//        DBContext.closeConnection();
//    }

    public Product getProductByID(String id) {

        String query = "select *from product\n"
            + " where id = ?";

        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4),
                    rs.getString(5),
                    rs.getString(6));
            }
            // in ra lỗi nếu không thể seclect table "product"
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }
//    public static void main(String[] args) {
//    // Mở kết nối đến cơ sở dữ liệu
//    DBContext.setConnection();
//    
//    DAO dao = new DAO();
//    
//    // Thay thế "your_product_id_here" bằng mã sản phẩm (Product ID) mà bạn muốn truy vấn
//    String productId = "2";
//    
//    Product product = dao.getProductByID(productId);
//    
//    if (product != null) {
//        System.out.println("Thông tin sản phẩm:");
//        System.out.println("ID: " + product.getId());
//        System.out.println("Tên sản phẩm: " + product.getName());
//        System.out.println("Giá: " + product.getPrice());
//        System.out.println("Mô tả: " + product.getDescription());
//    } else {
//        System.out.println("Không tìm thấy sản phẩm có ID: " + productId);
//    }
//    
//    // Đóng kết nối đến cơ sở dữ liệu
//    DBContext.closeConnection();
//}

    public Accounts login(String user, String pass) {
        String query = "select * from accounts\n"
            + " where [user] = ?\n"
            + " and pass = ?";
        try {
            Connection conn = DBContext.getConnection();
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
                    rs.getString(6));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // check tài khoản mật khẩu
//   public static void main(String[] args) {
//    DBContext.setConnection();
//    DAO dao = new DAO();
//    String user = "vantu"; // Thay thế bằng tên đăng nhập thực tế của bạn
//    String pass = "123"; // Thay thế bằng mật khẩu thực tế của bạn
//    Accounts accounts = dao.login(user, pass);
//
//    if (accounts != null) {
//        System.out.println("Đăng nhập thành công!");
//        System.out.println("Thông tin tài khoản:");
//        System.out.println("Tên đăng nhập: " + accounts.getUser());
//        System.out.println("Mật khẩu: " + accounts.getPass());
//        System.out.println("Renter: " + accounts.getRenter());
//        System.out.println("Lessor: " + accounts.getLessor());
//        System.out.println("Admins: " + accounts.getAdmins());
//    } else {
//        System.out.println("Đăng nhập thất bại");
//    }
//}
    public Accounts checkAccountsExits(String user) {
        String query = "select * from accounts\n"
            + " where [user] = ?\n";

        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Accounts(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int singup(Accounts accounts) {
    int result = 0;
    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = DBContext.getConnection();
        String query = "INSERT INTO accounts (user, pass, gmail) VALUES (?,?,?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, accounts.getUser());
        ps.setString(2, accounts.getPass());
        ps.setString(3, accounts.getGmail());

        // Bước 3: thực thi câu lệnh SQL
        result = ps.executeUpdate();

        // Bước 4:
        System.out.println("Bạn đã thực thi: " + query);
        System.out.println("Có " + result + " dòng bị thay đổi!");

    } catch (Exception ex) {
        // Xử lý lỗi
        ex.printStackTrace();
    } finally {
        // Đảm bảo rằng PreparedStatement được đóng ngay cả khi xảy ra lỗi
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Đảm bảo rằng kết nối được đóng ngay cả khi xảy ra lỗi
        DBContext.closeConnection();
    }

    return result;
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

        // Tạo một đối tượng DAO để thực hiện việc thêm tài khoản
        DAO dao = new DAO();

        // Gọi phương thức singup để thêm tài khoản
        int result = dao.singup(newAccount);

        if (result > 0) {
            System.out.println("Thêm tài khoản thành công.");
        } else {
            System.out.println("Thêm tài khoản thất bại.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        // Đảm bảo rằng kết nối được đóng ngay cả khi xảy ra lỗi
        DBContext.closeConnection();
    }
}
}
