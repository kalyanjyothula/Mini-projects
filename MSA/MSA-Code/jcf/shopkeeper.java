
package jcf;

public class shopkeeper {
    private  String username;
    private  String email;
    private int mobile;
    private int orderid;
    private int approve;
    private int available;

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getAvailable() {
        return available;
    }

    public int getOrderid() {
        return orderid;
    }

    public int getApprove() {
        return approve;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setApprove(int approve) {
        this.approve = approve;
    }
    
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    
}
