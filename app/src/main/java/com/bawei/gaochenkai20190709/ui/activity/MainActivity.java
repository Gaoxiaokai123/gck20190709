package com.bawei.gaochenkai20190709.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.bawei.gaochenkai20190709.R;
import com.bawei.gaochenkai20190709.data.bean.GsonBean;
import com.bawei.gaochenkai20190709.di.IContract;
import com.bawei.gaochenkai20190709.di.presenter.MainPresenter;
import com.bawei.gaochenkai20190709.ui.adapter.MyGridAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements IContract.IView {

    private GridView grid;
    private IContract.IPresenter presenter;
    public MyGridAdapter adapter;
    private PullToRefreshListView pull;
    private int page = 1;
    private ArrayList<GsonBean> list;


    //关联视图
    @Override
    protected int layout() {
        return R.layout.activity_main;
    }


    @Override
    protected void initData() {
        //创建P层对象
        presenter = new MainPresenter();
        //关联P层
        presenter.pvData(this);

    }
    //控件id
    @Override
    protected void initView() {
        grid = findViewById(R.id.grid);
        pull = findViewById(R.id.pull);
    }

    //更新UI
//    @Override
//    public void showInfoData(String ) {
//        ArrayList<GsonBean.ResultBean> list = new ArrayList<>();
//        Gson gson = new Gson();
////        GsonBean bean = gson.fromJson(GsonBean.class);
//
//        grid.setAdapter(new MyGridAdapter(list, MainActivity.this));
//
//    }

    //解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.acttech();
    }

    @Override
    public void showInfoData(String call) {
        //允许上下拉
        pull.setScrollingWhileRefreshingEnabled(true);
        pull.setMode(pull.getCurrentMode());
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page  = 1;
                pull.setAdapter(new MyGridAdapter(list,MainActivity.this));
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page  ++;
                pull.setAdapter(new MyGridAdapter(list,MainActivity.this));
            }
        });


        list = new ArrayList<>();
//        GsonBean gsonBean = new GsonBean();
//        GsonBean gsonBean = new GsonBean(GsonBean.class);
        JsonObject object = new JsonObject();
        for (int i = 0; i < object.size(); i++) {
            Class<JsonObject> object1 = JsonObject.class;
            JsonArray result = object.getAsJsonArray("result");


        }
        pull.notify();
        grid.setAdapter(new MyGridAdapter(list, MainActivity.this));
    }
}
