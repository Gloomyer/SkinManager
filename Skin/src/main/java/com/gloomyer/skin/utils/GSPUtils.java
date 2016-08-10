package com.gloomyer.skin.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * GloomySharedPreferencesUtils
 *
 * @author Gloomy
 */
public class GSPUtils {

    private final static String FILE_NAME = "GloomySkin";

    /**
     * 压入首选项一个值
     */
    public static void put(Context context, String key, Object value) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (value instanceof Boolean)
            edit.putBoolean(key, (Boolean) value);
        else if (value instanceof Integer)
            edit.putInt(key, (Integer) value);
        else if (value instanceof String)
            edit.putString(key, (String) value);
        edit.commit();
    }

    /**
     * 获取一个值
     *
     * @param context
     * @param key
     * @return 不存在或失败返回 -1
     */
    public static int getI(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, -1);
    }
}
