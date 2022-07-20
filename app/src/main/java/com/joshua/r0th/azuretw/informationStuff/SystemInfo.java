package com.joshua.r0th.azuretw.informationStuff;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.widget.TextView;

import com.joshua.r0th.azuretw.constants.ConstantsString;
import com.joshua.r0th.azuretw.root_utils.RootUtils;

import org.w3c.dom.Text;

public class SystemInfo {
    final RootUtils.SU su = new RootUtils.SU(false, null);

    public void CPU_info(String ProcType, TextView procText, TextView producname, TextView silverText, TextView goldText, TextView primeText, TextView gpuMaxText,
                         TextView memFree, TextView memUsedText, TextView battText, TextView therm0Text, Activity activity){
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = activity.registerReceiver(null, ifilter);
        if (ProcType.equals("SM350")){
            producname.setText("Xiaomi 11T Pro / Villi");
            procText.setText(ConstantsString.txtSD888);
        }else if(ProcType.equals("SD870")){
            producname.setText("Smarphone X");
            procText.setText(ConstantsString.txtSD870);
        }
        else{
            producname.setText("Xiaomi 11T  / Agate");
            procText.setText(ConstantsString.txtDM1200);
        }
        silverText.setText(ConstantsString.txtSilverCore+su.runCommand(ConstantsString.silverCoreMaxFreq)+" Mhz");
        goldText.setText(ConstantsString.txtGoldCore+su.runCommand(ConstantsString.goldCoreMaxFreq)+" Mhz");
        primeText.setText(ConstantsString.txtPrimeCore+su.runCommand(ConstantsString.primeCoreMaxFreq)+" Mhz");
        gpuMaxText.setText(ConstantsString.txtGpuMaxFreq+su.runCommand(ConstantsString.gpuMaxFreq)+" Mhz");
        String TotalRam = su.runCommand(ConstantsString.memTotal);
        String FreeRam = su.runCommand(ConstantsString.memFree);
        memFree.setText(ConstantsString.txtMemFree+FreeRam+" KB");
        int usedRam = Integer.parseInt(TotalRam) - Integer.parseInt(FreeRam);
        memUsedText.setText(ConstantsString.txtMemUsed+String.valueOf(usedRam)+" KB");
        int temp = batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1) / 10;
        battText.setText(ConstantsString.txtBatteryTemp+String.valueOf(temp)+" Celcius");
        therm0Text.setText(ConstantsString.txtThermalZone0+su.runCommand(ConstantsString.thermalZone0)+" Celcius");
    }



}
