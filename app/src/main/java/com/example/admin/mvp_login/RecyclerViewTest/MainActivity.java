package com.example.admin.mvp_login.RecyclerViewTest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.admin.mvp_login.R;
import com.yanzhenjie.recyclerview.swipe.SwipeItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yanzhenjie.recyclerview.swipe.touch.OnItemMoveListener;
import com.yanzhenjie.recyclerview.swipe.widget.DefaultItemDecoration;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.recycler)
    SwipeMenuRecyclerView recycler;
    Context mContext;
    UserAdapter adapter;
    ArrayList<String> list;
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

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.addItemDecoration(new DefaultItemDecoration(getResources().getColor(R.color.decoration)));

        recycler.setSwipeItemClickListener(new SwipeItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(MainActivity.this,"你點擊了第"+(position+1)+"個的listItem",Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setLongPressDragEnabled(true);
        recycler.setOnItemMoveListener(new OnItemMoveListener() {
            @Override
            public boolean onItemMove(RecyclerView.ViewHolder srcHolder, RecyclerView.ViewHolder targetHolder) {
                int fromPosition = srcHolder.getAdapterPosition();
                int toPosition = targetHolder.getAdapterPosition();

                // Item被拖拽时，交换数据，并更新adapter。
                Collections.swap(list, fromPosition, toPosition);
                adapter.notifyItemMoved(fromPosition, toPosition);
                return true;
            }

            @Override
            public void onItemDismiss(RecyclerView.ViewHolder srcHolder) {
                //側滑刪除，不用
            }
        });
        recycler.setAdapter(adapter);

    }
    @OnClick({R.id.head_add,R.id.head_delete,R.id.botton_add,R.id.bottom_delete})
    void onClick(View view){
        switch (view.getId()) {
            case R.id.head_add:
                adapter.addHead("newHeadItem"+i);
                i++;
                break;
            case R.id.head_delete:
                adapter.deleteHead();
                break;
            case R.id.botton_add:
                adapter.addBottom("newBottomItem"+i);
                i++;
                break;
            case R.id.bottom_delete:
                adapter.deleteBottom();
                break;
        }
    }

}
