package com.example.setarehn.phage.packetsizeclaculation;

import android.content.SyncStatusObserver;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by SetarehN on 1/2/2016.
 */
public class PacketSizeCalculationMain {


    private long totalRXPktsBeforeTestCase;
    private long totalRXPktsAfterTestCase;
    public long testCaseRXPkts;
    private long totalRXBytesBeforeTestCase;
    private long totalRXBytesAfterTestCase;
    private long testCaseRXBytes;

// sent

    private long totalTXPktsBeforeTestCase;
    private long totalTXPktsAfterTestCase;
    private long testCaseTXPkts;
    private long totalTXBytesBeforeTestCase;
    private long totalTXBytesAfterTestCase;
    private long testCaseTXBytes;


    // packet loss

    private long standardNumberOfRXPkts ;
    private long standardNumberOfTXPkts ;
    private long standardBytesOfRXPkts;
    private long standardBytesOfTXPkts;
    private long numberOfTXPktLoss;
    private long numberOfRXPktsLoss;
    private long bytesOfTXPktsLoss;
    private long bytesOfRXPktsLoss;


    // hashtables




    private String nameOfTestCase;

    public String getNameOfTestCase() {
        return nameOfTestCase;
    }

    public void setNameOfTestCase(String nameOfTestCase) {
        this.nameOfTestCase = nameOfTestCase;
    }

    public PacketSizeCalculationMain() {

        this.createStandardBytesOfRXPkts();
        this.createStandardBytesOfTXPkts();
        this.createStandardNumberOfRXPkts();
        this.createStandardNumberOfTXPkts();


    }

    public void standards(String nameOfTestCase)
    {

        this.setNameOfTestCase(nameOfTestCase);

        this.setStandardNumbers();

    }



    Hashtable<String,Long> hashtable;



    public void setStandardNumbers()
    {

        hashtable = this.createStandardBytesOfRXPkts();

        this.standardBytesOfRXPkts = hashtable.get(this.getNameOfTestCase());


        hashtable = this.createStandardBytesOfTXPkts();

        this.standardBytesOfTXPkts = hashtable.get(this.getNameOfTestCase());


        hashtable = this.createStandardNumberOfRXPkts();

        this.standardNumberOfRXPkts = hashtable.get(this.getNameOfTestCase());


        hashtable = this.createStandardNumberOfTXPkts();

        this.standardNumberOfTXPkts = hashtable.get(this.getNameOfTestCase());


    }


    public Hashtable<String,Long> createStandardNumberOfRXPkts()

    {

        final Hashtable<String,Long> standardNumberOfRXPkts = new Hashtable<String,Long>();
        standardNumberOfRXPkts.put("YOUTUBE",Long.valueOf(5600));
        standardNumberOfRXPkts.put("DIRECTV",Long.valueOf(5900));



        return standardNumberOfRXPkts;


    }


    public Hashtable<String,Long> createStandardNumberOfTXPkts()

    {

        final Hashtable<String,Long> standardNumberOfTXPkts = new Hashtable<String,Long>();
        standardNumberOfTXPkts.put("YOUTUBE",Long.valueOf(5600));
        standardNumberOfTXPkts.put("DIRECTV",Long.valueOf(5900));


        return standardNumberOfTXPkts;
    }



    public Hashtable<String,Long> createStandardBytesOfRXPkts()

    {


        final Hashtable<String,Long> standardBytesOfRXPkts = new Hashtable<String,Long>();
        standardBytesOfRXPkts.put("YOUTUBE",Long.valueOf(5600));
        standardBytesOfRXPkts.put("DIRECTV",Long.valueOf(5900));


        return standardBytesOfRXPkts;
    }


    public Hashtable<String,Long> createStandardBytesOfTXPkts()

    {


        final Hashtable<String,Long> standardBytesOfTXPkts = new Hashtable<String,Long>();
        standardBytesOfTXPkts.put("YOUTUBE",Long.valueOf(300));
        standardBytesOfTXPkts.put("DIRECTV",Long.valueOf(900));

        return  standardBytesOfTXPkts;

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

    public long getStandardBytesOfRXPkts() {
        return standardBytesOfRXPkts;
    }

    public void setStandardBytesOfRXPkts(long standardBytesOfRXPkts) {
        this.standardBytesOfRXPkts = standardBytesOfRXPkts;
    }

    public long getStandardBytesOfTXPkts() {
        return standardBytesOfTXPkts;
    }

    public void setStandardBytesOfTXPkts(long standardBytesOfTXPkts) {
        this.standardBytesOfTXPkts = standardBytesOfTXPkts;
    }



    public long getTotalRXPktsBeforeTestCase() {
        return totalRXPktsBeforeTestCase;
    }

    public void setTotalRXPktsBeforeTestCase(long totalRXPktsBeforeTestCase) {
        this.totalRXPktsBeforeTestCase = totalRXPktsBeforeTestCase;
    }

    public long getTotalRXPktsAfterTestCase() {
        return totalRXPktsAfterTestCase;
    }

    public void setTotalRXPktsAfterTestCase(long totalRXPktsAfterTestCase) {
        this.totalRXPktsAfterTestCase = totalRXPktsAfterTestCase;
    }

    public long getTestCaseRXPkts() {
        return testCaseRXPkts;
    }

    public void setTestCaseRXPkts(long testCaseRXPkts) {
        this.testCaseRXPkts = testCaseRXPkts;
    }

    public long getTotalRXBytesBeforeTestCase() {
        return totalRXBytesBeforeTestCase;
    }

    public void setTotalRXBytesBeforeTestCase(long totalRXBytesBeforeTestCase) {
        this.totalRXBytesBeforeTestCase = totalRXBytesBeforeTestCase;
    }

    public long getTotalRXBytesAfterTestCase() {
        return totalRXBytesAfterTestCase;
    }

    public void setTotalRXBytesAfterTestCase(long totalRXBytesAfterTestCase) {
        this.totalRXBytesAfterTestCase = totalRXBytesAfterTestCase;
    }

    public long getTestCaseRXBytes() {
        return testCaseRXBytes;
    }

    public void setTestCaseRXBytes(long testCaseRXBytes) {
        this.testCaseRXBytes = testCaseRXBytes;
    }

    public long getTotalTXPktsBeforeTestCase() {
        return totalTXPktsBeforeTestCase;
    }

    public void setTotalTXPktsBeforeTestCase(long totalTXPktsBeforeTestCase) {
        this.totalTXPktsBeforeTestCase = totalTXPktsBeforeTestCase;
    }

    public long getTotalTXPktsAfterTestCase() {
        return totalTXPktsAfterTestCase;
    }

    public void setTotalTXPktsAfterTestCase(long totalTXPktsAfterTestCase) {
        this.totalTXPktsAfterTestCase = totalTXPktsAfterTestCase;
    }

    public long getTestCaseTXPkts() {
        return testCaseTXPkts;
    }

    public void setTestCaseTXPkts(long testCaseTXPkts) {
        this.testCaseTXPkts = testCaseTXPkts;
    }

    public long getTotalTXBytesBeforeTestCase() {
        return totalTXBytesBeforeTestCase;
    }

    public void setTotalTXBytesBeforeTestCase(long totalTXBytesBeforeTestCase) {
        this.totalTXBytesBeforeTestCase = totalTXBytesBeforeTestCase;
    }

    public long getTotalTXBytesAfterTestCase() {
        return totalTXBytesAfterTestCase;
    }

    public void setTotalTXBytesAfterTestCase(long totalTXBytesAfterTestCase) {
        this.totalTXBytesAfterTestCase = totalTXBytesAfterTestCase;
    }

    public long getTestCaseTXBytes() {
        return testCaseTXBytes;
    }

    public void setTestCaseTXBytes(long testCaseTXBytes) {
        this.testCaseTXBytes = testCaseTXBytes;
    }

    public long duringTestCaseRecievedPackets()
    {



        this.testCaseRXPkts = this.totalRXPktsAfterTestCase - this.totalRXPktsBeforeTestCase ;

      /*  if(this.testCaseRXPkts >= this.getStandardNumberOfRXPkts())
        {
            this.testCaseRXPkts = this.getStandardNumberOfRXPkts();
        }*/

        return  this.testCaseRXPkts;


    }

    public long duringTestCaseRecievedBytes()
    {

        this.testCaseRXBytes = this.totalRXBytesAfterTestCase - this.totalRXBytesBeforeTestCase;

       /* if(this.testCaseRXBytes >= this.getStandardBytesOfRXPkts())
        {
            this.testCaseRXBytes = this.getStandardBytesOfRXPkts();
        }
*/
        return this.testCaseRXBytes;

    }

    //sent



    public long duringTestCaseSentPackets()
    {

        this.testCaseTXPkts = this.totalTXPktsAfterTestCase- this.totalTXPktsBeforeTestCase ;

//        if(this.testCaseTXPkts >= this.getStandardNumberOfTXPkts())
//        {
//            this.testCaseTXPkts = this.getStandardNumberOfTXPkts();
//        }

        return  this.testCaseTXPkts;


    }

    public long duringTestCaseSentBytes()
    {
        System.out.println("TTTTTT" + this.totalTXBytesAfterTestCase + "RRRRRR" + this.totalTXBytesBeforeTestCase +
                "SSSSS" + this.testCaseTXBytes);

        this.testCaseTXBytes = this.totalTXBytesAfterTestCase - this.totalTXBytesBeforeTestCase;

        System.out.println("BBBBBBBBBBBBBBBBB"+ this.getStandardBytesOfTXPkts()+"MMMMMMM"+this.testCaseTXBytes);

       /* if(this.testCaseTXBytes >= this.getStandardBytesOfTXPkts())
        {
            this.testCaseTXBytes = this.getStandardBytesOfTXPkts();
        }
*/
        System.out.println("BBBBBBBBBBBBBBBBBd"+ this.getStandardBytesOfTXPkts()+"MMMMMMMd"+this.testCaseTXBytes);
        return this.testCaseTXBytes;

    }

    public long calNumberOfRXPacketsLoss()
    {

        this.numberOfRXPktsLoss = this.standardNumberOfRXPkts - this.testCaseRXPkts ;
        return  this.numberOfRXPktsLoss;

    }

    public long calBytesOfRXPacketsLoss()
    {

        this.bytesOfRXPktsLoss = this.standardBytesOfRXPkts - this.testCaseRXBytes ;
        return  this.bytesOfRXPktsLoss;

    }

    public long calNumberOfTXPacketsLoss()
    {

        this.numberOfTXPktLoss = this.standardNumberOfTXPkts - this.testCaseTXPkts ;
        return  this.numberOfRXPktsLoss;

    }

    public long calBytesOfTXPacketsLoss()
    {

        this.bytesOfTXPktsLoss = this.standardBytesOfTXPkts - this.testCaseTXBytes ;
        return  this.bytesOfTXPktsLoss;

    }







    public long getBytesOfRXPktsLoss() {
        return bytesOfRXPktsLoss;
    }

    public void setBytesOfRXPktsLoss(long bytesOfRXPktsLoss) {
        this.bytesOfRXPktsLoss = bytesOfRXPktsLoss;
    }

    public long getBytesOfTXPktsLoss() {
        return bytesOfTXPktsLoss;
    }

    public void setBytesOfTXPktsLoss(long bytesOfTXPktsLoss) {
        this.bytesOfTXPktsLoss = bytesOfTXPktsLoss;
    }

    public long getNumberOfRXPktsLoss() {
        return numberOfRXPktsLoss;
    }

    public void setNumberOfRXPktsLoss(long numberOfRXPktsLoss) {
        this.numberOfRXPktsLoss = numberOfRXPktsLoss;
    }

    public long getNumberOfTXPktLoss() {
        return numberOfTXPktLoss;
    }

    public void setNumberOfTXPktLoss(long numberOfTXPktLoss) {
        this.numberOfTXPktLoss = numberOfTXPktLoss;
    }







    public void displayAll()
    {


        System.out.println("TotalNumberOfRXPacketsBefore " + this.getTotalRXPktsBeforeTestCase() +

        " TotalNumberOfRXPacketsAfter " + this.getTotalRXPktsAfterTestCase() +
        " TotalNumberOfTXPacketsBefore " + this.getTotalTXPktsBeforeTestCase() +
        " TotalNumberOfTXPacketsAfter " + this.getTotalTXPktsAfterTestCase() +
        " TestCaseRXPkts " + this.getTestCaseRXPkts() +
        " TestCaseTXPkts " + this.getTestCaseTXPkts() +
        " TotalBytesOfRXPacketsAfter " + this.getTotalRXBytesBeforeTestCase() +
        " TotalBytesOfRXPacketsBefore " + this.getTotalRXBytesAfterTestCase() +
                " TotalBytesOfTXPacketsAfter " + this.getTotalTXBytesAfterTestCase() +
                " TotalBytesOfTXPacketsBefore " + this.getTotalTXBytesBeforeTestCase() +
                 " TestCaseRXBytes " + this.getTestCaseRXBytes() +
                 " TestCaseTXBytes " + this.getTestCaseTXBytes()
                 ) ;







    }









}
