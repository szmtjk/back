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
        for (int i = 10; i <= 99; i ++) {
            for (int j = 10; j <= 99; j ++) {
                int t1 = i * j;
                if (t1 < 1800) {
                    continue;
                }
                int t2 = (j % 10) * i;
                if (t2 < 180) {
                    continue;
                }

                int t3 = i * (j/10);
                if (t3 > 99) {
                    continue;
                }
                if ((t2 / 10) % 10 == 8  && (t1 /100 % 10 == 8)) {
                    System.out.println("i = " + i + ",j = " + j);
                }
            }
        }
    }
}
