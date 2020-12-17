package com.swayam.customdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        dialog.show();
    }

    public void success(View view) {
        CustomDialog dialog = new CustomDialog(this, CustomDialog.SUCCESS);
        dialog.setPositiveButton("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "this is pressed", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    public void failure(View view) {
        CustomDialog dialog = new CustomDialog(this, CustomDialog.FAILURE);
        dialog.show();
    }

    public void question(View view) {
        EditText textView = new EditText(this);
        CustomDialog dialog = new CustomDialog(this,CustomDialog.QUESTION);
        dialog.show();
    }
}