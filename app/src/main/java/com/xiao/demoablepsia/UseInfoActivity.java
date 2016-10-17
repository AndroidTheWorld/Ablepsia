package com.xiao.demoablepsia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xiao.ablepsia.Symptom;

@Symptom("需要登录才能打开")
public class UseInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_info);
        setTitle("用户详情页");

        TextView txt = (TextView) findViewById(R.id.txt);

        txt.setText(getIntent().getStringExtra("name"));
    }
}
