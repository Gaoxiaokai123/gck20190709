package com.bawei.gaochenkai20190709.di;

import javax.security.auth.callback.Callback;

/**
 * @Auther: 高晨凯
 * @Date: 2019/7/9 09:07:50
 * @Description:  契约类
 */
public interface IContract {
    //V层
    public interface IView{
        void showInfoData(String call);
    }

    //P层
    public interface IPresenter<IView>{
        //关联V层
        void pvData(IContract.IView iView);
        //解绑
        void acttech();
        //数据传递
        void accc(Callback call);
    }

    //M层
    public interface IModel{
        //网络请求
        void CallBackData(String url, Callback Call);
        //传递V层
        void mvData();
    }

}
