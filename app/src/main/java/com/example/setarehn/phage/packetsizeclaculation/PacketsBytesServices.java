package com.example.setarehn.phage.packetsizeclaculation;

import android.util.Log;

import com.example.setarehn.phage.TestCaseInfo;

import java.util.Hashtable;

/**
 * Created by SetarehN on 1/4/2016.
 */
public class PacketsBytesServices {

    PacketSizeCalculationMain packetSizeCalculationMain;
    TestCaseInfo testCaseInfo;
    long timeBeforeTestCase;
    long packetsLatency;

    public long getPacketsLatency() {
        return packetsLatency;
    }

    public void setPacketsLatency(long packetsLatency) {
        this.packetsLatency = packetsLatency;
    }

    public PacketsBytesServices() {

        System.out.println("consssssssssss");
        packetSizeCalculationMain = new PacketSizeCalculationMain();
        testCaseInfo = new TestCaseInfo();

    }

    public PacketSizeCalculationMain getPacketSizeCalculationMain() {
        return packetSizeCalculationMain;
    }

    public void setPacketSizeCalculationMain(PacketSizeCalculationMain packetSizeCalculationMain) {
        this.packetSizeCalculationMain = packetSizeCalculationMain;
    }

    public long getTimeBeforeTestCase() {
        return timeBeforeTestCase;
    }

    public void setTimeBeforeTestCase(Long timeBeforeTestCase) {
        this.timeBeforeTestCase = timeBeforeTestCase;
    }

    public void endOfTestCaseCalculation(String nameOfTestCase)
    {

     //******** pkt loss
     /*   this.testCaseInfo = testCaseInfo;
        packetSizeCalculationMain.setStandardBytesOfTXPkts(testCaseInfo.getStandardBytesOfTXPkts());
        packetSizeCalculationMain.setStandardNumberOfTXPkts(testCaseInfo.getStandardNumberOfTXPkts());
        packetSizeCalculationMain.setStandardBytesOfRXPkts(testCaseInfo.getStandardBytesOfRXPkts());
        packetSizeCalculationMain.setStandardNumberOfRXPkts(testCaseInfo.getStandardNumberOfRXPkts());
        packetSizeCalculationMain.calBytesOfRXPacketsLoss();
        packetSizeCalculationMain.calBytesOfTXPacketsLoss();
        packetSizeCalculationMain.calNumberOfRXPacketsLoss();
        packetSizeCalculationMain.calNumberOfTXPacketsLoss();*/

        //******* end of pkt loss

        long timeAfterTestcase = System.currentTimeMillis();

        packetSizeCalculationMain.standards(nameOfTestCase);

        packetSizeCalculationMain.setTotalRXPktsAfterTestCase(android.net.TrafficStats.getTotalRxPackets());
        packetSizeCalculationMain.duringTestCaseRecievedPackets();

        packetSizeCalculationMain.setTotalRXBytesAfterTestCase(android.net.TrafficStats.getTotalRxBytes());
        packetSizeCalculationMain.duringTestCaseRecievedBytes();


        packetSizeCalculationMain.setTotalTXPktsAfterTestCase(android.net.TrafficStats.getTotalTxPackets());
        packetSizeCalculationMain.duringTestCaseSentPackets();


        packetSizeCalculationMain.setTotalTXBytesAfterTestCase(android.net.TrafficStats.getTotalTxBytes());
        packetSizeCalculationMain.duringTestCaseSentBytes();



        packetsLatency = timeAfterTestcase - timeBeforeTestCase;

        Log.d("PacketsLatency", "" + packetsLatency);
        // standardTotalPacketsForEachTestCase - totalpacketsDuringtestcase = totalpacketsLoss // we have to run total packets many times to find the static var
        //Latency : has to be done serverside inside each testcase( between actions) long start = System.currentTime....  long end = System.time - start

      //  Toast.makeText(MainActivity.this, packetSizeCalculationMain.getDuring_testcase_recieved_packets() + "", Toast.LENGTH_SHORT).show();

    }




    public void beforeTestCaseCalculation()
    {



        this.timeBeforeTestCase = System.currentTimeMillis();
        packetSizeCalculationMain.setTotalRXPktsBeforeTestCase(android.net.TrafficStats.getTotalRxPackets());
        packetSizeCalculationMain.setTotalRXBytesBeforeTestCase(android.net.TrafficStats.getTotalRxBytes());
        packetSizeCalculationMain.setTotalTXPktsBeforeTestCase(android.net.TrafficStats.getTotalTxPackets());
        packetSizeCalculationMain.setTotalTXBytesBeforeTestCase(android.net.TrafficStats.getTotalTxBytes());


    }




}
