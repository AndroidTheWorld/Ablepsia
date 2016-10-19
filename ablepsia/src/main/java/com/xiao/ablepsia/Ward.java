package com.xiao.ablepsia;


import android.app.Activity;
import android.content.Context;

import java.util.HashMap;

/**
 * 病房，存储被拘留的 跳转
 */
public class Ward {

    private static final HashMap<String, Patient> sDetainedMap = new HashMap<String, Patient>() {
        @Override
        public Patient get(Object key) {
            Patient var = super.get(key);
            remove(key);
            return var;
        }
    };

    /**
     * 加入病房
     *
     * @param key     key
     * @param patient 病患
     * @return 加入结果
     */
    static public boolean detained(String key, Patient patient) {
        sDetainedMap.put(key, patient);
        return true;
    }

    /**
     * 出院
     *
     * @param key key
     * @return 出院结果
     */
    static public boolean detainedCompleting(String key) {
        Patient patient = sDetainedMap.get(key);
        if (null != patient)
            Ablepsia.open(patient);
        return null != patient;
    }

    /**
     * 处死
     * @param key
     * @return
     */
    public static boolean die(String key) {
        return null != sDetainedMap.remove(key);

    }

    /**
     * 病患
     */
    static class Patient {
        Context mContext;
        Class<? extends Activity> mActivity;
        Doctor.Proxy mProxy;

        public Patient(Context context, Class<? extends Activity> activity, Doctor.Proxy proxy) {
            mContext = context;
            mActivity = activity;
            mProxy = proxy;
        }
    }

}
