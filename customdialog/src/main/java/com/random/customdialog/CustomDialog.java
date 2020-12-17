package com.random.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.github.nikartm.button.FitButton;

import java.util.Timer;
import java.util.TimerTask;

public class CustomDialog extends Dialog {
    private TextView title,description;
    private ImageView imageView;
    private FitButton positive_button,negative_button;
    private Context mContext;
    private View rootView;
    private CardView mainView;
    private CardView cardView;
    public static final int SUCCESS = 1;
    public static final int FAILURE = 2;
    public static final int INFORMATION = 3;
    public static final int QUESTION = 4;
    private View.OnClickListener positiveListener;
    private View.OnClickListener negativeListener;


    public CustomDialog(Context context) {
        super(context);
        mContext = context;
        rootView = LayoutInflater.from(context).inflate(R.layout.alert,null);
        initAllViews(rootView);
        super.setContentView(rootView);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public CustomDialog(Context context, int type) {
        super(context);
        mContext = context;
        rootView = LayoutInflater.from(context).inflate(R.layout.alert,null);
        initAllViews(rootView);
        super.setContentView(rootView);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        switch (type){
            case SUCCESS:
                cardView.setBackgroundColor(mContext.getResources().getColor(R.color.green));
                imageView.setImageResource(R.drawable.checked_circle);
                break;
            case FAILURE:
                cardView.setBackgroundColor(mContext.getResources().getColor(R.color.red));
                imageView.setImageResource(R.drawable.cancel);
                break;
            case QUESTION:
                cardView.setBackgroundColor(mContext.getResources().getColor(R.color.question_color));
                imageView.setImageResource(R.drawable.question_circle);
                break;
            case INFORMATION:
                cardView.setBackgroundColor(mContext.getResources().getColor(R.color.info_color));
                imageView.setImageResource(R.drawable.info_icon);
                break;

        }
    }

    @Override
    public void dismiss() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                CustomDialog.super.dismiss();
            }
        }, 300);
    }

    private void initAllViews(View view){
        title = view.findViewById(R.id.title_ext);
        description = view.findViewById(R.id.description_text);
        imageView = view.findViewById(R.id.image_view);
        positive_button = view.findViewById(R.id.ok_button);
        negative_button = view.findViewById(R.id.cancel_button);
        cardView = rootView.findViewById(R.id.cardView);
        mainView = rootView.findViewById(R.id.toAddView);
        positive_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (positiveListener != null)
                    positiveListener.onClick(v);
            }
        });
        negative_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (negativeListener != null)
                    negativeListener.onClick(v);
            }
        });
    }

    @Override
    public void setContentView(@NonNull View view) {
        mainView.removeAllViews();
        mainView.addView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(mContext).inflate(layoutResID,null);
        setContentView(view);
    }

    @Override
    public void setContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        view.setLayoutParams(params);
        setContentView(view);
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
        positiveListener = listener;
    }

    public void setNegativeButton(String text, View.OnClickListener listener){
        negative_button.setText(text);
        negativeListener = listener;
    }
}

