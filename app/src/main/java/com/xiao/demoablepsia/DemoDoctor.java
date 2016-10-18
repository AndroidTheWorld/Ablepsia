package com.xiao.demoablepsia;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.xiao.ablepsia.Ablepsia;
import com.xiao.ablepsia.Doctor;
import com.xiao.ablepsia.Anagraph;

public class DemoDoctor extends Doctor {

    @NonNull
    @Override
    protected Anagraph treatment(String symptom, Context context, Class blind) {

        switch (symptom) {
            case "需要登录才能打开":
                if (SignInStatus.isSign()){
                    return Anagraph.alive();// --不拦截，继续执行
                }else {
                    Ablepsia.open(context,SignInActivity.class);
//                    return Anagraph.detained("先去登录");//  -- --拦截，直到调用 Anagraph.detainedCompleting("先去登录") 才会继续执行，我这里在 SignInActivity 里调用了 detainedCompleting

                    //或者使用 Chaperonage 监视，直到当 true == Chaperonage()才继续执行
                    //默认每 500 毫秒监视一次
                    return Anagraph.detained(new Anagraph.Chaperonage() {
                        @Override
                        public boolean Chaperonage() {
                            return SignInStatus.isSign(); //         --继续执行
                        }
                    });
                }
            default:
                return Anagraph.die();// --拦截，终止跳转
        }
    }

    @Override
    protected void funeral(String symptom, Context context, Class<? extends Activity> activity) {
        
    }
}
