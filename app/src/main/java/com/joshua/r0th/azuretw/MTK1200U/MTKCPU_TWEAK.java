package com.joshua.r0th.azuretw.MTK1200U;

import java.io.IOException;

public class MTKCPU_TWEAK {
    /**  DOCUMENTATION
     * Policy(X) itu adalah core yang di ambil untuk di set manual
     * Up_rate_limit_us = seberapa cepat freq bakal naik di Gov Schedutil dalam bentuk MS (mili detik)
     * Down_rate_limit_us = seberapa cepat freq bakal turun di Gov Schedutil dalam bentuk MS (mili detik)
     * Scaling Max / Min Freq = maskimal dan minimal Freq yang bisa di capai sistem
     * 0-3 Silver Core (A55), 3-6 Gold Core (A78), 7 Prime Core (X1)
     */



    public void chill(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                    " echo 501 > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy6/schedutil/down_rate_limit_us;"+
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy6/schedutil/up_rate_limit_us;" +
                            " chmod 755 > /sys/devices/system/cpu/cpufreq/policy6/scaling_max_freq;" +
                            " chmod 755 > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy6/scaling_max_freq;"+
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;" +
                            " setprop azureappseas 1;"+
                            " setprop azureapps 1"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void smarcasual(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                    " echo \"402\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"402\" > /sys/devices/system/cpu/cpufreq/policy6/schedutil/down_rate_limit_us;"+
                            " echo \"2402\"> /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"3402\" > /sys/devices/system/cpu/cpufreq/policy6/schedutil/up_rate_limit_us;" +
                            " chmod 755 > /sys/devices/system/cpu/cpufreq/policy6/scaling_max_freq;" +
                            " chmod 755 > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;" +
                            " echo \"2208000\" > /sys/devices/system/cpu/cpufreq/policy6/scaling_max_freq;"+
                            " echo \"1804800\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;" +
                            " setprop azureappseas 3;"+
                            " setprop azureapps 2"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fastaf (){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                    " echo \"100\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"100\" > /sys/devices/system/cpu/cpufreq/policy6/schedutil/down_rate_limit_us;"+
                            " echo 100 > /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"100\" > /sys/devices/system/cpu/cpufreq/policy6/schedutil/up_rate_limit_us;" +
                            " chmod 755 > /sys/devices/system/cpu/cpufreq/policy6/scaling_max_freq;" +
                            " chmod 755 > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;" +
                            " echo \"2208000\" > /sys/devices/system/cpu/cpufreq/policy6/scaling_max_freq;"+
                            " echo \"1804800\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;" +
                            " setprop azureappseas 5;"+
                            " setprop azureapps 3"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void lazy(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                    " echo \"9\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"9\" > /sys/devices/system/cpu/cpufreq/policy6/schedutil/down_rate_limit_us;"+
                            " echo \"7000\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"12000\" > /sys/devices/system/cpu/cpufreq/policy6/schedutil/up_rate_limit_us;" +
                            " chmod 755 > /sys/devices/system/cpu/cpufreq/policy6/scaling_max_freq;" +
                            " chmod 755 > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;" +
                            " echo \"1017600\" > /sys/devices/system/cpu/cpufreq/policy6/scaling_max_freq;"+
                            " echo \"748800\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;" +
                            " setprop azureappseas 6;"+
                            " setprop azureapps 4"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void defaulteas(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                    " echo 1000 > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"1000\" > /sys/devices/system/cpu/cpufreq/policy6/schedutil/down_rate_limit_us;"+
                            " echo 1000 > /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"1000\" > /sys/devices/system/cpu/cpufreq/policy6/schedutil/up_rate_limit_us;" +
                            " echo \"2208000\" > /sys/devices/system/cpu/cpufreq/policy6/scaling_max_freq;"+
                            " echo \"1804800\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;" +
                            " setprop azureappseas 9;"+
                            " setprop azureapps 5"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
