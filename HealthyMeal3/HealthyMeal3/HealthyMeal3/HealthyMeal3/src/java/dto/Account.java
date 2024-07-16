/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author PC
 */
public class Account {

    private int id;
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private String address;
    private boolean role;
    private boolean status;
    private String avatar;

    public Account() {
    }

    public Account(int id, String email, String password, String fullname, boolean role, boolean status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.status = status;
    }

    public Account(int id, String email, String password, String fullname, String phone, String address, boolean role, boolean status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Account(int id, String email, String password, String fullname, String phone, String address, boolean role, boolean status, String avatar) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.status = status;
        this.avatar = avatar;
    }

    public Account(int id, String email, String password, String fullname, String phone, String address, boolean role, String avatar) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.avatar = avatar;
    }

    
   

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", email=" + email + ", password=" + password + ", fullname=" + fullname + ", phone=" + phone + ", address=" + address + ", role=" + role + ", status=" + status + '}';
    }

}
