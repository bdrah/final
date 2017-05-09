package com.example.bdrah.saviour;

/**
 * Created by RHF on 15/04/2017.
 */

public class DonateDB {
    private long DID;
    private Register REG_D_ID;
    private FosterDB FOST_D_ID;

    public DonateDB(Register REG_D_ID, FosterDB FOST_D_ID) {
        this.REG_D_ID = REG_D_ID;
        this.FOST_D_ID = FOST_D_ID;
    }

    public long getDID() {
        return DID;
    }

    public void setDID(long DID) {
        this.DID = DID;
    }



    public Register getREG_D_ID() {
        return REG_D_ID;
    }

    public void setREG_D_ID(Register REG_D_ID) {
        this.REG_D_ID = REG_D_ID;
    }

    public FosterDB getFOST_D_ID() {
        return FOST_D_ID;
    }

    public void setFOST_D_ID(FosterDB FOST_D_ID) {
        this.FOST_D_ID = FOST_D_ID;
    }
}
