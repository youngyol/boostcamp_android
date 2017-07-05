package com.example.nasos.miniproject001;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SecondFragment extends Fragment   {
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
        recyclerView = (RecyclerView)view.findViewById(R.id.rcv);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe);
        itemDatas = new ArrayList<ItemData>();
        itemDatas.add(new ItemData("김다휘님 외 28명","내용1",R.drawable.photo2,"김준영","댓글 3개", "7월 5일 오후1:19"));
        itemDatas.add(new ItemData("안고운님 외 7명","내용1",R.drawable.photo,"이지건"," ","7월 5일 오후1:11"));
        itemDatas.add(new ItemData("이승훈님 외 1명","[스포탈코리아] 박대성 기자= 영국 유력 언론이 알렉상드르 라카제트의 아스널행을 보도했다.\n 팀 내 역대 최고액을 경신할 예정이다. 이제 공식 발표만 남았다.\n",R.drawable.photo3,"정순호"," ","7월 4일 오후9:11"));

        recyclerAdapter = new RecyclerAdapter(itemDatas, getContext());
        recyclerView.setAdapter(recyclerAdapter);


        return view;
    }

}