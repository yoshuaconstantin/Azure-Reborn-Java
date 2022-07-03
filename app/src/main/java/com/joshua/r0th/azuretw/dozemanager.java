package com.joshua.r0th.azuretw;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.joshua.r0th.azuretw.databinding.DozemanagerBinding;
import com.joshua.r0th.azuretw.databinding.NeouiBinding;
import com.joshua.r0th.azuretw.root_utils.RootUtils;
import com.joshua.r0th.azuretw.tweak.dozetweak;
import com.varunest.sparkbutton.SparkButton;

import java.io.IOException;
///Documentation https://github.com/p0isonra1n/Doze-Settings-Editor
///Documentation https://android.googlesource.com/platform/frameworks/base/+/781ba14/services/core/java/com/android/server/DeviceIdleController.java
public class dozemanager extends AppCompatActivity {
    com.joshua.r0th.azuretw.tweak.dozetweak dozetweak = new dozetweak();
    SharedPreferences sharedpreferences;
    DozemanagerBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DozemanagerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
        sharedpreferences = getSharedPreferences("myref", Context.MODE_PRIVATE);
        final RootUtils.SU su = new RootUtils.SU(false, null);
        modecheckdoze();


        ///help button
        dialogHelper(binding.customdozeinfo,"Custom Doze By r0th Baby","This Custom Doze almost cover all the way doze scheme where prioritize make device go to light doze with time setting (Each update will improve the mode) \nhope help you save more than 1% battery when idling");
        dialogHelper(binding.deepdozeinfo,"Deep Doze","Deep Doze is scheme that trying to make your phone skip light doze and enter deep doze witch hope to gain more 1% battery saving");
        dialogHelper(binding.lightdozeinfo,"Light Doze","Light Doze scheme is different than others this doze prevent phone as much as it set before entering deepdoze hope your notification is still there\nwhile saving 1% of your battery");
        dialogHelper(binding.gimmicdozeinfo,"Mimic Deep doze","almost same like deep doze but its acually light doze witch have deep doze settings\nhope to gain 1% battery saving while idling");
        ///end of help button

        binding.defaultdoze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(dozemanager.this);
                // set title dialog
                alertDialogBuilder.setTitle("Mimic Deep doze");

                // set pesan dari dialog
                alertDialogBuilder
                        .setMessage("Back to Default")
                        .setIcon(R.drawable.azurenewlogo_round)
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dozetweak.removedozesetting();
                                binding.modetextdoze.setText("Default / Null");
                                RootUtils.setProp("dozemode 5");
                                modeTypeFace("Default / Null",Typeface.NORMAL, Typeface.NORMAL, Typeface.NORMAL, Typeface.NORMAL);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                // membuat alert dialog dari builder
                AlertDialog alertDialog = alertDialogBuilder.create();

                // menampilkan alert dialog
                alertDialog.show();
            }
        });
        ///ActiveDozeButton
        ActiveButtonTap(binding.customdoze,"Custom Doze","dozemode 1","Custom Doze Actived !",1);
        ActiveButtonTap(binding.lightdoze,"Light Doze","dozemode 2","Light Doze Actived !",2);
        ActiveButtonTap(binding.deepdoze,"Deep Doze","dozemode 3","Deep Doze Actived !",3);
        ActiveButtonTap(binding.gimmicdoze,"Gimmick Doze","dozemode 4","Gimmic Doze Actived !",4);
        ///end of activeDozeButton
        //Sparkbutton onclick listener


    }

    @Override
    protected void onStart() {
        super.onStart();
        //checkmode with su

    }

    //modedozecheck
    public void modecheckdoze(){
        final String dozecheck = RootUtils.getProp("dozemode");
        if (dozecheck.equals("1")){
            modeTypeFace("Custom Doze",Typeface.BOLD, Typeface.NORMAL, Typeface.NORMAL, Typeface.NORMAL);
        }else if (dozecheck.equals("2")){
            modeTypeFace("Light Doze",Typeface.NORMAL, Typeface.NORMAL, Typeface.BOLD, Typeface.NORMAL);
        }else if (dozecheck.equals("3")){
            modeTypeFace("Deep Doze",Typeface.NORMAL, Typeface.BOLD, Typeface.NORMAL, Typeface.NORMAL);
        }else if (dozecheck.equals("4")){
            modeTypeFace("Gimmic Doze",Typeface.NORMAL, Typeface.NORMAL, Typeface.NORMAL, Typeface.BOLD);
        }else{

            modeTypeFace("Default / Null",Typeface.NORMAL, Typeface.NORMAL, Typeface.NORMAL, Typeface.NORMAL);

        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        finish();

    }

    private void dialogHelper(TextView textView, String title, String message){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(dozemanager.this);
                // set title dialog
                alertDialogBuilder.setTitle(title);

                // set pesan dari dialog
                alertDialogBuilder
                        .setMessage(message)
                        .setIcon(R.drawable.azurenewlogo_round)
                        .setCancelable(false)
                        .setPositiveButton("Close",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                dialog.dismiss();
                            }
                        });
                // membuat alert dialog dari builder
                AlertDialog alertDialog = alertDialogBuilder.create();

                // menampilkan alert dialog
                alertDialog.show();
            }
        });
    }

    private void ActiveButtonTap(SparkButton button, String title, String dozeMode, String pesan, int number){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                button.playAnimation();
                final Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        //dozetweak.removedozesetting();
                        //dozetweak.enabledoze();
                        switch (number){
                            case 1:
                                dozetweak.randomDozeTweak();
                                break;
                            case 2:
                                dozetweak.LighdozeTiming();
                                break;
                            case 3:
                                dozetweak.dozeDeep();
                                break;
                            case 4:
                                dozetweak.DozeMimic();
                                break;
                            default:
                                dozetweak.removedozesetting();
                                break;
                        }
                        binding.modetextdoze.setText(title);
                        RootUtils.setProp(dozeMode);
                        Toast.makeText(getApplicationContext(),pesan,Toast.LENGTH_SHORT).show();
                    }
                };v.postDelayed(r, 500);
            }
        });
    }

    private void modeTypeFace(String mode,int typemode1, int typemode2, int typemode3, int typemode4){
        binding.modetextdoze.setText(mode);
        binding.customdozeinfo.setTypeface(Typeface.defaultFromStyle(typemode1));
        binding.deepdozeinfo.setTypeface(Typeface.defaultFromStyle(typemode2));
        binding.lightdozeinfo.setTypeface(Typeface.defaultFromStyle(typemode3));
        binding.gimmicdozeinfo.setTypeface(Typeface.defaultFromStyle(typemode4));
    }
}
