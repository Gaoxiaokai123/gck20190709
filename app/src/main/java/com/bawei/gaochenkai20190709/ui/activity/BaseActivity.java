package com.bawei.gaochenkai20190709.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.bawei.gaochenkai20190709.R;

/**
 * @Auther: 高晨凯
 * @Date: 2019/7/9 09:10:29
 * @Description:  activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        initView();
        initData();
    }

    protected abstract int layout();

    protected abstract void initData();

    protected abstract void initView();


}
