package com.xiao.demoablepsia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiao.ablepsia.Anagraph;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setTitle("登录页");
    }

    public void signed(View view) {
        Anagraph.detainedCompleting("先去登录");
        SignInStatus.changeStatus(true);
        finish();

    }
}
