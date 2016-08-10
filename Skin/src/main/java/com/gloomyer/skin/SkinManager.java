package com.gloomyer.skin;

import android.content.Context;

import com.gloomyer.skin.utils.GSPUtils;

/**
 * 皮肤管理控制者
 */
public class SkinManager {

    private static final String SP_NAME = "skinNum";
    public static final int SKIN_DAY = 0;
    public static final int SKIN_NIGHT = 1;
    private static SkinManager instance;


    private String showActTag;
    private int showSkinNum;

    /**
     * 获取皮肤管理控制着唯一对象
     *
     * @return
     */
    public static SkinManager getInstance() {
        synchronized (SkinManager.class) {
            if (instance == null) {
                instance = new SkinManager();
            }
        }
        return instance;
    }

    private SkinManager() {

    }

    /**
     * 设置当前显示的Activity的tag
     *
     * @param tag
     */
    public void setShowActTag(String tag) {
        if (tag == null)
            new NullPointerException("Activity标记TAG不能为空");
        showActTag = tag;
    }

    /**
     * 获取当前正在显示的Activity的tag
     *
     * @return 如果不存在返回空字符串
     */
    public String getShowActTag() {
        if (showActTag == null)
            showActTag = "";
        return showActTag;
    }

    /**
     * 执行初始化操作
     *
     * @param context 上下文，推荐使用ApplicationContext
     */
    public void init(Context context) {
        int skinNum = GSPUtils.getI(context, SP_NAME);
        if (skinNum == -1) {
            skinNum = 0;
            GSPUtils.put(context, SP_NAME, skinNum);
        }
        showSkinNum = skinNum;
    }

    /**
     * 获取当前正在显示的skinnum
     *
     * @return
     */
    public int getShowSkinNum() {
        return showSkinNum;
    }
}
