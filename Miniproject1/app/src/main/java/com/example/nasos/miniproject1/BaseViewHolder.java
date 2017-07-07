package com.example.nasos.miniproject1;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nasos on 2017-07-04.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_view_like)
    TextView VH_title;
    @BindView(R.id.content_txt)
    TextView VH_content;
    @BindView(R.id.image_id)
    ImageView VH_image;
    @BindView(R.id.comment)
    TextView VH_comment;
    @BindView(R.id.userName)
    TextView VH_name;
    @BindView(R.id.textTIme)
    TextView VH_time;

    @OnClick({ R.id.img_share, R.id.img_like, R.id.img_comment, R.id.image_id , R.id.userName, R.id.textTIme,R.id.content_txt, R.id.emoticon,R.id.user_profile})
    public void onClickCard(View v){
        switch (v.getId()){
            case R.id.img_share:
                Toast.makeText(v.getContext(), "공유하기", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_like:
                Toast.makeText(v.getContext(), "좋아요", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_comment:
                Toast.makeText(v.getContext(), "댓글", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_id:
                Toast.makeText(v.getContext(), "사진", Toast.LENGTH_SHORT).show();
                break;
            case R.id.userName:
                Toast.makeText(v.getContext(), "유저이름", Toast.LENGTH_SHORT).show();
                break;
            case R.id.content_txt:
                Toast.makeText(v.getContext(), "내용", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_profile:
                Toast.makeText(v.getContext(), "프로필사진", Toast.LENGTH_SHORT).show();
                break;
            case R.id.emoticon :
                Toast.makeText(v.getContext(), "이모티콘", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textTIme :
                Toast.makeText(v.getContext(), "작성시간", Toast.LENGTH_SHORT).show();
                break;

        }

    }




    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }



}