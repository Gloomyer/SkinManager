package com.gloomyer.demo;

import android.os.Bundle;

import com.gloomyer.skin.base.SkinActivity;

public class MainActivity extends SkinActivity {

    @Override
    public String getTAG() {
        return "MainActivity";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
