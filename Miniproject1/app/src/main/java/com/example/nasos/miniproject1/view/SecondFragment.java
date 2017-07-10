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

public class SecondFragment extends Fragment {
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    ArrayList<ItemData> itemDatas;
    LinearLayoutManager linearLayoutManager;
    SwipeRefreshLayout swipeRefreshLayout;

    public SecondFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.second_rcv);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.second_swipe);


        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(false);


        // add divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getContext().getResources().getDrawable(R.drawable.line_divider));


        itemDatas = new ArrayList<ItemData>();
        itemDatas.add(new ItemData("김다휘님 외 28명", getContext().getString(R.string.content1),
                R.drawable.photo, "김준영", "댓글 9개", "7월 5일 오후1:19"));
        itemDatas.add(new ItemData("안고운님 외 7명", getContext().getString(R.string.content),
                R.drawable.photo2, "이지건", "댓글 5개", "7월 5일 오후1:11"));
        itemDatas.add(new ItemData("이승훈님 외 1명", getContext().getString(R.string.content2),
                R.drawable.photo, "정순호", " ", "7월 4일 오후9:11"));
        itemDatas.add(new ItemData("안고운님 외 7명", getContext().getString(R.string.content1),
                R.drawable.photo, "최진주", "댓글 13개", "7월 3일 오후2:11"));


        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerAdapter = new RecyclerAdapter(getHeader(), itemDatas, getContext());
        recyclerView.setAdapter(recyclerAdapter);
    }


    public Header getHeader() {
        Header header = new Header();
        header.setHeader(getContext().getString(R.string.header_edit_text));
        return header;
    }
}