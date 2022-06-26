package com.joshua.r0th.azuretw.root_utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.joshua.r0th.azuretw.MainActivity;
import com.joshua.r0th.azuretw.R;

import java.io.IOException;

public class Checking {

    public Checking(){}

    public static void dialogAlert(Context context,String text){

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        // set title dialog
        alertDialogBuilder.setTitle("WARNING !");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage(text)
                .setIcon(R.drawable.azurenewlogo_round)

                .setCancelable(false)
                .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Toast.makeText(context, "APP WILL NOT WORKING, PLEASE EXIT", Toast.LENGTH_LONG).show();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.holo_red_dark);
    }

    public static void dialogProcType(Context context, String text){

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        // set title dialog
        alertDialogBuilder.setTitle("Choose Your Processor");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage(text)
                .setIcon(R.drawable.azurenewlogo_round)

                .setCancelable(false)
                .setNegativeButton("MTK1200", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        RootUtils.setProp("ProcType SM350");
                        dialogInterface.dismiss();
                    }
                })
                .setPositiveButton("SD888",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        RootUtils.setProp("ProcType SM350");
                        dialog.dismiss();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.white);
    }
}
