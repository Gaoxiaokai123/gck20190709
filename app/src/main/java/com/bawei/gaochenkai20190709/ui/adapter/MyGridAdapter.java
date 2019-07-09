package com.bawei.gaochenkai20190709.ui.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.gaochenkai20190709.R;
import com.bawei.gaochenkai20190709.data.bean.GsonBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * @Auther: 高晨凯
 * @Date: 2019/7/9 09:25:35
 * @Description:
 */
public class MyGridAdapter extends BaseAdapter {
    ArrayList<GsonBean> list;
    Context context;

    public MyGridAdapter(ArrayList<GsonBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = View.inflate(context, R.layout.item,null);
            holder = new ViewHolder();
            holder.iv = view.findViewById(R.id.item_image);
            holder.name = view.findViewById(R.id.item_name);
            holder.price = view.findViewById(R.id.item_price);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(list.get(i).getMasterPic()).into(holder.iv);
        holder.name.setText(list.get(i).getCommodityName());
        holder.price.setText(list.get(i).getPrice());

        return view;
    }

    class ViewHolder{
        ImageView iv;
        TextView name;
        TextView price;
    }
}
