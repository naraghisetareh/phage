package com.example.setarehn.phage;

import android.app.Service;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.setarehn.phage.packetsizeclaculation.PacketsBytesServices;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Hashtable;

/**
 * Created by SetarehN on 1/6/2016.
 */


public class MyService  extends Service {

    private static final String TAG = "MyService";
    MediaPlayer player;
    long start;







    PacketsBytesServices packetsBytesServices;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");

      packetsBytesServices = new PacketsBytesServices();
       player = MediaPlayer.create(this, R.raw.moon);


       player.setLooping(true); // Set looping
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");
        player.stop();
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
        player.start();





        //







        Log.d("1111111","11111");

        packetsBytesServices = new PacketsBytesServices();
        Log.d("22222", "2222222");
        //beforetestcase
        packetsBytesServices.beforeTestCaseCalculation();
        Log.d("333333", "33333");




            new StartTestCases().execute();

        Log.d("4444444", "4444");



        //Log.d("5555", "555");



        packetsBytesServices.getPacketSizeCalculationMain().displayAll();
        // end of testcase
        //doing asynk..............................................
        //  packetsBytesServices.endOfTestCaseCalculation();

        // JSON........................................
     /*   JSONObject totalPKtsRx = new JSONObject();

        try {

            totalPKtsRx.put("totalPKtsRx", packetsBytesServices.getPacketSizeCalculationMain().getDuring_testcase_recieved_packets());
            totalPKtsRx.put("totalPKtsRxBytes", packetsBytesServices.getPacketSizeCalculationMain().getDuring_testcase_recieved_bytes());
            totalPKtsRx.put("totalPKtsTx", packetsBytesServices.getPacketSizeCalculationMain().getDuring_testcase_sent_packets());
            totalPKtsRx.put("totalPKtsTxBytes", packetsBytesServices.getPacketSizeCalculationMain().getDuring_testcase_sent_bytes());

        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        // Send To Server......................................
  //      new SendDataToServer().execute();

    }








    class SendDataToServer extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void[] voids) {

            System.out.println("xxxx" + packetsBytesServices.getPacketSizeCalculationMain().testCaseRXPkts);
            String packetsRX = String.valueOf(packetsBytesServices.getPacketSizeCalculationMain().testCaseRXPkts);
            String packetsRXBytes = String.valueOf(packetsBytesServices.getPacketSizeCalculationMain().getTestCaseRXBytes());
            String packetsTX =  String.valueOf(packetsBytesServices.getPacketSizeCalculationMain().getTestCaseTXPkts());
            String packetsTXBytes = String.valueOf(packetsBytesServices.getPacketSizeCalculationMain().getTestCaseTXBytes());
            String latency = String.valueOf(packetsBytesServices.getPacketsLatency());

        /*    String URL_SEND = "http://192.168.1.102:8082/ngdemo/web/testcasesnew/data?packetsRX="+packetsRX+""+"&packetsRXBytes="+packetsRXBytes
                    +""+"&packetsTX="+packetsTX+""+"&packetsTXBytes="+packetsTXBytes+""+"&latency="+latency+"";*/

        /*    String URL_SEND = "http://192.168.1.55:8080/webservice/testcases/data?packetsRX="+packetsRX+""+"&packetsRXBytes="+packetsRXBytes
                    +""+"&packetsTX="+packetsTX+""+"&packetsTXBytes="+packetsTXBytes+""+"&latency="+latency+""; */

            //192.168.1.73

            String URL_SEND = "http://192.168.1.73:8080/phageserver/webservice/testcases/data?packetsRX="+packetsRX+""+"&packetsRXBytes="+packetsRXBytes
                    +""+"&packetsTX="+packetsTX+""+"&packetsTXBytes="+packetsTXBytes+""+"&latency="+latency+"";

            String jsonString = new JSONParser().pars(URL_SEND);

       /*     JSONObject jso;
            try {

                JSONArray ja = new JSONArray(jsonString);
                jso = ja.getJSONObject(0);
                Log.d(" response ", jso.getString("response"));

                return jso.getString("response");

            } catch (JSONException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }*/

            return "True";

        }


        @Override
        protected void onPostExecute(String s) {

            if(s.equals("True"))
            {

                Log.d("Sending..Data.To.Server", "SUCCESSFULL");

            }
            else
                Log.d("Sending..Data.To.Server", "ERROR");
        }

    }

// start testcases

    String s = "STARTT";
 //  public String URL_SELECT = "http://192.168.1.102:8082/ngdemo/web/testcasesnew/start?flag="+s+"";

// public String URL_SELECT = "http://192.168.1.55:8080/webservice/testcases/start?flag="+s+"";



    //192.168.1.73
    public String URL_SELECT = "http://192.168.1.73:8080/phageserver/webservice/testcases/start?flag="+s+"";

    class StartTestCases extends AsyncTask<Void,Void,String>{
        @Override
        protected String doInBackground(Void[] voids){



            String jsonString = new JSONParser().pars(URL_SELECT);


          //  TestCaseInfo testCaseInfo = new TestCaseInfo();
            JSONObject jso;
            try {
                JSONArray ja = new JSONArray(jsonString);
                jso = ja.getJSONObject(0);
               Log.d(" response ", jso.getString("response"));


           /*     testCaseInfo.setRunStatus(jso.getString("runStatus"));
                testCaseInfo.setStandardNumberOfRXPkts(Long.parseLong(jso.getString("standardNumberOfRXPkts")));
                testCaseInfo.setStandardBytesOfRXPkts(Long.parseLong(jso.getString("standardBytesOfRXPkts")));
                testCaseInfo.setStandardBytesOfTXPkts(Long.parseLong((jso.getString("standardBytesOfTXPkts"))));
                testCaseInfo.setStandardNumberOfTXPkts(Long.parseLong(jso.getString("standardNumberOfTXPkts")));
                */
              //  return testCaseInfo;



                return jso.getString("response");

            } catch (JSONException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            return null;


        }




            @Override
        protected void onPostExecute(String nameOfTestCase) {


                Log.d("End of TestCase", "TRUE");
                System.out.print("yes");
               // here we have to receive standard number of packet for specific test case to calculate packet loss !!

               packetsBytesServices.getPacketSizeCalculationMain().displayAll();
                packetsBytesServices.endOfTestCaseCalculation(nameOfTestCase);
                packetsBytesServices.getPacketSizeCalculationMain().displayAll();
                new SendDataToServer().execute();


        }

    }












}