/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcf;
public class Morder {
    private int orderid;
    private int no;
    private int optotal;
    private int sptotal;
    private int status;
    private String address;
    private String username;

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setOptotal(int optotal) {
        this.optotal = optotal;
    }

    public void setSptotal(int sptotal) {
        this.sptotal = sptotal;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrderid() {
        return orderid;
    }

    public int getNo() {
        return no;
    }

    public int getOptotal() {
        return optotal;
    }

    public int getSptotal() {
        return sptotal;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }
    public int getStatus() {
        return status;
    }
}
