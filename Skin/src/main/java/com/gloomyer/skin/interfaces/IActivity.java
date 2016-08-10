package com.gloomyer.skin.interfaces;

/**
 * 基础Activity规范接口
 */
public interface IActivity {
    /**
     * 实现此方法返回唯一标示
     *
     * @return 推荐返回当前Activity的全类名字符串
     */
    String getTAG();
}
