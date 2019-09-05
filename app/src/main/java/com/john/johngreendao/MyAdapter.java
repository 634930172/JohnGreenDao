package com.john.johngreendao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.john.johngreendao.greendao.entity.User;
import com.john.johngreendao.greendao.util.ReflectUtil;

import java.util.List;

/**
 * Author: John
 * E-mail: 634930172@qq.com test3 test4 test5 test6
 * Date: 2018/7/17 10:42
 * <p/>
 * Description:用于展示数据的Adapter
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<User> data;

    MyAdapter(Context context, List<User> data){
        this.context=context;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if(convertView==null){
            holder=new MyViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item,null);
            holder.tv=convertView.findViewById(R.id.item_tv);
            convertView.setTag(holder);
        }else {
            holder= (MyViewHolder) convertView.getTag();
        }
        holder.tv.setText(ReflectUtil.getDataText(data.get(position)));
        return convertView;
    }


    private static class MyViewHolder{
        TextView tv;
    }

    public void refreshData(List<User> data){
        this.data=data;
        notifyDataSetChanged();
    }


}
