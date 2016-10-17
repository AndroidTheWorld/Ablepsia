package com.xiao.ablepsia;


import android.support.annotation.Nullable;

public class Anagraph {

    private boolean mIsNeedDetained = false;

    private Chaperonage mChaperonage;

    private static final int sTYPE_DIE = 0X1024A1;
    private static final int sTYPE_ALIVE = 0X1024A2;

    private int mType;

    private Anagraph(int type) {
        mIsNeedDetained = false;
        mType = type;
    }

    private Anagraph(Chaperonage chaperonage) {
        mIsNeedDetained = true;
        mChaperonage = chaperonage;
    }

    private String detainedKey = null;

    /* package */ boolean isChaperonageDetained() {
        return (null == detainedKey) && (null != mChaperonage);
    }

    @Nullable
     /* package */ String getDetainedKey() {
        return detainedKey;
    }

    private Anagraph(String key) {
        mIsNeedDetained = true;
        mChaperonage = null;
        detainedKey = key;
    }

    /* package */ boolean isNeedDetained() {
        return mIsNeedDetained;
    }

    @Nullable
     /* package */ Chaperonage getChaperonage() {
        return mChaperonage;
    }

    /* package */ boolean isDie() {
        return sTYPE_DIE == mType;
    }

    /* package */ boolean isAlive() {
        return sTYPE_ALIVE == mType;
    }

    public static Anagraph die() {
        return new Anagraph(sTYPE_DIE);
    }

    /**
     * 拘留
     * 不推荐使用，此方法消耗资源，原理是采用子线程循环监视
     * 推荐使用 {@see #detained(String) }
     *
     * @param chaperonage
     * @return .
     */
    @Deprecated
    public static Anagraph detained(Chaperonage chaperonage) {
        return new Anagraph(chaperonage);
    }

    /**
     * 拘留
     * @param key key
     * @return .
     */
    public static Anagraph detained(String key) {
        return new Anagraph(key);
    }

    /**
     * 拘留完成
     * @param key key
     * @return .
     */
    public static boolean detainedCompleting(String key) {
        return Ward.detainedCompleting(key);
    }

    /**
     * 继续存活
     * @return .
     */
    public static Anagraph alive() {
        return new Anagraph(sTYPE_ALIVE);
    }

    public abstract static class Chaperonage {

        public Chaperonage() {
        }

        public Chaperonage(int patrol) {
            if (patrol > 0)
                mPatrol = patrol;
        }

        int mPatrol = 500;

        public abstract boolean Chaperonage();
    }

}
