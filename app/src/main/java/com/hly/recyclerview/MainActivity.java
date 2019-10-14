package com.hly.recyclerview;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    RecyclerViewAdapter adapter;
    List<String> list = new ArrayList<>();

    int currentPosition = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recy);

        for (int i = 0; i < 15; i++) {
            list.add("");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new RecyclerViewAdapter(this, R.layout.list_item, list);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListner(new RecyclerViewAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
             currentPosition = position;
             adapter.notifyDataSetChanged();
            }
        });

       adapter.setCallBack(new RecyclerViewAdapter.CallBack() {
           @Override
           public <T> void convert(IViewHolder holder, T bean, int position) {
               TextView textView = (TextView) holder.getView(R.id.txt);
               LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.li);
               if (position ==currentPosition){
                   textView.setTextColor(Color.parseColor("#D61642"));
                   linearLayout.setBackgroundColor(Color.parseColor("#FFFEBE"));
               }else{
                   textView.setTextColor(Color.parseColor("#1A1B1B"));
                   linearLayout.setBackgroundColor(Color.parseColor("#b5b5b5"));
               }
           }
       });


    }
}
