package com.example.nasos.miniproject1;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by nasos on 2017-07-04.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    ArrayList<ItemData> itemDatas;
    Context context;

    public RecyclerAdapter(ArrayList<ItemData> itemDatas, Context context) {
        this.itemDatas = itemDatas;
        this.context = context;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        BaseViewHolder viewHolder = new BaseViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.VH_title.setText(itemDatas.get(position).title);
        holder.VH_content.setText(itemDatas.get(position).content);
        holder.VH_image.setImageResource(itemDatas.get(position).img);
        holder.VH_time.setText(itemDatas.get(position).time);
        holder.VH_name.setText(itemDatas.get(position).name);
        holder.VH_comment.setText(itemDatas.get(position).comment);



    }



    @Override
    public int getItemCount() {
        return itemDatas != null ? itemDatas.size() : 0;
    }
}
