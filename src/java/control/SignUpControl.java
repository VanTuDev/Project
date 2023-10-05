/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import context.DBContext;
import dao.DAO;
import entity.Accounts;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUpControl", urlPatterns = {"/signup"})
public class SignUpControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        DBContext.setConnection();
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String gmail = request.getParameter("gmail");
        System.out.println(user);
        System.out.println(pass);
        System.out.println(gmail);

        String repass = request.getParameter("repass");
        if (!pass.equals(repass)) {
            request.getParameter("login.jsp");
        } else {
            DAO dao = new DAO();
            Accounts accounts = dao.checkAccountsExits(user);
            
            if (accounts == null) {
                // được đăng kí
                Accounts acc = new Accounts(user, pass, 0, 0, 0, gmail);
                dao.singup(acc);
                response.sendRedirect("UserVerify");

            } else {
                // đẩy về trang register.jsp
                response.sendRedirect("register.jsp");
            }

        }

        //signup
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
