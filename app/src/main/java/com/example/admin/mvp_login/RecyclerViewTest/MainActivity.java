package com.example.admin.mvp_login.RecyclerViewTest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.admin.mvp_login.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Context mContext;
    UserAdapter adapter;
    ArrayList<String> list;
    String newItem = "newItem";
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        list = new ArrayList<>();
        for(int i=0;i<=5;i++){
            list.add("Item"+i);
        }
        adapter = new UserAdapter(mContext,list);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


    }
    @OnClick({R.id.head_add,R.id.head_delete,R.id.botton_add,R.id.bottom_delete})
    void onClick(View view){
        switch (view.getId()) {
            case R.id.head_add:
                adapter.addHead(newItem+i);
                i++;
                break;
            case R.id.head_delete:
                adapter.deleteHead();
                break;
            case R.id.botton_add:
                adapter.addBottom(newItem+i);
                i++;
                break;
            case R.id.bottom_delete:
                adapter.deleteBottom();
                break;
        }
    }

}
