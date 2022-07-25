package com.joshua.r0th.azuretw.tweak;

import com.joshua.r0th.azuretw.root_utils.RootUtils;

import java.io.IOException;

public class thermal_tweak {
    public void thermalNumber (String number){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c", " echo $number > /sys/devices/virtual/thermal/thermal_message/sconfig", number});

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
