package com.example.nasos.miniproject1;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item, parent, false);
            return  new VHHeader(v);
        }
        else if(viewType == TYPE_ITEM)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.item, null);
            BaseViewHolder viewHolder = new BaseViewHolder(view);

            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof VHHeader)
        {
            VHHeader VHheader = (VHHeader)holder;
            VHheader.txtTitle.setText(header.getHeader());
        }
        else if(holder instanceof BaseViewHolder) {
            BaseViewHolder VHItem = (BaseViewHolder)holder;

            VHItem.VH_title.setText(itemDatas.get(position-1).title);
            VHItem.VH_content.setText(itemDatas.get(position-1).content);
            VHItem.VH_image.setImageResource(itemDatas.get(position-1).img);
            VHItem.VH_time.setText(itemDatas.get(position-1).time);
            VHItem.VH_name.setText(itemDatas.get(position-1).name);
            VHItem.VH_comment.setText(itemDatas.get(position-1).comment);

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


    class VHHeader extends RecyclerView.ViewHolder{
        TextView txtTitle;
        public VHHeader(View itemView) {
            super(itemView);
            this.txtTitle = (TextView)itemView.findViewById(R.id.txtHeader);
        }
    }


}
