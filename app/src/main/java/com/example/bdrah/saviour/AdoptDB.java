package com.example.bdrah.saviour;

/**
 * Created by RHF on 09/03/2017.
 */

public class AdoptDB {

    private String AName;
    private long AID;
    private String AEmail;
    private String numberOfP;
    private Register REG_A_ID;
    private FosterDB FOST_A_ID;

    public Register getREG_A_ID() {
        return REG_A_ID;
    }

    public void setREG_A_ID(Register REG_A_ID) {
        this.REG_A_ID = REG_A_ID;
    }

    public FosterDB getFOST_A_ID() {
        return FOST_A_ID;
    }

    public void setFOST_A_ID(FosterDB FOST_A_ID) {
        this.FOST_A_ID = FOST_A_ID;
    }

    AdoptDB(String AName, long AID, String AEmail, String numberOfP, Register REG_A_ID, FosterDB FOST_A_ID){
        this.AName = AName;
        this.AID = AID;
        this.AEmail = AEmail;
        this.numberOfP = numberOfP;
        this.FOST_A_ID = FOST_A_ID;
        this.REG_A_ID = REG_A_ID;



    }

    public long getAID() {
        return AID;
    }

    public void setAID(long AID) {
        this.AID = AID;
    }


    public String getAName() {
        return AName;
    }

    public void setAName(String AName) {
        this.AName = AName;
    }

    public String getAEmail() {
        return AEmail;
    }

    public void setAEmail(String AEmail) {
        this.AEmail = AEmail;
    }

    public String getNumberOfP() {
        return numberOfP;
    }

    public void setNumberOfP(String numberOfP) {
        this.numberOfP = numberOfP;
    }


}
