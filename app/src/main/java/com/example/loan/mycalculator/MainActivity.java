package com.example.loan.mycalculator;

import android.app.Activity;
import android.content.Intent;
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

import nguyenvanquan7826.com.Balan;

public class MainActivity extends Activity implements View.OnClickListener {
    public static final int REQUEST_CODE_INFOR = 1;
    private TextView mTextViewResult;
    private TextView mTextViewMath;
    private int number;
    Button mbt0,mbt1,mbt2,mbt3,mbt4,mbt5,mbt6,mbt7,mbt8,mbt9,mbtDot,mbtDel,
           mbtMinus,mbtPlus,mbtMul,mbtDiv,mbtGo,mbtEq ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
       //GET ID
        mTextViewMath = (TextView) findViewById(R.id.textViewMath);
        mTextViewResult = (TextView) findViewById(R.id.textViewResult);

        //Bắt tập trung còn phải có 1 công đoạn nữa, là get id vào và set sự kiện
        mbt0 = (Button) findViewById(R.id.btNumber0);
        mbt0.setOnClickListener(this);
        mbt1 = (Button) findViewById(R.id.btNumber1);
        mbt1.setOnClickListener(this);
        mbt2 = (Button) findViewById(R.id.btNumber2);
        mbt2.setOnClickListener(this);
        mbt3 = (Button) findViewById(R.id.btNumber3);
        mbt3.setOnClickListener(this);
        mbt4 = (Button) findViewById(R.id.btNumber4);
        mbt4.setOnClickListener(this);
        mbt5 = (Button) findViewById(R.id.btNumber5);
        mbt5.setOnClickListener(this);
        mbt6 = (Button) findViewById(R.id.btNumber6);
        mbt6.setOnClickListener(this);
        mbt7 = (Button) findViewById(R.id.btNumber7);
        mbt7.setOnClickListener(this);
        mbt8 = (Button) findViewById(R.id.btNumber8);
        mbt8.setOnClickListener(this);
        mbt9 = (Button) findViewById(R.id.btNumber9);
        mbt9.setOnClickListener(this);
        mbtDot = (Button) findViewById(R.id.btDot);
        mbtDot.setOnClickListener(this);
        mbtDel = (Button) findViewById(R.id.buttonDelete);
        mbtDel.setOnClickListener(this);
        mbtMinus = (Button) findViewById(R.id.buttonMinus);
        mbtMinus.setOnClickListener(this);
        mbtPlus = (Button) findViewById(R.id.buttonPlus);
        mbtPlus.setOnClickListener(this);
        mbtMul = (Button) findViewById(R.id.buttonMult);
        mbtMul.setOnClickListener(this);
        mbtDiv = (Button) findViewById(R.id.buttonDivide);
        mbtDiv.setOnClickListener(this);
        mbtGo = (Button) findViewById(R.id.buttonGo);
        mbtGo.setOnClickListener(this);
        mbtEq = (Button) findViewById(R.id.buttonEquals);
        mbtEq.setOnClickListener(this);
        //như vậy thì chắc chắn trên mọi điện thoại nó mới chạy
        //nhận số đc nhập
        final Intent intent=getIntent();
        number=intent.getIntExtra("KEY_NUMBER",0);
        mTextViewResult.setText(number+"");
        mbtGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Infor.class);
                startActivityForResult(intent,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {

            Double a = data.getDoubleExtra("KEY_NUMBER",0);
            Double b=Double.parseDouble(mTextViewResult.getText().toString());
            Double kq=a*b;
            mTextViewResult.setText(kq+"");
        }
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.btNumber0:
            case R.id.btDot:
            case R.id.btNumber1:
            case R.id.btNumber2:
            case R.id.btNumber3:
            case R.id.btNumber4:
            case R.id.btNumber5:
            case R.id.btNumber6:
            case R.id.btNumber7:
            case R.id.btNumber8:
            case R.id.btNumber9:
            case R.id.buttonDivide:
            case R.id.buttonMinus:
            case R.id.buttonPlus:
            case R.id.buttonMult:
            mTextViewMath.append(((Button)view).getText()); //show display
        }
                switch (id)
                {
                    case R.id.buttonDelete:
                        mTextViewMath.setText("");
                        mTextViewResult.setText("0");
                        break;
                    case R.id.buttonEquals:
                        calculatle();
                        mTextViewMath.setText("");
                        break;
                    case R.id.buttonGo:

                        break;
                }
    }
    private void calculatle()
    {
        String math=mTextViewMath.getText().toString().trim();
        Balan balan=new Balan();
        if(math.length()>0)
        {
            String result=balan.valueMath(math)+"";
            String error=balan.getError();
            if(error!=null)
            {
                mTextViewResult.setText(error);
            }
            else
                mTextViewResult.setText(result);
        }

    }
}
