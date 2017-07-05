package com.example.nasos.miniproject1;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nasos on 2017-07-04.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    TextView VH_title;
    TextView VH_content;
    ImageView VH_image;
    TextView VH_name;
    TextView VH_comment;
    TextView VH_time;

    public BaseViewHolder(View itemView) {
        super(itemView);
        VH_image = (ImageView)itemView.findViewById(R.id.image_id);
        VH_title = (TextView)itemView.findViewById(R.id.text_view_like);
        VH_content = (TextView)itemView.findViewById(R.id.content_txt);
        VH_name = (TextView)itemView.findViewById(R.id.userName);
        VH_comment = (TextView)itemView.findViewById(R.id.comment);
        VH_time = (TextView)itemView.findViewById(R.id.textTIme);

    }
}
