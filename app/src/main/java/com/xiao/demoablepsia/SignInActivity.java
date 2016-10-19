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

        SignInStatus.changeStatus(true);

        //释放
        Anagraph.detainedCompleting("先去登录");

        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //移除(处死)，尽可能优化内存，避免溢出
        Anagraph.die("先去登录");
    }
}
