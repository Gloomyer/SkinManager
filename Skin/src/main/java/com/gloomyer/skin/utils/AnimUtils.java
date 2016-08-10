package com.gloomyer.skin.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.gloomyer.skin.interfaces.GAnimListner;
import com.gloomyer.skin.interfaces.IChangeSkin;


/**
 * 获取动画工具类
 */
public class AnimUtils {
    private static int ANIM_TIME = 300;

    /**
     * 执行动画切换皮肤
     *
     * @param I_V 实现了IChangeSkin的View对象
     */
    public static void runAnim(final IChangeSkin I_V) {
        final View v = (View) I_V;
        AlphaAnimation alpha = new AlphaAnimation(1, 0);
        alpha.setFillAfter(true);
        alpha.setDuration(ANIM_TIME);
        alpha.setAnimationListener(new GAnimListner() {
            @Override
            public void onAnimationEnd(Animation animation) {
                v.clearAnimation();
                I_V.changeSkin();

                AlphaAnimation alpha = new AlphaAnimation(0, 1);
                alpha.setFillAfter(true);
                alpha.setDuration(ANIM_TIME);
                v.startAnimation(alpha);
            }
        });
        v.startAnimation(alpha);
    }
}
