package com.joshua.r0th.azuretw.Snapdragon_param;

import java.io.IOException;

public class SD870CPU_TWEAK {

    /**  DOCUMENTATION
     * Policy(X) itu adalah core yang di ambil untuk di set manual
     * Up_rate_limit_us = seberapa cepat freq bakal naik di Gov Schedutil dalam bentuk MS (mili detik)
     * Down_rate_limit_us = seberapa cepat freq bakal turun di Gov Schedutil dalam bentuk MS (mili detik)
     * Scaling Max / Min Freq = maskimal dan minimal Freq yang bisa di capai sistem
     * Policy 0-3 Silver Core (A55), 3-6 Gold Core (A78), 7 Prime Core (A78)
     * Tabel Freq sebagai berikut. tinggal copy paste (Snapdragon 870 )
     * Silver 0 -3
     * 300000 403200 518400 614400 691200 787200 883200 979200 1075200 1171200 1248000 1344000 1420800 1516800 1612800 1708800 1804800
     * Gold 4 -6
     * 710400 825600 940800 1056000 1171200 1286400 1382400 1478400 1574400 1670400 1766400 1862400 1958400 2054400 2150400 2246400 2342400 2419200
     * Prime 7
     * 844800 960000 1075200 1190400 1305600 1401600 1516800 1632000 1747200 1862400 1977600 2073600 2169600 2265600 2361600 247600 2553600 2649600 2745600 2841600 3187200
     * @return
     */

    public void chill(){
        try {
            //New Method reduce superuser notif spam !
            Runtime.getRuntime().exec(new String[]{"system/bin/su", "-c",
                    //silver
                    " echo 0 > /sys/devices/system/cpu/cpufreq/policy0/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy0/schedutil/up_rate_limit_us;"+
                            " echo \"1248000\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;"+
                            " echo \"300000\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_min_freq;"+
                            //gold
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy4/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy4/schedutil/up_rate_limit_us;"+
                            " echo \"1286400\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq;"+
                            " echo \"710400\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_min_freq;"+
                            //prime
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy7/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy7/schedutil/up_rate_limit_us;"+
                            " echo \"1190400\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq;"+
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
                            " echo \"1420800\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;"+
                            " echo \"300000\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_min_freq;"+
                            //gold
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy4/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy4/schedutil/up_rate_limit_us;"+
                            " echo \"2054400\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq;"+
                            " echo \"710400\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_min_freq;"+
                            //prime
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy7/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy7/schedutil/up_rate_limit_us;"+
                            " echo \"2265600\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq;"+
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
                            " echo \"3187200\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq;"+
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
                            " echo \"\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq;"+
                            " echo \"\" > /sys/devices/system/cpu/cpufreq/policy0/scaling_min_freq;"+
                            //gold
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy4/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy4/schedutil/up_rate_limit_us;"+
                            " echo \"\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq;"+
                            " echo \"\" > /sys/devices/system/cpu/cpufreq/policy4/scaling_min_freq;"+
                            //prime
                            " echo 0 > /sys/devices/system/cpu/cpufreq/policy7/schedutil/down_rate_limit_us;" +
                            " echo \"0\" > /sys/devices/system/cpu/cpufreq/policy7/schedutil/up_rate_limit_us;"+
                            " echo \"\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq;"+
                            " echo \"\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_min_freq;"+
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
                            " echo \"3187200\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq;"+
                            " echo \"844800\" > /sys/devices/system/cpu/cpufreq/policy7/scaling_min_freq;"+
                            " setprop azureSDmode 5"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
