package com.joshua.r0th.azuretw.tweak;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class dozetweak extends AppCompatActivity {

    //random doze timing tuned by joshua
    public void randomDozeTweak(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c", "settings put global device_idle_constants light_after_inactive_to=10000,"+
                    "light_pre_idle_to=5000,"+
                    "light_max_idle_to=3000000,"+
                    "light_idle_to=10000000,"+
                    "light_idle_maintenance_max_budget=500000,"+
                    "light_idle_maintenance_min_budget=500000,"+
                    "min_time_to_alarm=300000,inactive_to=50000,"+
                    "motion_inactive_to=200000,"+
                    "idle_after_inactive_to=100000,"+
                    "locating_to=60000,sensing_to=100000,"+
                    "idle_to=1800000"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //this time ignore deep doze and use light doze mimic deep doze timing
    public void LighdozeTiming(){
        try {
            //New Method reduce superuser notif spam !
                Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c", "settings put global device_idle_constants inactive_to=2592000000,"+
                            "motion_inactive_to=2592000000,"+
                            "light_after_inactive_to=3000000,"+
                            "light_max_idle_to=21600000,"+
                            "light_idle_to=3600000,"+
                            "light_idle_maintenance_max_budget=600000,"+
                            "min_light_maintenance_time=30000"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DozeMimic(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c", "settings put global device_idle_constants inactive_to=2592000000,"+
                    "motion_inactive_to=2592000000,"+
                    "light_after_inactive_to=20000,"+
                    "light_pre_idle_to=30000,"+
                    "light_max_idle_to=86400000,"+
                    "light_idle_to=1800000,"+
                    "light_idle_factor=1.5,"+
                    "light_idle_maintenance_max_budget=30000,"+
                    "light_idle_maintenance_min_budget=10000,"+
                    "min_time_to_alarm=60000"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void dozeDeep(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c", "settings put global device_idle_constants light_after_inactive_to=2592000000"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void removedozesetting(){

        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c", "settings delete global device_idle_constants"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enabledoze(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c", "dumpsys deviceidle enable"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void instantDoze(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c", "dumpsys deviceidle force-idle"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
