package com.xiao.ablepsia;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * 医生
 */
public abstract class Doctor {

    /**
     * 治疗
     * @param symptom 症状
     * @param context context
     * @see //#Aplepsia.open(Context context,Class<? extends Activity> activity)
     *
     * @param blind Class<? extends Activity>
     * @return Anagraph //如何处置 , 不能 null
     */
    protected abstract @NonNull Anagraph treatment(String symptom, Context context, Class blind);

    /**
     * 代理，保存 跳转信息
     */
    public final class Proxy {

        @Override
        protected Proxy clone() {
            Proxy proxy = new Proxy(this.kv, this.mFlag, this.mOptions);
            clear();
            return proxy;
        }

        public Proxy() {
        }

        public Proxy(Bundle kv, int flag, @Nullable Bundle options) {
            this.kv = null == kv ? null : (Bundle) kv.clone();
            this.mFlag = flag;
            this.mOptions = null == options ? null : (Bundle) options.clone();
        }

        private Bundle kv = null;
        private int mFlag = -0x1024abc1;
        private Bundle mOptions = null;

        final int getFlag() {
            return mFlag;
        }

        final boolean hasFlag() {
            return -0x1024abc1 != mFlag;
        }

        final Bundle getKv() {
            if (null == kv) kv = new Bundle();
            return kv;
        }

        final boolean hasKv() {
            return null != kv;
        }

        final void clear() {
            if (null != kv)
                kv.clear();
            if (null != mOptions)
                mOptions.clear();
            mFlag = -0x1024abc1;
        }

        public Proxy kv(String name, boolean value) {
            getKv().putBoolean(name, value);
            return this;
        }

        public Proxy kv(String name, byte value) {
            getKv().putByte(name, value);
            return this;
        }

        public Proxy kv(String name, char value) {
            getKv().putChar(name, value);
            return this;
        }

        public Proxy kv(String name, short value) {
            getKv().putShort(name, value);
            return this;
        }

        public Proxy kv(String name, int value) {
            getKv().putInt(name, value);
            return this;
        }

        public Proxy kv(String name, long value) {
            getKv().putLong(name, value);
            return this;
        }

        public Proxy kv(String name, float value) {
            getKv().putFloat(name, value);
            return this;
        }

        public Proxy kv(String name, double value) {
            getKv().putDouble(name, value);
            return this;
        }

        public Proxy kv(String name, String value) {
            getKv().putString(name, value);
            return this;
        }

        public Proxy kv(String name, CharSequence value) {
            getKv().putCharSequence(name, value);
            return this;
        }

        public Proxy kv(String name, Parcelable value) {
            getKv().putParcelable(name, value);
            return this;
        }

        public Proxy kv(String name, Parcelable[] value) {
            getKv().putParcelableArray(name, value);
            return this;
        }

        public Proxy kv(String name, ArrayList<CharSequence> value) {
            getKv().putCharSequenceArrayList(name, value);
            return this;
        }

        public Proxy kv(String name, Serializable value) {
            getKv().putSerializable(name, value);
            return this;
        }

        public Proxy kv(String name, boolean[] value) {
            getKv().putBooleanArray(name, value);
            return this;
        }

        public Proxy kv(String name, byte[] value) {
            getKv().putByteArray(name, value);
            return this;
        }

        public Proxy kv(String name, short[] value) {
            getKv().putShortArray(name, value);
            return this;
        }

        public Proxy kv(String name, char[] value) {
            getKv().putCharArray(name, value);
            return this;
        }

        public Proxy kv(String name, int[] value) {
            getKv().putIntArray(name, value);
            return this;
        }

        public Proxy kv(String name, long[] value) {
            getKv().putLongArray(name, value);
            return this;
        }

        public Proxy kv(String name, float[] value) {
            getKv().putFloatArray(name, value);
            return this;
        }

        public Proxy kv(String name, double[] value) {
            getKv().putDoubleArray(name, value);
            return this;
        }

        public Proxy kv(String name, String[] value) {
            getKv().putStringArray(name, value);
            return this;
        }

        public Proxy kv(String name, CharSequence[] value) {
            getKv().putCharSequenceArray(name, value);
            return this;
        }

        public Proxy kv(String name, Bundle value) {
            getKv().putBundle(name, value);
            return this;
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
        public Proxy kv(String name, IBinder value) {
            getKv().putBinder(name, value);
            return this;
        }

        public void open(@NonNull Context context, @NonNull Class<? extends Activity> activity) {
            Doctor.this.open(context, activity);
        }

        public Proxy flag(int flag) {
            mFlag = flag;
            return this;
        }

        public Proxy options(Bundle optionsStarted) {
            this.mOptions = optionsStarted;
            return this;
        }

        /* package */ Bundle getOptions() {
            return mOptions;
        }
    }

    private Proxy mProxy = new Proxy();

    /* package */
    Proxy getProxy() {
        return mProxy;
    }

    /**
     * 代理的索引表
     */
    /* package */
    final HashMap<Class<? extends Activity>, Proxy> mProxyHashMap = new HashMap<>();

    /* package */
    final void open(Ward.Patient patient) {
        open1(patient.mContext, patient.mActivity, patient.mProxy);
    }

    /* package */
    final void open(Context context, Class<? extends Activity> activity) {
        // 复制一份代理资料，并将原来代理清空，将其加入索引表
        Proxy proxy = getProxy().clone();
        mProxyHashMap.put(activity, proxy);

        boolean needTreatment = false;
        String symptom = null;
        Annotation[] as = activity.getAnnotations();
        for (Annotation annotation : as) {
            if (annotation instanceof Symptom) {
                symptom = ((Symptom) annotation).value();
                needTreatment = true;
                break;
            }
        }
        //如果没有症状，将尝试直接打开
        if (!needTreatment) {
            open1(context, activity, mProxyHashMap.get(activity));
            return;
        }

        //获得治疗方案
        Anagraph morbidity = treatment(symptom, context, activity);

        if (null == morbidity) {
            throw new UnsupportedOperationException("Don't know [" + symptom + "] morbidity.");
        }

        if (morbidity.isNeedDetained()) {   //如果被拘留
            proxy.options(null);
            if (morbidity.isChaperonageDetained()) {    //陪护监视状态
                nurseDetained(morbidity.getChaperonage(), context, activity);
            } else {    //不处于监视状态
                Ward.detained(morbidity.getDetainedKey(), new Ward.Patient(context, activity, mProxyHashMap.get(activity)));
            }
        } else {    //没有被拘留，立刻执行
            immediately(context, activity, symptom, morbidity);
        }
    }

    /**
     * 立刻执行
     * @param context context
     * @param activity Class<? extends Activity>
     * @param symptom 症状
     * @param morbidity 治疗方案
     */
    private void immediately(Context context, Class<? extends Activity> activity, String symptom, Anagraph morbidity) {
        if (morbidity.isAlive()) {
            open1(context, activity, mProxyHashMap.get(activity));
        } else if (morbidity.isDie()) {
            mProxyHashMap.remove(activity);
            funeral(symptom, context, activity);
        }
    }

    /**
     * 陪护监视
     * @param chaperonage 陪护
     * @param context context
     * @param activity Class<? extends Activity>
     */
    private void nurseDetained(final Anagraph.Chaperonage chaperonage, final Context context, final Class<? extends Activity> activity) {
        new Nurse(chaperonage).setChange(new Nurse.OnChange() {
            @Override
            public void alive() {
                open1(context, activity, mProxyHashMap.get(activity));
            }
        }).start();
    }


    private void open1(Context context, Class<? extends Activity> activity, Proxy proxy) {
        final Intent anagraphIntent = new Intent(context, activity);
        if (proxy.hasKv())
            anagraphIntent.putExtras(proxy.getKv());
        if (proxy.hasFlag()) {
            anagraphIntent.addFlags(proxy.getFlag());
        } else {
            if (context instanceof Application) {
                anagraphIntent.addFlags(FLAG_ACTIVITY_NEW_TASK);
            }
        }
        mProxyHashMap.remove(activity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {      //判断版本
            context.startActivity(anagraphIntent, proxy.getOptions());
        } else {
            context.startActivity(anagraphIntent);
        }

    }

    /**
     * 葬礼
     * @param symptom 症状
     * @param context context
     * @param activity Class<? extends Activity>
     */
    protected void funeral(String symptom, Context context, Class<? extends Activity> activity) {

        //调用 Anagraph.die() 后，会回调到这里

        //默认空实现
    }

    /**
     * 监视
     */
    private static final class Nurse extends Thread {

        public interface OnChange {
            void alive();
        }

        public Nurse(Anagraph.Chaperonage chaperonage) {
            this.mChaperonage = chaperonage;
        }

        public Nurse setChange(OnChange change) {
            this.mChange = change;
            return this;
        }

        private OnChange mChange = null;
        private Anagraph.Chaperonage mChaperonage = null;

        @Override
        public void run() {
            try {
                boolean alive = false;
                do {
                    alive = mChaperonage.Chaperonage();
                    Thread.sleep(mChaperonage.mPatrol);
                } while (!alive);
                mChange.alive();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
