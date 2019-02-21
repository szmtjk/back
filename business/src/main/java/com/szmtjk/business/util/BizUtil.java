package com.szmtjk.business.util;

public class BizUtil {

    public static final String MALE = "男";
    public static final String FEMALE = "女";

    public static final String YES = "是";
    public static final String NO = "否";

    public static int getGender(String sGender) {
        if (MALE.equals(sGender)) {
            return 1;
        } else if (FEMALE.equals(sGender)) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int getIfMarried(String yesOrNo) {
        if (YES.equals(yesOrNo)) {
            return 1;
        } else if (NO.equals(yesOrNo)) {
            return 2;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
    }
}
