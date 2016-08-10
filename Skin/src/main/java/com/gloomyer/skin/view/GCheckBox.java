package com.gloomyer.skin.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.gloomyer.skin.R;
import com.gloomyer.skin.SkinManager;
import com.gloomyer.skin.bean.SkinMsg;
import com.gloomyer.skin.interfaces.IChangeSkin;
import com.gloomyer.skin.utils.AnimUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 皮肤CheckBox
 */
public abstract class GCheckBox extends CheckBox implements IChangeSkin {
    /**
     * 皮肤一的背景颜色和皮肤二的背景颜色状态
     * -1:未设置,0:颜色值,1:资源值
     */
    private int[] skinStatus;
    private int[] bgs;
    private int[] tcs;
    private String tag = "";
    private int showSkinNum = -1;

    public GCheckBox(Context context) {
        super(context);
    }

    public GCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        skinStatus = new int[]{-1, -1};
        tcs = new int[]{-1, -1};

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Skin);

        /**
         * 皮肤0的背景颜色读取
         */
        int dayBg = typedArray.getColor(R.styleable.Skin_dayBc, -1);
        if (dayBg == -1) {
            dayBg = typedArray.getResourceId(R.styleable.Skin_dayBg, -1);
            if (dayBg != -1)
                skinStatus[0] = 1;
        } else {
            skinStatus[0] = 0;
        }
        //白天文字颜色
        tcs[0] = typedArray.getColor(R.styleable.Skin_dayTc, -1);


        /**
         * 皮肤1的背景颜色读取
         */
        int nigBg = typedArray.getColor(R.styleable.Skin_nigBc, -1);
        if (nigBg == -1) {
            nigBg = typedArray.getResourceId(R.styleable.Skin_nigBg, -1);
            if (nigBg != -1)
                skinStatus[1] = 1;
        } else {
            skinStatus[1] = 0;
        }
        tcs[1] = typedArray.getColor(R.styleable.Skin_nigTc, -1);

        bgs = new int[]{dayBg, nigBg};
        typedArray.recycle();
    }

    @Override
    protected void onAttachedToWindow() {
        tag = SkinManager.getInstance().getShowActTag();
        EventBus.getDefault().register(this);
        changeSkin();
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        EventBus.getDefault().unregister(this);
        super.onDetachedFromWindow();
    }

    /**
     * 皮肤切换消息接收者
     *
     * @param msg 要接受的消息
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ReadedMsg(SkinMsg msg) {
        if (this.tag.equals(msg.tag) && this.tag.equals(SkinManager.getInstance().getShowActTag())) {
            AnimUtils.runAnim(this);
        } else if (this.tag.equals(tag)) {
            changeSkin();
        }
    }

    @Override
    public void changeSkin() {
        int skinNum = SkinManager.getInstance().getShowSkinNum();

        if (showSkinNum == skinNum)
            return;
        /**
         * 切换背景
         */
        if (skinStatus[skinNum] == 0)
            setBackgroundColor(bgs[skinNum]);
        else if (skinStatus[skinNum] == 1)
            setBackgroundResource(bgs[skinNum]);

        /**
         * 切换文字颜色
         */
        if (tcs[skinNum] != -1)
            setTextColor(tcs[skinNum]);

        showSkinNum = skinNum;
    }
}
