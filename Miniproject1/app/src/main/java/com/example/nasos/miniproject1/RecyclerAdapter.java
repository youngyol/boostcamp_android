package com.example.nasos.miniproject1;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nasos.miniproject1.model.Header;
import com.example.nasos.miniproject1.model.ItemData;

import java.util.ArrayList;


/**
 * Created by nasos on 2017-07-04.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    Header header;

    ArrayList<ItemData> itemDatas;
    Context context;

    public RecyclerAdapter(Header header, ArrayList<ItemData> itemDatas, Context context) {
        this.header = header;
        this.itemDatas = itemDatas;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_HEADER)
        {
            View v = LayoutInflater.from(context).inflate(R.layout.header_item,null);
            return  new HeaderViewHolder(v);
        }
        else if(viewType == TYPE_ITEM)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.item, null);
            return new BaseViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof HeaderViewHolder)
        {
            HeaderViewHolder VHheader = (HeaderViewHolder)holder;
            VHheader.txtTitle.setText(header.getHeader());
        }
        else if(holder instanceof BaseViewHolder) {
            BaseViewHolder VHItem = (BaseViewHolder)holder;

            VHItem.VH_title.setText(itemDatas.get(position-1).getTitle());
            VHItem.VH_content.setText(itemDatas.get(position-1).getContent());
            VHItem.VH_image.setImageResource(itemDatas.get(position-1).getImg());
            VHItem.VH_time.setText(itemDatas.get(position-1).getTime());
            VHItem.VH_name.setText(itemDatas.get(position-1).getName());
            VHItem.VH_comment.setText(itemDatas.get(position-1).getComment());

        }

    }



    @Override
    public int getItemCount() {
        return itemDatas != null ? itemDatas.size() : 0;
    }



    //    need to override this method
    @Override
    public int getItemViewType(int position) {
        if(isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position)
    {
        return position == 0;
    }




}
