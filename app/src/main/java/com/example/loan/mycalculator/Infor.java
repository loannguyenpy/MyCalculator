package com.example.loan.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Infor extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        final EditText editTextInput=(EditText) findViewById(R.id.editTextInput);
        Button btOK=(Button) findViewById(R.id.buttonOK);
        btOK.setOnClickListener(new View.OnClickListener() {
        final Intent intent=getIntent();
            @Override
            public void onClick(View v) {
                Double numBer=Double.parseDouble(editTextInput.getText().toString());
                Intent intent=new Intent();
                intent.putExtra("KEY_NUMBER",numBer);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
