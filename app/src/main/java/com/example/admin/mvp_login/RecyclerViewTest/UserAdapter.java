package com.example.admin.mvp_login.RecyclerViewTest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mvp_login.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private ArrayList<String> list;
    private Context mContext;
    public UserAdapter() {
    }
    public UserAdapter(Context context,ArrayList<String> list){
        this.mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContext= parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.num.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.num)
        TextView num;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void addHead(String itemName){
        list.add(0,itemName);
        notifyItemInserted(0);
    }

    public void deleteHead(){
        if(list.size()>0) {
            list.remove(0);
            notifyItemRemoved(0);
        }else{
            Toast.makeText(mContext,"List已空!",Toast.LENGTH_SHORT).show();
        }
    }

    public void addBottom(String itemName){
        list.add(itemName);
        notifyItemInserted(list.size());
    }

    public void deleteBottom(){
        if(list.size()>0) {
            list.remove(list.size() - 1);
            notifyItemRemoved(list.size());
        }else{
            Toast.makeText(mContext,"List已空!",Toast.LENGTH_SHORT).show();
        }
    }

}
