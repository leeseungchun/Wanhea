package com.example.iseungcheon.wanhea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iseungcheon.wanhea.DTO.Item;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class ItemAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Item> itemList;
    LayoutInflater inf;


    public ItemAdapter(Context context, int layout, List<Item> itemList) {
        this.context = context;
        this.layout = layout;
        this.itemList = itemList;
       inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inf.inflate(layout, null);
        ImageView iv = (ImageView)convertView.findViewById(R.id.itemImg);
//        iv.setImageResource(itemList.get(position).getImg_url());

        Picasso.with(context)
                .load(itemList.get(position).getImg_url())
                .resize(600,600)
                .into(iv);

        TextView textView = (TextView)convertView.findViewById(R.id.pdtName);
        textView.setText(itemList.get(position).getName());
        return convertView;
    }
}
