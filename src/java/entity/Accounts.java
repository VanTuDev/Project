/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Accounts {

    private String user;
    private String pass;
    private int renter;
    private int lessor;
    private int admins;
    private String gmail;

    

    public Accounts() {
    }

    public Accounts(String user, String pass, int renter, int lessor, int admins, String gmail) {
        this.user = user;
        this.pass = pass;
        this.renter = renter;
        this.lessor = lessor;
        this.admins = admins;
        
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRenter() {
        return renter;
    }

    public void setRenter(int renter) {
        this.renter = renter;
    }

    public int getLessor() {
        return lessor;
    }

    public void setLessor(int lessor) {
        this.lessor = lessor;
    }

    public int getAdmins() {
        return admins;
    }

    public void setAdmins(int admins) {
        this.admins = admins;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    

    @Override
    public String toString() {
        return "Accounts{" + "user=" + user + ", pass=" + pass + ", renter=" + renter + ", lessor=" + lessor + ", admins=" + admins + '}';
    }

}