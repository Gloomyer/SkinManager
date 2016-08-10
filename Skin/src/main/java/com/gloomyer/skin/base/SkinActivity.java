package com.gloomyer.skin.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import com.gloomyer.skin.SkinManager;
import com.gloomyer.skin.interfaces.IActivity;


/**
 * 皮肤父类Activity
 */
public abstract class SkinActivity extends AppCompatActivity implements IActivity {

    private String tag;

    @Override
    @CallSuper
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        tag = getTAG();
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        SkinManager.getInstance().setShowActTag(tag);
    }
}
