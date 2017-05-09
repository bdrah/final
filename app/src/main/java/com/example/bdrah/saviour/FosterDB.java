package com.example.bdrah.saviour;

/**
 * Created by RHF on 14/03/2017.
 */

public class FosterDB {

    private long FID;
    //should put time date of report
    private String pName;
    private byte pic;
    private String description;
    private String location;
    private String FPhone;
    private Register REG_F_ID;

    public FosterDB(String pName, String description, String location,
                    String FPhone, Register REG_F_ID, String needRate,
                    String type, String phone, byte pic) {
        this.pName = pName;
        this.description = description;
        this.location = location;
        this.FPhone = FPhone;
        this.REG_F_ID = REG_F_ID;
        this.needRate = needRate;
        this.type = type;
        this.phone = phone;
        this.pic = pic;
    }

    public byte getPic() {
        return pic;
    }

    public void setPic(byte pic) {
        this.pic = pic;
    }

    public String getFPhone() {
        return FPhone;
    }

    public Register getREG_F_ID() {
        return REG_F_ID;
    }

    public void setREG_F_ID(Register REG_F_ID) {
        this.REG_F_ID = REG_F_ID;
    }

    public void setFPhone(String FPhone) {
        this.FPhone = FPhone;
    }

    public String getNeedRate() {
        return needRate;
    }

    public void setNeedRate(String needRate) {
        this.needRate = needRate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String needRate;
    private String type;



    public long getFID() {
        return FID;
    }

    public void setFID(long FID) {
        this.FID = FID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone ;



}
