package com.eftimoff.progresstextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import com.eftimoff.mylibrary.R;

public class ProgressTextView extends TextView {

    private int progress;
    private int max = 100;
    private int progressColor;
    private ForegroundColorSpan foregroundColorSpan;
    private Spannable spannableString = new SpannableString(getText());
    private boolean isChangingProgress;


    public ProgressTextView(Context context) {
        super(context);
        init();
    }

    public ProgressTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        getAttributes(context, attrs);
    }


    public ProgressTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        getAttributes(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ProgressTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        getAttributes(context, attrs);
    }

    private void init() {
        foregroundColorSpan = new ForegroundColorSpan(Color.WHITE);
    }

    private void getAttributes(Context context, AttributeSet attrs) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ProgressTextView);
        try {
            if (a != null) {
                setProgressColor(a.getColor(R.styleable.ProgressTextView_ptv_progressColor, 0xff00ff00));
                setProgress(a.getInt(R.styleable.ProgressTextView_ptv_progress, 0));
                setMax(a.getInt(R.styleable.ProgressTextView_ptv_max, 100));
            }
        } finally {
            if (a != null) {
                a.recycle();
            }
        }
    }


    public synchronized void setProgress(final int progress) {
        this.progress = progress;
        isChangingProgress = true;
        invalidate();
    }

    public synchronized int getProgress() {
        return this.progress;
    }


    public synchronized void setMax(final int max) {
        this.max = max;
        isChangingProgress = true;
        invalidate();
    }

    public synchronized int getMax() {
        return this.max;
    }

    public void setProgressColor(final int progressColor) {
        this.progressColor = progressColor;
        foregroundColorSpan = new ForegroundColorSpan(progressColor);
        isChangingProgress = true;
        invalidate();
    }

    public int getProgressColor() {
        return this.progressColor;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isChangingProgress) {
            final float procentProgress = (float) progress / max;
            spannableString.setSpan(foregroundColorSpan, 0, (int) (procentProgress * getText().length()), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            setText(spannableString);
            isChangingProgress = false;
        }
    }
}
