package com.example.setarehn.phage;

/**
 * Created by SetarehN on 1/8/2016.
 */
public class TestCaseInfo {



    private String runStatus ="NOTSTART";

    private long standardNumberOfRXPkts ;
    private long standardNumberOfTXPkts ;
    private long standardBytesOfRXPkts;
    private long standardBytesOfTXPkts;


    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus;
    }

    public long getStandardNumberOfRXPkts() {
        return standardNumberOfRXPkts;
    }

    public void setStandardNumberOfRXPkts(long standardNumberOfRXPkts) {
        this.standardNumberOfRXPkts = standardNumberOfRXPkts;
    }

    public long getStandardNumberOfTXPkts() {
        return standardNumberOfTXPkts;
    }

    public void setStandardNumberOfTXPkts(long standardNumberOfTXPkts) {
        this.standardNumberOfTXPkts = standardNumberOfTXPkts;
    }

    public long getStandardBytesOfTXPkts() {
        return standardBytesOfTXPkts;
    }

    public void setStandardBytesOfTXPkts(long standardBytesOfTXPkts) {
        this.standardBytesOfTXPkts = standardBytesOfTXPkts;
    }

    public long getStandardBytesOfRXPkts() {
        return standardBytesOfRXPkts;
    }

    public void setStandardBytesOfRXPkts(long standardBytesOfRXPkts) {
        this.standardBytesOfRXPkts = standardBytesOfRXPkts;
    }
}
