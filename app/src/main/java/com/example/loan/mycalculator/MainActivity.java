package com.example.loan.mycalculator;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView mTextViewResult;
    private TextView mTextViewMath;
    String regex;//regex là ký hiệu để cắt chuỗi
    private int[] mButton = {
            R.id.btDot, R.id.btNumber0,
            R.id.btNumber1,R.id.btNumber8,
            R.id.buttonDelete, R.id.btNumber2,
            R.id.buttonDivide, R.id.btNumber3,
            R.id.buttonMinus, R.id.btNumber4,
            R.id.buttonMult, R.id.btNumber5,
            R.id.buttonPlus, R.id.btNumber6,
            R.id.btNumber7, R.id.btNumber9,
            R.id.buttonEquals, R.id.buttonBack,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //GET ID
        mTextViewMath = (TextView) findViewById(R.id.textViewMath);
        mTextViewResult = (TextView) findViewById(R.id.textViewResult);
        for (int i = 0; i < mButton.length; i++) {
            findViewById(mButton[i]).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        //check button
        for (int i = 0; i < mButton.length - 2; i++)//trừ 2 để không hiện thị button delete và button back lên màn hình
        {
            if (id == mButton[i]) {
                String text = ((Button) findViewById(id)).getText().toString();
                mTextViewMath.append(text);
            }
        }
        //clear screen
        if (id == R.id.buttonDelete) {
            mTextViewMath.setText("");
            mTextViewResult.setText("0");
        }
        if (id == R.id.buttonMinus) {
            regex = ((Button) findViewById(id)).getText().toString();
        }
        if (id == R.id.buttonDivide) {
            regex = ((Button) findViewById(id)).getText().toString();
        }
        if (id == R.id.buttonPlus) {
            regex = ((Button) findViewById(id)).getText().toString();
        }
        if (id == R.id.buttonMult) {
            regex = ((Button) findViewById(id)).getText().toString();
        }
        //calculater
        if (id == R.id.buttonEquals) {
            String num = mTextViewMath.getText().toString();
            String c[] = num.split(regex);
            double a = Double.parseDouble(c[0]);
            double b = Double.parseDouble(c[1]);
            double kq = 0;
            if (regex.equals("+")) {
                kq = a + b;
            } else if (regex.equals("-")) {
                kq = a - b;
            } else if (regex.equals("x")) {
                kq = a * b;
            } else {
                kq = a / b;
            }
            mTextViewResult.setText(kq + "");
        }
    }
}
