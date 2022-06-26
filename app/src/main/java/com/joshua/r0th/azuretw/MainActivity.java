package com.joshua.r0th.azuretw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.WidgetContainer;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;


import com.joshua.r0th.azuretw.MTK1200U.MTKCPU_TWEAK;
import com.joshua.r0th.azuretw.databinding.NeouiBinding;
import com.joshua.r0th.azuretw.root_utils.RootUtils;
import com.joshua.r0th.azuretw.root_utils.Checking;
import com.joshua.r0th.azuretw.sd888_param.SDCPU_TWEAK;
import com.joshua.r0th.azuretw.tweak.advanched_tweak;
import com.joshua.r0th.azuretw.tweak.memory_tweak;

import org.w3c.dom.Text;

import java.io.RandomAccessFile;
import java.lang.reflect.Method;

import soup.neumorphism.NeumorphCardView;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    NeouiBinding binding;
    SharedPreferences sharedpreferences;
    SDCPU_TWEAK sdCPU_TWEAK = new SDCPU_TWEAK();
    MTKCPU_TWEAK mtkcpu_tweak = new MTKCPU_TWEAK();
    memory_tweak memory_tweak = new memory_tweak();
    advanched_tweak advanched_tweak = new advanched_tweak();
    Checking checkingMod = new Checking();
    Runnable r;
    String checkModel;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = NeouiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        final RootUtils.SU su = new RootUtils.SU(false, null);
        checkModel = RootUtils.getProp("ProcType");
        modeClick(binding.carview1,checkModel,"Chill",R.drawable.defaulton,R.drawable.defaultoff,R.drawable.defaultoff,1);
        modeClick(binding.carview2,checkModel,"Smart",R.drawable.defaultoff,R.drawable.defaulton,R.drawable.defaultoff,2);
        modeClick(binding.carview4,checkModel,"Fast AF",R.drawable.defaultoff,R.drawable.defaultoff,R.drawable.defaulton,4);
        binding.textmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (checkModel){
                    case "SM350":
                        sdCPU_TWEAK.defaultSD();
                        statusEnabled("Tap to enable","Tap to enable","Tap to enable");
                        break;
                    case "MTK1200":
                        //mtkcpu_tweak.defaultMTK();
                        break;
                    default:
                        break;
                }
                binding.textmode.setText("DEFAULT");
                statusMode(R.drawable.defaultoff,R.drawable.defaultoff,R.drawable.defaultoff);

            }
        });
        binding.lottne1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipperDialog();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        final RootUtils.SU su = new RootUtils.SU(false, null);
        String tutorialDialog = RootUtils.getProp("AzureWelcome");
        String RootChecking = RootUtils.getProp("passed");
        if (RootChecking.isEmpty()){
            checkingMod.dialogAlert(MainActivity.this,
                    "No Root Detected, Please Grant SU / Root Your phone");
            binding.textmode.setText("ERROR NO ROOT");
            binding.textmode.setTextSize(15);
            binding.relnew1.setVisibility(View.GONE);
            binding.relnew2.setVisibility(View.GONE);
        }else{
            binding.relnew1.setVisibility(View.VISIBLE);
            binding.relnew2.setVisibility(View.VISIBLE);
            final String checking = RootUtils.getProp("azureSDmode");
            switch (checking){
                case "1":
                    binding.textmode.setText("CHILL");
                    statusMode(R.drawable.defaulton,R.drawable.defaultoff,R.drawable.defaultoff);
                    statusEnabled("Enabled","Tap to Enable","Tap to enable");
                    break;
                case "2":
                    binding.textmode.setText("Smart Casual");
                    statusMode(R.drawable.defaultoff,R.drawable.defaulton,R.drawable.defaultoff);
                    statusEnabled("Tap to enable","Enabled","Tap to enable");
                    break;
                case "4":
                    binding.textmode.setText("Fast AF");
                    statusMode(R.drawable.defaultoff,R.drawable.defaultoff,R.drawable.defaulton);
                    statusEnabled("Tap to enable","Tap to enable","Enabled");
                    break;
                case "5":
                    binding.textmode.setText("DEFAULT");
                    statusMode(R.drawable.defaultoff,R.drawable.defaultoff,R.drawable.defaultoff);
                    statusEnabled("Tap to enable","Tap to enable","Tap to enable");
                    break;
            }
        }
        if (tutorialDialog.isEmpty()){
            flipperDialog();
            RootUtils.setProp("AzureWelcome 1");
        }

    }

    private void statusMode(int chill, int smartcas, int fastaf){
        binding.chillstatus.setImageResource(chill);
        binding.smartstatus.setImageResource(smartcas);
        binding.faststatus.setImageResource(fastaf);
    }

    private void modeClick(NeumorphCardView button, String check, String ModeText,
                           int chill, int smart, int fast,
                           int number ){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (check){
                    case "SM350":
                        switch (number){
                            case 1:
                                sdCPU_TWEAK.chill();
                                statusEnabled("Enabled","Tap to Enable","Tap to enable");
                                break;
                            case 2:
                                sdCPU_TWEAK.smarcasual();
                                statusEnabled("Tap to enable","Enabled","Tap to enable");
                                break;
                            case 4:
                                sdCPU_TWEAK.fastaf();
                                statusEnabled("Tap to enable","Tap to enable","Enabled");
                                break;
                            case 5 :
                                sdCPU_TWEAK.defaultSD();
                                statusEnabled("Tap to enable","Tap to enable","Tap to enable");
                                break;
                            default:
                                break;
                        }

                        break;
                    case "MTK1200":
                        //mtkcpu_tweak.defaultMTK();
                        break;
                    default:
                        break;
                }
                binding.textmode.setText(ModeText);
                statusMode(chill,smart,fast);


            }
        });
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler = new Handler();
        r = new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                systeminfo(checkModel);
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(r, 0);
    }

    private void systeminfo(String proctype){
//        RandomAccessFile reader = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "r");
//        String line = reader.readLine();
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null, ifilter);
        final RootUtils.SU su = new RootUtils.SU(false, null);
        switch (proctype){
            case "SM350":
                binding.deviceName.setText("Xiaomi 11T Pro / Villi");
                binding.ProcType.setText("Snapdragon 888 / SM350. 8 Core, 3 Cluster");
                binding.silvercoreFreq.setText("Silver Core Max Freq : "+su.runCommand("cat /sys/devices/system/cpu/cpufreq/policy0/scaling_max_freq | awk '{print $1/1000}'")+" Mhz");
                binding.goldcoreFreq.setText("Gold Core Max Freq : "+su.runCommand("cat /sys/devices/system/cpu/cpufreq/policy4/scaling_max_freq | awk '{print $1/1000}'")+" Mhz");
                binding.primecoreFreq.setText("Prime Core Max Freq : "+su.runCommand("cat /sys/devices/system/cpu/cpufreq/policy7/scaling_max_freq | awk '{print $1/1000}'")+" Mhz");
                binding.gpumaxFreq.setText("GPU Max Freq : "+su.runCommand("cat  /sys/class/kgsl/kgsl-3d0/max_gpuclk | awk '{print $1/1000000}'")+" Mhz");
                String TotalRam = su.runCommand("cat /proc/meminfo | grep MemTotal | awk '{print $2}'");
                String FreeRam = su.runCommand("cat /proc/meminfo | grep MemAvailable | awk '{print $2}'");
                binding.memFree.setText("Memory Free : "+FreeRam+" KB");
                int usedRam = Integer.parseInt(TotalRam) - Integer.parseInt(FreeRam);
                binding.memoryUsed.setText("Memory Used : "+String.valueOf(usedRam)+" KB");
                int temp = batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1) / 10;
                binding.BatteryTemp.setText("Battery Temp : "+String.valueOf(temp)+" Celcius");
                binding.CPUtemp.setText("Thermal Zone 0 : "+su.runCommand("cat /sys/class/thermal/thermal_zone1/temp | awk '{print $1/1000}'")+" Celcius");
                break;
            case "MTK1200":
                break;
            default:
                break;
        }
    }

    private void statusEnabled(String text1, String text2, String text3){
        binding.chillstatustextactived.setText(text1);
        binding.smartstatustextactived.setText(text2);
        binding.faststatustextactived.setText(text3);
    }
    private void flipperDialog(){
        dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        final View tutorialDialog = getLayoutInflater().inflate(R.layout.tutorial_layout, null);
        ImageButton next = tutorialDialog.findViewById(R.id.buttonNext);
        ImageButton prev = tutorialDialog.findViewById(R.id.buttonPrev);
        ViewFlipper flipper = tutorialDialog.findViewById(R.id.flip1);
        dialogBuilder.setView(tutorialDialog);
        dialog = dialogBuilder.create();
        dialog.show();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.setInAnimation(MainActivity.this,R.anim.slide_in_right);
                flipper.setOutAnimation(MainActivity.this,R.anim.slide_out_left);
                flipper.showNext();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.setInAnimation(MainActivity.this,android.R.anim.slide_in_left);
                flipper.setOutAnimation(MainActivity.this,android.R.anim.slide_out_right);
                flipper.showPrevious();
            }
        });
    }

}