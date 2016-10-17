package com.xiao.demoablepsia;


public class SignInStatus {

    private static boolean isSign = false;

    public static boolean isSign() {
        return isSign;
    }

    public static void changeStatus(boolean status){
        isSign = status;
    }
}
