package com.joshua.r0th.azuretw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.animation.ObjectAnimator;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;


import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.joshua.r0th.azuretw.MTK1200U.MTKCPU_TWEAK;
import com.joshua.r0th.azuretw.constants.ConstantsString;
import com.joshua.r0th.azuretw.databinding.NeouiBinding;
import com.joshua.r0th.azuretw.informationStuff.SystemInfo;
import com.joshua.r0th.azuretw.root_utils.RootUtils;
import com.joshua.r0th.azuretw.root_utils.Checking;
import com.joshua.r0th.azuretw.sd888_param.SDCPU_TWEAK;
import com.joshua.r0th.azuretw.tweak.advanched_tweak;
import com.joshua.r0th.azuretw.tweak.memory_tweak;
import com.joshua.r0th.azuretw.widget.Azure_widget_provider;

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
    SystemInfo sys = new SystemInfo();
    Runnable r;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private BottomSheetBehavior bottomSheetBehavior;
    private LinearLayout linearLayoutBSheet;

    int stateBehave = 1;
    String proctype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = NeouiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        sheetBehave();
        final RootUtils.SU su = new RootUtils.SU(false, null);
        sharedpreferences = getSharedPreferences("myref", Context.MODE_PRIVATE);
        proctype = sharedpreferences.getString("ProcType", null);
        modeClick(binding.carview1, proctype, "CHILL", R.drawable.defaulton, R.drawable.defaultoff, R.drawable.defaultoff, 1);
        modeClick(binding.carview2, proctype, "Smart Casual", R.drawable.defaultoff, R.drawable.defaulton, R.drawable.defaultoff, 2);
        modeClick(binding.carview4, proctype, "Fast AF", R.drawable.defaultoff, R.drawable.defaultoff, R.drawable.defaulton, 4);
        binding.textmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (proctype) {
                    case "SM350":
                        sdCPU_TWEAK.defaultSD();
                        statusEnabled("Tap to enable", "Tap to enable", "Tap to enable");
                        break;
                    case "MTK1200":
                        //mtkcpu_tweak.defaultMTK();
                        break;
                    default:
                        break;
                }
                binding.textmode.setText("DEFAULT");
                statusMode(R.drawable.defaultoff, R.drawable.defaultoff, R.drawable.defaultoff);

            }
        });
        binding.helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipperDialog();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateWidget(MainActivity.this);
        sharedpreferences = getSharedPreferences("myref", Context.MODE_PRIVATE);
        String tutorialDialog = RootUtils.getProp("AzureWelcome");
        String RootChecking = sharedpreferences.getString("passed", null);
        if (RootChecking.isEmpty() || RootChecking == null) {
            checkingMod.dialogAlert(MainActivity.this,
                    "No Root Detected, Please Grant SU / Root Your phone");
            binding.textmode.setText("ERROR NO ROOT");
            binding.textmode.setTextSize(15);
            binding.relnew1.setVisibility(View.GONE);
            binding.relnew2.setVisibility(View.GONE);
        } else {
            binding.relnew1.setVisibility(View.VISIBLE);
            binding.relnew2.setVisibility(View.VISIBLE);
            final String checking = RootUtils.getProp("azureSDmode");
            switch (checking) {
                case "1":
                    binding.textmode.setText("CHILL");
                    statusMode(R.drawable.defaulton, R.drawable.defaultoff, R.drawable.defaultoff);
                    statusEnabled("Enabled", "Tap to Enable", "Tap to enable");
                    break;
                case "2":
                    binding.textmode.setText("Smart Casual");
                    statusMode(R.drawable.defaultoff, R.drawable.defaulton, R.drawable.defaultoff);
                    statusEnabled("Tap to enable", "Enabled", "Tap to enable");
                    break;
                case "4":
                    binding.textmode.setText("Fast AF");
                    statusMode(R.drawable.defaultoff, R.drawable.defaultoff, R.drawable.defaulton);
                    statusEnabled("Tap to enable", "Tap to enable", "Enabled");
                    break;
                case "5":
                    binding.textmode.setText("DEFAULT");
                    statusMode(R.drawable.defaultoff, R.drawable.defaultoff, R.drawable.defaultoff);
                    statusEnabled("Tap to enable", "Tap to enable", "Tap to enable");
                    break;
            }
        }
        if (tutorialDialog.isEmpty()) {
            flipperDialog();
            RootUtils.setProp("AzureWelcome 1");
        }

    }

    private void statusMode(int chill, int smartcas, int fastaf) {
        binding.chillstatus.setImageResource(chill);
        binding.smartstatus.setImageResource(smartcas);
        binding.faststatus.setImageResource(fastaf);
    }

    private void modeClick(NeumorphCardView button, String check, String ModeText,
                           int chill, int smart, int fast,
                           int number) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (check) {
                    case "SM350":
                        switch (number) {
                            case 1:
                                sdCPU_TWEAK.chill();
                                statusEnabled("Enabled", "Tap to Enable", "Tap to enable");
                                break;
                            case 2:
                                sdCPU_TWEAK.smarcasual();
                                statusEnabled("Tap to enable", "Enabled", "Tap to enable");
                                break;
                            case 4:
                                sdCPU_TWEAK.fastaf();
                                statusEnabled("Tap to enable", "Tap to enable", "Enabled");
                                break;
                            case 5:
                                sdCPU_TWEAK.defaultSD();
                                statusEnabled("Tap to enable", "Tap to enable", "Tap to enable");
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
                handler = new Handler();
                r = new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        updateWidget(MainActivity.this);
                        handler.postDelayed(this, 1000);
                    }
                };
                handler.postDelayed(r, 0);
                binding.textmode.setText(ModeText);
                statusMode(chill, smart, fast);


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
                systeminfo(proctype);
                handler.postDelayed(this, 3500);
            }
        };
        handler.postDelayed(r, 0);
    }

    private void systeminfo(String proctype) {
//        RandomAccessFile reader = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "r");
//        String line = reader.readLine();
        proctype = sharedpreferences.getString("ProcType", null);
        sys.CPU_info(proctype, binding.ProcType, binding.deviceName, binding.silvercoreFreq, binding.goldcoreFreq,
                binding.primecoreFreq, binding.gpumaxFreq, binding.memFree, binding.memoryUsed,
                binding.BatteryTemp, binding.CPUtemp, this);

    }

    private void statusEnabled(String text1, String text2, String text3) {
        binding.chillstatustextactived.setText(text1);
        binding.smartstatustextactived.setText(text2);
        binding.faststatustextactived.setText(text3);
    }

    private void flipperDialog() {
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
                flipper.setInAnimation(MainActivity.this, R.anim.slide_in_right);
                flipper.setOutAnimation(MainActivity.this, R.anim.slide_out_left);
                flipper.showNext();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.setInAnimation(MainActivity.this, android.R.anim.slide_in_left);
                flipper.setOutAnimation(MainActivity.this, android.R.anim.slide_out_right);
                flipper.showPrevious();
            }
        });
    }

    private void sheetBehave() {

        this.linearLayoutBSheet = findViewById(R.id.bottomSheet);
        this.bottomSheetBehavior = BottomSheetBehavior.from(linearLayoutBSheet);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View view, int newState) {
                view.findViewById(R.id.bottomSheet).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (stateBehave == 1) {
                            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                            stateBehave++;
                        } else if (stateBehave == 2) {
                            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                            stateBehave--;
                        }
                    }
                });
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    stateBehave = 2;
                    view.findViewById(R.id.reldoze).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, dozemanager.class);
                            startActivity(intent);
                        }
                    });
                    view.findViewById(R.id.relMod1).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "Coming Soon !", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(MainActivity.this, manual_module.class);
//                            startActivity(intent);
                        }
                    });
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    stateBehave = 1;
                }
            }

            @Override
            public void onSlide(View view, float v) {

            }
        });

    }

    private void updateWidget(Context context) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);


        final String checking = RootUtils.getProp("azureSDmode");
        switch (checking){
            case "1":
                views.setTextViewText(R.id.widget_profile_text, "CHILL");
                views.setImageViewResource(R.id.widget_img, R.drawable.chillvector);
                break;
            case "2":
                views.setTextViewText(R.id.widget_profile_text, "Smart");
                views.setImageViewResource(R.id.widget_img, R.drawable.smartvector);
                break;
            case "4":
                views.setTextViewText(R.id.widget_profile_text, "Fast AF");
                views.setImageViewResource(R.id.widget_img, R.drawable.speed);
                break;
            case "5":
                views.setTextViewText(R.id.widget_profile_text, "DEFAULT");
                views.setImageViewResource(R.id.widget_img, R.drawable.azurenewlogo_round);
                break;
        }


        // Tell the AppWidgetManager to perform an update on the current app widget
        ComponentName theWidget = new ComponentName(this, Azure_widget_provider.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        manager.updateAppWidget(theWidget, views);
        }

    }


