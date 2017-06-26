package com.m520it.www.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kay on 17/2/16.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.Holdet> {

    OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    ArrayList<String> titles;

    public RecyAdapter(ArrayList<String> titles) {
        this.titles = titles;
    }

    //产生需要的holder
    @Override
    public Holdet onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from( viewGroup.getContext ()).inflate(R.layout.item_title, null, false );
        //设置点击事件
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                  if(listener!=null){
                      listener.clickedItem();
                  }
            }
        });
        return new Holdet(itemView);
    }

    public void setDate(){
        titles = new ArrayList<>();
        notifyDataSetChanged();
    }

    //设置数据的
    @Override
    public void onBindViewHolder(Holdet holdet, int i) {
        holdet.setTitle(titles.get(i));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    static class Holdet extends RecyclerView.ViewHolder {

        TextView title;

        public Holdet(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }

        public void setTitle(String title){
            this.title.setText(title);
            }

    }
}
