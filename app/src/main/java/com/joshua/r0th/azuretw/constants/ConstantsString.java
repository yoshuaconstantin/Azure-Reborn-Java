package com.joshua.r0th.azuretw.constants;

public class ConstantsString {
    //Shell Script
    public static String silverCoreMaxFreq = "cat /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq | awk '{print $1/1000}'";
    public static String goldCoreMaxFreq ="cat /sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq | awk '{print $1/1000}'";
    public static String primeCoreMaxFreq="cat /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq | awk '{print $1/1000}'";
    public static String gpuMaxFreq = "cat /sys/class/kgsl/kgsl-3d0/max_gpuclk | awk '{print $1/1000000}'";
    public static String memTotal = "cat /proc/meminfo | grep MemTotal | awk '{print $2}'";
    public static String memFree = "cat /proc/meminfo | grep MemAvailable | awk '{print $2}'";
    public static String thermalZone0 ="cat /sys/class/thermal/thermal_zone1/temp | awk '{print $1/1000}'";


    //ConstString
    public static String txtSD888 ="Snapdragon 888 / SM350. 8 Core, 3 Cluster";
    public static String txtSD870 ="Snapdragon 870. 8 Core, 3 Cluster";
    public static String txtDM1200 = "Mediatek Dimensity 1200. 8 Core, 3 Cluster\"";
    public static String txtSilverCore ="Silver Core Max Freq : ";
    public static String txtGoldCore="Gold Core Max Freq : ";
    public static String txtPrimeCore="Prime Core Max Freq : ";
    public static String txtGpuMaxFreq ="GPU Max Freq : ";
    public static String txtMemFree="Memory Free : ";
    public static String txtMemUsed="Memory Used : ";
    public static String txtBatteryTemp = "Battery Temp : ";
    public static String txtThermalZone0= "Thermal Zone 0 : ";

}
