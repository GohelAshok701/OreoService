package com.oreoservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_input;
    private Button btn_start_service,btn_stop_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_input=findViewById(R.id.edt_input);
        btn_start_service=findViewById(R.id.btn_start_service);
        btn_stop_service=findViewById(R.id.btn_stop_service);

        btn_start_service.setOnClickListener(this);
        btn_stop_service.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_start_service:
                Intent startService=new Intent(this,ExampleService.class);
                startService.putExtra("inputExtra",edt_input.getText().toString().trim());
//                ContextCompat.startForegroundService(this,startService);
                startService(startService);
                break;

            case R.id.btn_stop_service:
                Intent stopService=new Intent(this,ExampleService.class);
                stopService(stopService);
                break;
        }
    }
}
