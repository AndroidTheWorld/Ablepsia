package com.xiao.demoablepsia;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.xiao.ablepsia.Ablepsia;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("首页");
        Ablepsia.setDoctor(new DemoDoctor());

        mTextView = (TextView) findViewById(R.id.status);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTextView.setText(SignInStatus.isSign()?"已登陆":"未登录");
    }

    public void start(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setTransitionName("tsn");
        }
        Ablepsia.kv("name","我是小名")
                .options(ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, "tsn").toBundle())
                .open(this, UseInfoActivity.class);
    }

    public void clearStatus(View view) {
        SignInStatus.changeStatus(false);
        mTextView.setText("未登录");
    }
}
