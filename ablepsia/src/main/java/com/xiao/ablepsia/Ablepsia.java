package com.xiao.ablepsia;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;

public class Ablepsia {

    private Ablepsia() {
        throw new UnsupportedOperationException("Please don't fuck me.");
    }

    static private Doctor mDoctor;

    static public void setDoctor(Doctor doctor) {
        mDoctor = doctor;
    }

    static /* pakage */ Doctor getDoctor() {
        if (null == mDoctor) mDoctor = new Doctor() {
            @Override
            protected Anagraph treatment(String symptom, Context context, Class blind) {
                return Anagraph.alive();
            }
        };
        return mDoctor;
    }

    static public void open(@NonNull Context context, @NonNull Class<? extends Activity> activity) {
        getDoctor().open(context, activity);
    }

    static /* package */ void open(@NonNull Ward.Patient patient) {
        mDoctor.open(patient);
    }

    static public Doctor.Proxy options(@Nullable Bundle optionsStarted){
        return getDoctor().getProxy().options(optionsStarted);
    }

    static public Doctor.Proxy flag(int flag) {
        return getDoctor().getProxy().flag(flag);
    }

    static public Doctor.Proxy kv(String name, boolean value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, byte value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, char value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, short value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, int value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, long value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, float value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, double value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, String value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, CharSequence value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, Parcelable value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, Parcelable[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, ArrayList<CharSequence> value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, Serializable value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, boolean[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, byte[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, short[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, char[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, int[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, long[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, float[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, double[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, String[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, CharSequence[] value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, Bundle value) {
        return getDoctor().getProxy().kv(name, value);
    }

    static public Doctor.Proxy kv(String name, IBinder value) {
        return getDoctor().getProxy().kv(name, value);
    }
}
