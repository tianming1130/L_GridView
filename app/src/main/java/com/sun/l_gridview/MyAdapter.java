package com.sun.l_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by sun on 2017/11/11.
 */

public class MyAdapter extends BaseAdapter {
    private List<Map<String,Object>> dataList;
    private Context context;
    public MyAdapter(Context context,List<Map<String,Object>> dataList){
        this.context=context;
        this.dataList=dataList;
    }
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.grid_item,null);

            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.image);
            viewHolder.tvPrice=(TextView)convertView.findViewById(R.id.tv_price);
            viewHolder.tvContent=(TextView)convertView.findViewById(R.id.tv_content);

            convertView.setTag(viewHolder);

       }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }

        viewHolder.imageView.setImageResource((int)dataList.get(position).get("img"));
        viewHolder.tvPrice.setText((String)dataList.get(position).get("price"));
        viewHolder.tvContent.setText((String)dataList.get(position).get("content"));

        return convertView;
    }
    private  class  ViewHolder{
        ImageView imageView;
        TextView tvPrice;
        TextView tvContent;
    }
}
