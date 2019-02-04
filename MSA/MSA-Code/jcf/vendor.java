/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcf;

public class vendor {
    private String mname;
    private String username;
    private String email;
    private int phone;
    private int mcode;
    private int mqu;
    private int status;

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setMcode(int mcode) {
        this.mcode = mcode;
    }

    public void setMqu(int mqu) {
        this.mqu = mqu;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

    public String getMname() {
        return mname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public int getMcode() {
        return mcode;
    }

    public int getMqu() {
        return mqu;
    }

    public int getStatus() {
        return status;
    }
    
}
