package com.bawei.gaochenkai20190709.di.presenter;

import com.bawei.gaochenkai20190709.di.IContract;
import com.bawei.gaochenkai20190709.di.model.MianModel;

import javax.security.auth.callback.Callback;

/**
 * @Auther: 高晨凯
 * @Date: 2019/7/9 09:20:55
 * @Description:
 */
public class MainPresenter implements IContract.IPresenter<IContract.IView> {

    //创建M层对象
    IContract.IModel model = new MianModel();


    @Override
    public void pvData(IContract.IView iView) {
//        iView.showInfoData(String call);
//        model.CallBackData();
    }

    @Override
    public void acttech() {

    }

    @Override
    public void accc(Callback call) {

    }
}
