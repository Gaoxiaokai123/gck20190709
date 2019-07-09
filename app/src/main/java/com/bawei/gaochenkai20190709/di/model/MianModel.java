package com.bawei.gaochenkai20190709.di.model;

import android.content.Context;

import com.bawei.gaochenkai20190709.data.bean.Conacta;
import com.bawei.gaochenkai20190709.di.IContract;
import com.bawei.gaochenkai20190709.di.presenter.MainPresenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.security.auth.callback.Callback;

/**
 * @Auther: 高晨凯
 * @Date: 2019/7/9 09:21:27
 * @Description:
 */
public class MianModel implements IContract.IModel {
    //创建P层对象
    IContract.IPresenter presenter = new MainPresenter();

//    WeakReference<IContract.IModel> weakReference = new WeakReference<IContract.IView>();


    //子线程网络请求
    @Override
    public void CallBackData(final String Url, final Callback Call) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(Conacta.URL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    int code = connection.getResponseCode();
                    if (code == 200){
                        String str = "";
                        StringBuffer buffer = new StringBuffer();
                        InputStream inputStream = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        while ((str = reader.readLine()) != null){
                            buffer.append(str);
                        }
                        buffer.toString();
                        presenter.accc(Call);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    public void mvData() {

    }
}
