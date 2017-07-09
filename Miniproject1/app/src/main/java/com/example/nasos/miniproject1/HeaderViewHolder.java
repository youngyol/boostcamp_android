package com.example.nasos.miniproject1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nasos on 2017-07-09.
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.txtHeader)
    TextView txtTitle;


    @OnClick({R.id.txtHeader, R.id.header_user_profile})
    public void onClickCard(View v) {
        switch (v.getId()) {
            case R.id.txtHeader:
                Toast.makeText(v.getContext(), "글쓰기", Toast.LENGTH_SHORT).show();
                break;
            case R.id.header_user_profile:
                Toast.makeText(v.getContext(), "유저프로필사진", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public HeaderViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }
}