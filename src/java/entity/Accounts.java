/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

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
    private String img;
    private String fullname;
    private Date dob;
    private String gender;
    private String numphone;
    private String cccd;
    private String gmail;
    private String roles;
    private String dot;
    private String wot;

    public Accounts(String user, String pass, int renter, int lessor, int admins, String img, String fullname, Date dob, String gender, String numphone, String cccd, String gmail, String roles, String dot, String wot) {
        this.user = user;
        this.pass = pass;
        this.renter = renter;
        this.lessor = lessor;
        this.admins = admins;
        this.img = img;
        this.fullname = fullname;
        this.dob = dob;
        this.gender = gender;
        this.numphone = numphone;
        this.cccd = cccd;
        this.gmail = gmail;
        this.roles = roles;
        this.dot = dot;
        this.wot = wot;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumphone() {
        return numphone;
    }

    public void setNumphone(String numphone) {
        this.numphone = numphone;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDot() {
        return dot;
    }

    public void setDot(String dot) {
        this.dot = dot;
    }

    public String getWot() {
        return wot;
    }

    public void setWot(String wot) {
        this.wot = wot;
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
        return "Accounts{" + "user=" + user + ", pass=" + pass + ", renter=" + renter + ", lessor=" + lessor + ", admins=" + admins + ", img=" + img + ", fullname=" + fullname + ", dob=" + dob + ", gender=" + gender + ", numphone=" + numphone + ", cccd=" + cccd + ", gmail=" + gmail + ", roles=" + roles + ", dot=" + dot + ", wot=" + wot + '}';
    }
    

 

   
   

}