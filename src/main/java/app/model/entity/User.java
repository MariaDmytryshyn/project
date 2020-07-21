package app.model.entity;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private int id;
    private String name;
    private String login;
    private String password;
    private String e_mail;
    private String mob_number;

    public enum ROLE {
        USER, ADMIN;
    }

    private ROLE role;

    private ArrayList<Orders> orders;
    private ArrayList<Bill> bills;

    public User() {
    }

    public User(String login, String password, String e_mail, String mob_number) {
        this.login = login;
        this.password = password;
        this.e_mail = e_mail;
        this.mob_number = mob_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public void setOrder(Orders order) {
        this.orders.add(order);
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBill(Bill bill) {
        this.bills.add(bill);
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getMob_number() {
        return mob_number;
    }

    public void setMob_number(String mob_number) {
        this.mob_number = mob_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name) &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                e_mail.equals(user.e_mail) &&
                mob_number.equals(user.mob_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password, e_mail, mob_number);
    }

    @Override
    public String toString() {
        return "User" +
                " id is " + id +
                ", name is " + name + '\'' +
                ", login is " + login + '\'' +
                ", password is " + password + '\'' +
                ", e-mail is " + e_mail +
                ", mobile number is " + mob_number;
    }
}

