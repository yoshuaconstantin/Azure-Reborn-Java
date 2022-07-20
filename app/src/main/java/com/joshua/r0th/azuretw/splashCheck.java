package com.joshua.r0th.azuretw;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.joshua.r0th.azuretw.databinding.NeouiBinding;
import com.joshua.r0th.azuretw.databinding.SplashBinding;
import com.joshua.r0th.azuretw.root_utils.RootUtils;

public class splashCheck extends AppCompatActivity {
    SplashBinding binding;
    SharedPreferences sharedpreferences;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        final RootUtils.SU su = new RootUtils.SU(false, null);
        sharedpreferences = getSharedPreferences("myref", Context.MODE_PRIVATE);
        String getcheck = sharedpreferences.getString("passed", "0");

        switch (getcheck){
            case "1":
                Intent intent = new Intent(splashCheck.this, MainActivity.class);
                startActivity(intent);
                break;
        }
        binding.sd888button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("ProcType", "SM350");
                editor.putString("passed", "1");
                editor.apply();


                Intent intent = new Intent(splashCheck.this, MainActivity.class);
                startActivity(intent);
            }
        });
        binding.SD870Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("ProcType", "SD870");
                editor.putString("passed", "1");
                editor.apply();


                Intent intent = new Intent(splashCheck.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.MTKbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(splashCheck.this, "COMING SOON !", Toast.LENGTH_SHORT).show();
//                RootUtils.setProp("ProcType MTK1200");
//                RootUtils.setProp("passed 1");
//                Intent intent = new Intent(splashCheck.this, MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}
