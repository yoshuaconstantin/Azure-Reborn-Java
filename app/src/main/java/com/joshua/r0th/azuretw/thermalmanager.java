package com.joshua.r0th.azuretw;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.joshua.r0th.azuretw.databinding.NeouiBinding;
import com.joshua.r0th.azuretw.databinding.ThermalmanagerBinding;

public class thermalmanager extends AppCompatActivity {

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
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.button1.setBackgroundResource(R.color.blueAzure);
                binding.button2.setBackgroundResource(R.drawable.azurecolorcorner);
            }
        });

    }
}
