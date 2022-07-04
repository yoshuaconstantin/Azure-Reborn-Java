package com.joshua.r0th.azuretw;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.joshua.r0th.azuretw.databinding.LayoutManualModuleBinding;


public class manual_module extends AppCompatActivity {
    LayoutManualModuleBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LayoutManualModuleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


    }
}
