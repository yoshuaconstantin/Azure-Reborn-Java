package com.joshua.r0th.azuretw.tweak;

import android.os.Handler;

import com.joshua.r0th.azuretw.MainActivity;
import com.joshua.r0th.azuretw.root_utils.RootUtils;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class thermal_tweak {
    Runnable r;
    Handler handler;

    public void thermalNumber (String number) {
        chmod444();
        thermalset(number);
        chmod755();
    }

    private void chmod444(){
        handler = new Handler();
        r = new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                RootUtils.chmod("/sys/devices/virtual/thermal/thermal_message/sconfig","444");
                handler.postDelayed(this, 500);
            }
        };
        handler.postDelayed(r, 0);
    }
    private void chmod755(){
        RootUtils.chmod("/sys/devices/virtual/thermal/thermal_message/sconfig","755");
    }
    private void thermalset (String number){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c", " echo $number > /sys/devices/virtual/thermal/thermal_message/sconfig", number});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String searchMode(String number){
        String result = "DEFAULT";
        switch (number){
            case "-1":
                result = "DEFAULT";
                break;
            case "0":
                result = "RESTORE";
                break;
            case "2":
                result = "EXTREME";
                break;
            case "8":
                result = "IN CALL";
                break;
            case "9":
                result = "GAME";
                break;
            case "10":
                result = "DYNAMIC";
                break;
            case "11":
                result = "CLASS 0";
                break;
            case "12":
                result = "CAMERA";
                break;
            case "13":
                result = "GAME 2";
                break;
            case "14":
                result = "YOUTUBE";
                break;
            case "15":
                result = "AR/VR";
                break;
            case "16":
                result = "GAME 3";
                break;

        }
        return result;
    }
}
