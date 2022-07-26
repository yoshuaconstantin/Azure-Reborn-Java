package com.joshua.r0th.azuretw.Snapdragon_param;

import java.io.IOException;

public class SD888CPU_TWEAK {
    /**  DOCUMENTATION
     * Policy(X) itu adalah core yang di ambil untuk di set manual
     * Up_rate_limit_us = seberapa cepat freq bakal naik di Gov Schedutil dalam bentuk MS (mili detik)
     * Down_rate_limit_us = seberapa cepat freq bakal turun di Gov Schedutil dalam bentuk MS (mili detik)
     * Scaling Max / Min Freq = maskimal dan minimal Freq yang bisa di capai sistem
     * Policy 0-3 Silver Core (A55), 3-6 Gold Core (A78), 7 Prime Core (X1)
     * Tabel Freq sebagai berikut. tinggal copy paste (Snapdragon 888 )
     * Silver 0 -3
     * 300000 403200 499200 595200 691200 806400 902400 998400 1094400 1209600 1305600 1401600 1497600 1612800 1708800 1804800
     * Gold 4 -6
     * 710400 844800 960000 1075200 1209600 1324800 1440000 1555200 1670400 1766400 1881600 1996800 2112000 2227200 2342400 2419200
     * Prime 7
     * 844800 960000 1075200 1190400 1305600 1420800 1555200 1670400 1785600 1900800 2035200 2150400 2265600 2380800 2496000 2592000 2688000 2764800 2841600
     * @return
     */

    public void chill(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                            //silver
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"1209600\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;"+
                            " echo \"300000\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_min_freq;"+
                            //gold
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy4/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy4/schedutil/up_rate_limit_us;"+
                            " echo \"1209600\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq;"+
                            " echo \"710400\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_min_freq;"+
                            //prime
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy7/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy7/schedutil/up_rate_limit_us;"+
                            " echo \"1075200\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq;"+
                            " echo \"844800\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_min_freq;"+
                            " setprop azureSDmode 1"});

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void smarcasual(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                    //silver
                    " echo 0 > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"1497600\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;"+
                            " echo \"300000\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_min_freq;"+
                            //gold
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy4/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy4/schedutil/up_rate_limit_us;"+
                            " echo \"2112000\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq;"+
                            " echo \"710400\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_min_freq;"+
                            //prime
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy7/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy7/schedutil/up_rate_limit_us;"+
                            " echo \"2035200\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq;"+
                            " echo \"844800\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_min_freq;"+
                            " setprop azureSDmode 2"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fastaf (){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                    //silver
                    " echo 0 > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"1804800\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;"+
                            " echo \"300000\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_min_freq;"+
                            //gold
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy4/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy4/schedutil/up_rate_limit_us;"+
                            " echo \"2419200\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq;"+
                            " echo \"710400\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_min_freq;"+
                            //prime
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy7/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy7/schedutil/up_rate_limit_us;"+
                            " echo \"2841600\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq;"+
                            " echo \"844800\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_min_freq;"+
                            " setprop azureSDmode 4"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void lazy(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                    //silver
                    " echo 0 > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"1804800\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;"+
                            " echo \"806400\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_min_freq;"+
                            //gold
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy4/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy4/schedutil/up_rate_limit_us;"+
                            " echo \"2419200\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq;"+
                            " echo \"1075200\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_min_freq;"+
                            //prime
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy7/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy7/schedutil/up_rate_limit_us;"+
                            " echo \"2841600\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq;"+
                            " echo \"844800\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_min_freq;"+
                            " setprop azureSDmode 1"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void defaultSD(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                    //silver
                    " echo 0 > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"1804800\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;"+
                            " echo \"806400\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_min_freq;"+
                            //gold
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy4/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy4/schedutil/up_rate_limit_us;"+
                            " echo \"2419200\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq;"+
                            " echo \"1075200\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_min_freq;"+
                            //prime
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy7/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy7/schedutil/up_rate_limit_us;"+
                            " echo \"2841600\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq;"+
                            " echo \"844800\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_min_freq;"+
                            " setprop azureSDmode 5"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
