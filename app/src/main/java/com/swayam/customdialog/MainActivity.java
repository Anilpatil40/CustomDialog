package com.swayam.customdialog;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.random.customdialog.CustomDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void info(View view) {
        CustomDialog dialog = new CustomDialog(this, CustomDialog.INFORMATION);
        dialog.setTitle("INFORMATION");
        dialog.setContentText("this is information");
        dialog.setPositiveButton("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.setNegativeButton("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
    }

    public void success(View view) {
        CustomDialog dialog = new CustomDialog(this, CustomDialog.SUCCESS);
        dialog.setTitle("SUCCESS");
        dialog.setContentText("this is success message");
        dialog.setPositiveButton("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.setNegativeButton("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
    }

    public void failure(View view) {
        CustomDialog dialog = new CustomDialog(this, CustomDialog.FAILURE);
        dialog.setTitle("FAILED");
        dialog.setContentText("this is failure message");
        dialog.setPositiveButton("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.setNegativeButton("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
    }

    public void question(View view) {
        EditText textView = new EditText(this);
        textView.setLayoutParams(new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        textView.setMinHeight(100);
        textView.setBackgroundColor(Color.parseColor("#20000000"));

        CustomDialog dialog = new CustomDialog(this, CustomDialog.QUESTION);
        dialog.setTitle("QUESTION");
        dialog.setContentText("what is your name ?");
        dialog.setContentView(textView);
        dialog.setPositiveButton("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.setNegativeButton("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
    }
}