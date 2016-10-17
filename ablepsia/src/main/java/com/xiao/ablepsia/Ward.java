package com.xiao.ablepsia;


import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

/**
 * 病房，存储被拘留的 跳转
 */
public class Ward {

    private static final ArrayList<String> sDetainedKeys = new ArrayList<>();
    private static final ArrayList<Patient> sDetainedPatients = new ArrayList<>();

    /**
     * 加入病房
     * @param key key
     * @param patient 病患
     * @return 加入结果
     */
    static public boolean detained(String key, Patient patient) {
        if (sDetainedKeys.add(key))
            if (sDetainedPatients.add(patient))
                return true;
        return false;
    }

    /**
     * 出院
     * @param key key
     * @return 出院结果
     */
    static public boolean detainedCompleting(String key) {
        if (sDetainedKeys.contains(key)) {
            int keyIndex = sDetainedKeys.indexOf(key);
            Ablepsia.open(sDetainedPatients.get(keyIndex));
            sDetainedKeys.remove(keyIndex);
            sDetainedPatients.remove(keyIndex);
            return true;
        }
        return false;
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
