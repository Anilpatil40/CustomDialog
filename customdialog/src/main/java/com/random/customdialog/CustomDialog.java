package com.random.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

import com.github.nikartm.button.FitButton;

public class CustomDialog extends Dialog {
    private TextView title,description;
    private ImageView imageView;
    private FitButton positive_button,negative_button;
    private Context mContext;
    private View rootView;
    public static final int SUCCESS = 1;
    public static final int FAILURE = 2;


    public CustomDialog(Context context) {
        super(context);
        mContext = context;
        rootView = LayoutInflater.from(context).inflate(R.layout.alert,null);
        initAllViews(rootView);
        this.setContentView(rootView);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public CustomDialog(Context context, int type) {
        super(context);
        mContext = context;
        rootView = LayoutInflater.from(context).inflate(R.layout.alert,null);
        initAllViews(rootView);
        this.setContentView(rootView);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        switch (type){
            case SUCCESS:

                break;
            case FAILURE:
                CardView cardView = rootView.findViewById(R.id.cardView);
                cardView.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
                imageView.setImageResource(R.drawable.cancel);
                break;
        }
    }



    private void initAllViews(View view){
        title = view.findViewById(R.id.title_ext);
        description = view.findViewById(R.id.description_text);
        imageView = view.findViewById(R.id.image_view);
        positive_button = view.findViewById(R.id.ok_button);
        negative_button = view.findViewById(R.id.cancel_button);
    }

    public void setTitle(CharSequence title) {
        this.title.setText(title);
    }


    public void setTitle(int titleId) {
        this.title.setText(mContext.getResources().getText(titleId));
    }

    public void setContentText(CharSequence text){
        this.description.setText(text);
    }

    public void setIcon(int imageId) {
        this.imageView.setImageResource(imageId);
    }

    public void setPositiveButton(String text, View.OnClickListener listener){
        positive_button.setText(text);
        positive_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (listener != null)
                    listener.onClick(v);

            }
        });
    }

    public void setNegativeButton(String text, View.OnClickListener listener){
        negative_button.setText(text);
        negative_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (listener != null)
                    listener.onClick(v);
            }
        });
    }
}

