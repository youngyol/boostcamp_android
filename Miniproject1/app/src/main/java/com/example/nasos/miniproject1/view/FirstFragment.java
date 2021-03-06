package com.example.nasos.miniproject1.view;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nasos.miniproject1.R;
import com.example.nasos.miniproject1.RecyclerAdapter;
import com.example.nasos.miniproject1.model.Header;
import com.example.nasos.miniproject1.model.ItemData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FirstFragment extends Fragment   {
    RecyclerAdapter recyclerAdapter;
    @BindView(R.id.first_rcv)
    RecyclerView recyclerView;


    private Unbinder unbinder;


    ArrayList<ItemData> itemDatas;
    LinearLayoutManager linearLayoutManager;
    SwipeRefreshLayout swipeRefreshLayout;



    public FirstFragment() {

    }

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        unbinder= ButterKnife.bind(this, view);
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.first_swipe);
        swipeRefreshLayout.setRefreshing( false );
        swipeRefreshLayout.setEnabled( false );





        // add divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getContext().getResources().getDrawable(R.drawable.line_divider));

        // add data
        itemDatas = new ArrayList<ItemData>();
        itemDatas.add(new ItemData("김다휘님 외 30명",getContext().getString(R.string.content1),
                R.drawable.photo2,"김준영","댓글 9개", "7월 5일 오후1:19"));
        itemDatas.add(new ItemData("안고운님 외 7명",getContext().getString(R.string.content)
                ,R.drawable.photo,"이지건","댓글 5개","7월 5일 오후1:11"));
        itemDatas.add(new ItemData("이승훈님 외 1명",getContext().getString(R.string.content2),
                R.drawable.photo3,"정순호"," ","7월 4일 오후9:11"));
        itemDatas.add(new ItemData("김다휘님 외 28명",getContext().getString(R.string.content3),
                R.drawable.photo4,"문경헌","댓글 3개", "7월 4일 오후1:19"));
        itemDatas.add(new ItemData("안고운님 외 7명",getContext().getString(R.string.content1),
                R.drawable.photo,"최진주","댓글 13개","7월 3일 오후2:11"));


        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerAdapter = new RecyclerAdapter(getHeader(),itemDatas, getContext());
        recyclerView.setAdapter(recyclerAdapter);
    }

    public Header getHeader()
    {
        Header header = new Header();
        header.setHeader(getContext().getString(R.string.header_edit_text));
        return header;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}


