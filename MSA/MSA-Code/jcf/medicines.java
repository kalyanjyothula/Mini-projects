package jcf;
public class medicines {
    private int MCODE;
    private int VENDORPHONE;
    private int PPRICE;
    private int SPRICE;
    private int THVALUE;
    private int MQUANTITY;
    private String TRADENAME;
    private String GENERICNAME;
    private String MNAME;
    private String VENDORNAME;

    public medicines(int MCODE, int VENDORPHONE, int PPRICE, int SPRICE, int THVALUE, int MQUANTITY, String TRADENAME, String GENERICNAME, String MNAME, String VENDORNAME) {
        this.MCODE = MCODE;
        this.VENDORPHONE = VENDORPHONE;
        this.PPRICE = PPRICE;
        this.SPRICE = SPRICE;
        this.THVALUE = THVALUE;
        this.MQUANTITY = MQUANTITY;
        this.TRADENAME = TRADENAME;
        this.GENERICNAME = GENERICNAME;
        this.MNAME = MNAME;
        this.VENDORNAME = VENDORNAME;
    }

    public medicines() {
    }

    
    
    public int getMCODE() {
        return MCODE;
    }

    public int getVENDORPHONE() {
        return VENDORPHONE;
    }

    public int getPPRICE() {
        return PPRICE;
    }

    public int getSPRICE() {
        return SPRICE;
    }

    public int getTHVALUE() {
        return THVALUE;
    }

    public int getMQUANTITY() {
        return MQUANTITY;
    }

    public String getTRADENAME() {
        return TRADENAME;
    }

    public String getGENERICNAME() {
        return GENERICNAME;
    }

    public String getMNAME() {
        return MNAME;
    }

    public String getVENDORNAME() {
        return VENDORNAME;
    }

    public void setMCODE(int MCODE) {
        this.MCODE = MCODE;
    }

    public void setVENDORPHONE(int VENDORPHONE) {
        this.VENDORPHONE = VENDORPHONE;
    }

    public void setPPRICE(int PPRICE) {
        this.PPRICE = PPRICE;
    }

    public void setSPRICE(int SPRICE) {
        this.SPRICE = SPRICE;
    }

    public void setTHVALUE(int THVALUE) {
        this.THVALUE = THVALUE;
    }

    public void setMQUANTITY(int MQUANTITY) {
        this.MQUANTITY = MQUANTITY;
    }

    public void setTRADENAME(String TRADENAME) {
        this.TRADENAME = TRADENAME;
    }

    public void setGENERICNAME(String GENERICNAME) {
        this.GENERICNAME = GENERICNAME;
    }

    public void setMNAME(String MNAME) {
        this.MNAME = MNAME;
    }

    public void setVENDORNAME(String VENDORNAME) {
        this.VENDORNAME = VENDORNAME;
    }


   
}
