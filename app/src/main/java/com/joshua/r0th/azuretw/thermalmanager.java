package com.joshua.r0th.azuretw;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.joshua.r0th.azuretw.databinding.NeouiBinding;
import com.joshua.r0th.azuretw.databinding.ThermalmanagerBinding;
import com.joshua.r0th.azuretw.root_utils.RootUtils;
import com.joshua.r0th.azuretw.tweak.thermal_tweak;

import java.io.IOException;

public class thermalmanager extends AppCompatActivity implements View.OnClickListener{
    thermal_tweak _thermal_tweak = new thermal_tweak();
    ThermalmanagerBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ThermalmanagerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.button1.setBackgroundResource(R.drawable.azurecolorcorner);
                binding.button2.setBackgroundResource(R.color.blueAzure);
                binding.LinearMENU.setVisibility(View.VISIBLE);
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.button1.setBackgroundResource(R.color.blueAzure);
                binding.button2.setBackgroundResource(R.drawable.azurecolorcorner);
                binding.LinearMENU.setVisibility(View.GONE);

            }
        });
        binding.BTN1.setOnClickListener(this);
        binding.BTN2.setOnClickListener(this);
        binding.BTN3.setOnClickListener(this);
        binding.BTN4.setOnClickListener(this);
        binding.BTN5.setOnClickListener(this);
        binding.BTN6.setOnClickListener(this);
        binding.BTN7.setOnClickListener(this);
        binding.BTN8.setOnClickListener(this);
        binding.BTN9.setOnClickListener(this);
        binding.BTN10.setOnClickListener(this);
        binding.BTN11.setOnClickListener(this);
        binding.BTN12.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.BTN1:
               _thermal_tweak.thermalNumber("-1");
                binding.displayMode.setText("DEFAULT");
                break;
            case R.id.BTN2:
               _thermal_tweak.thermalNumber("0");
                binding.displayMode.setText("RESTORE");
                break;
            case R.id.BTN3:
               _thermal_tweak.thermalNumber("2");
                binding.displayMode.setText("EXTREME");
                break;
            case R.id.BTN4:
               _thermal_tweak.thermalNumber("8");
                binding.displayMode.setText("IN CALL");
                break;
            case R.id.BTN5:
               _thermal_tweak.thermalNumber("9");
                binding.displayMode.setText("GAME");
                break;
            case R.id.BTN6:
               _thermal_tweak.thermalNumber("10");
                binding.displayMode.setText("DYNAMIC");
                break;
            case R.id.BTN7:
               _thermal_tweak.thermalNumber("11");
                binding.displayMode.setText("CLASS 0");
                break;
            case R.id.BTN8:
               _thermal_tweak.thermalNumber("12");
                binding.displayMode.setText("CAMERA");
                break;
            case R.id.BTN9:
               _thermal_tweak.thermalNumber("13");
                binding.displayMode.setText("GAME 2");
                break;
            case R.id.BTN10:
               _thermal_tweak.thermalNumber("14");
                binding.displayMode.setText("YOUTUBE");
                break;
            case R.id.BTN11:
               _thermal_tweak.thermalNumber("15");
                binding.displayMode.setText("AR/VR");
                break;
            case R.id.BTN12:
               _thermal_tweak.thermalNumber("16");
                binding.displayMode.setText("GAME 3");
                break;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        final RootUtils.SU su = new RootUtils.SU(false, null);
        String check = su.runCommand("cat /sys/devices/virtual/thermal/thermal_message/sconfig");
        switch (check){
            case "-1":
                binding.displayMode.setText("DEFAULT");
                break;
            case "0":
                binding.displayMode.setText("RESTORE");
                break;
            case "2":
                binding.displayMode.setText("EXTREME");
                break;
            case "8":
                binding.displayMode.setText("IN CALL");
                break;
            case "9":
                binding.displayMode.setText("GAME");
                break;
            case "10":
                binding.displayMode.setText("DYNAMIC");
                break;
            case "11":
                binding.displayMode.setText("CLASS 0");
                break;
            case "12":
                binding.displayMode.setText("CAMERA");
                break;
            case "13":
                binding.displayMode.setText("GAME 2");
                break;
            case "14":
                binding.displayMode.setText("YOUTUBE");
                break;
            case "15":
                binding.displayMode.setText("AR/VR");
                break;
            case "16":
                binding.displayMode.setText("GAME 3");
                break;
        }
    }

}
