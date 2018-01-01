package com.xxx.boot.jdbc.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取sql
 * Date: 2015-09-25
 *
 * @author luoxiaoyong
 */
public class SqlHelper {

    private static final Pattern HINT_PATTERN = Pattern.compile("/\\*.*\\*/");

    /**
     * 是否包含master
     * @param sql like select /* master *\\/ from table
     * @return
     */
    public static boolean isHintMaster(String sql){
        Matcher matcher = HINT_PATTERN.matcher(sql);
        if(matcher.find()){
            return true;
        }
        return false;
    }
}
