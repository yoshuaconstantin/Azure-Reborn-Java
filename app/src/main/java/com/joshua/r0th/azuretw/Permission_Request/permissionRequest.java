package com.joshua.r0th.azuretw.Permission_Request;

import com.joshua.r0th.azuretw.root_utils.RootUtils;

public class permissionRequest {
    RootUtils rootUtils = new RootUtils();

    public void AllCpuPermission(){
        ///Max Freq
        rootUtils.chmod("/sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq","755");
        rootUtils.chmod("/sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq","755");
        rootUtils.chmod("/sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq","755");

        ///Min Freq
        rootUtils.chmod("/sys/devices/system/cpu/cpufreq/policy0/scaling_min_freq","755");
        rootUtils.chmod("/sys/devices/system/cpu/cpufreq/policy4/scaling_min_freq","755");
        rootUtils.chmod("/sys/devices/system/cpu/cpufreq/policy7/scaling_min_freq","755");
    }



}
