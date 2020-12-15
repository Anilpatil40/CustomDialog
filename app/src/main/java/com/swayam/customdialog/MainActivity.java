package com.swayam.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CpuUsageInfo;
import android.view.View;
import android.widget.Toast;

import com.random.customdialog.CustomDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void show(View view) {
        CustomDialog dialog = new CustomDialog(this, CustomDialog.FAILURE);
        dialog.setTitle("SORRY");
        dialog.setContentText("something went wrong");
        dialog.setPositiveButton("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "this is working", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "this is working", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}