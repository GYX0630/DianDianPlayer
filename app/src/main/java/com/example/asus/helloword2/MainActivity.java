package com.example.asus.helloword2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowAnimationFrameStats;
import android.view.WindowContentFrameStats;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.exoplayer2.Timeline;

import java.util.List;

import javax.sql.DataSource;

public class MainActivity extends AppCompatActivity {

    private RecyclerView movieList;
    private MovieListAdapter movieAdapter;
    private ImageView movieIcon;
    private List<GetMovie> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        movieList = (RecyclerView) findViewById(R.id.movielist);
        movieIcon = findViewById(R.id.movieicon);

//        movieAdapter = new MovieListAdapter();

//        movieAdapter = new MovieListAdapter(this.data, new ChannelClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Log.i("FFPLAY", "Clicked "+view+" on "+position);
//                if (position < data.size()) {
//                    GetMovie c = data.get(position);
//                    Intent intent = new Intent(MainActivity.this, LiveActivity.class);
//                    intent.putExtra("uri", c.getUrl());
//                    intent.putExtra("name",c.getMovie());
//                    startActivity(intent);
//                } else {
////                    Toast.makeText(MainActivity.this, "无效的频道",Toast.LENGTH_SHORT);
//                }
//            }
//        });


        movieList.setAdapter(new MovieListAdapter(this.data, new MovieListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {

                GetMovie c = data.get(pos);
//                String movieName = MovieLab.get().getMovie(pos);
//                String movieUrl = MovieLab.get().getUrl(pos);
//                String iconUrl = MovieLab.get().getIconUrl(pos);
//                Toast.makeText(MainActivity.this,"点击"+movieUrl,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,LiveActivity.class);
                intent.putExtra("uri",c.getUrl());
                intent.putExtra("name",c.getMovie());
//                intent.putExtra("icon",iconUrl);
                startActivity(intent);
            }
        }));

//        movieList.setAdapter(movieAdapter);

        movieList.setLayoutManager(new LinearLayoutManager(this));
//        movieList.setAdapter(movieAdapter);
        movieList.addItemDecoration(new MyDecoration());//在每个元素下面添加分割线
//        movieList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }


    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }

    private void initData() {
        MovieLab lab = new MovieLab(this);
        this.data = lab.getChannels("data.json");
    }
}

