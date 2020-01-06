package com.remoter.mintdroid.mintdroid;

/**
 * Created by zhengnie on 4/23/17.
 */

import com.ericsson.TV.clientPairing.Pairing;
import com.ericsson.TV.clientPairing.HttpCompanion;


public class StbCommunicationThread extends Thread
{
    private String ip;
    private String key;
    private final String cmd = "op=remotekey&key=";
    private final String testPairStr = "TESTPAIRTESTPAIR";
    private final String testDeviceId = "AB72527A-582D-4d6d-98DD-3DDCD4E00EC4";

    public StbCommunicationThread(String Ip,String Key)
    {
        ip = Ip;
        key = Key;
    }


    public void run()
    {
        try {
            Pairing p = new Pairing(testDeviceId, testPairStr, ip, ip);
            HttpCompanion httpCompanion = new HttpCompanion(p);
            httpCompanion.Send(cmd + key);
        }
        catch (Exception e)
        {
           System.out.println(e.getMessage());
        }
    }

}
