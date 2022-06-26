package com.joshua.r0th.azuretw;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.joshua.r0th.azuretw.databinding.NeouiBinding;
import com.joshua.r0th.azuretw.databinding.SplashBinding;
import com.joshua.r0th.azuretw.root_utils.RootUtils;

public class splashCheck extends AppCompatActivity {
    SplashBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        final RootUtils.SU su = new RootUtils.SU(false, null);
        String getcheck = RootUtils.getProp("passed");
        if (getcheck.equals("1")){
            Intent intent = new Intent(splashCheck.this, MainActivity.class);
            startActivity(intent);
        }else {

        }
        binding.sd888.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RootUtils.setProp("ProcType SM350");
                RootUtils.setProp("passed 1");
                Intent intent = new Intent(splashCheck.this, MainActivity.class);
                startActivity(intent);
            }
        });
        binding.mtk1200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RootUtils.setProp("ProcType MTK1200");
                RootUtils.setProp("passed 1");
                Intent intent = new Intent(splashCheck.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
