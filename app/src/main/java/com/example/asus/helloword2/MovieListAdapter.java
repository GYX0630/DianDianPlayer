package com.example.asus.helloword2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.nio.channels.Channel;
import java.util.List;


/**
 * Created by Asus on 2019/5/7.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHoler> {
    private Context mContext;
    private OnItemClickListener mListener;
    private List<GetMovie> channels;
    private List<MovieLab> data;
    private ChannelClickListener listener;

    public MovieListAdapter(List<GetMovie> context , OnItemClickListener listener) {
        this.channels = context;
        this.mListener = listener;
    }

    @Override
    public MovieViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view, parent,false);
        final MovieViewHoler holder = new MovieViewHoler(row);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, holder.getLayoutPosition());
            }
        });

//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view, parent, false);
//        MovieViewHoler a= new MovieViewHoler(LayoutInflater.from(mContext).inflate(R.layout.movie_view, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieViewHoler holder,int position) {

//        String name = MovieLab.get().getMovie(position);
//        String iconUrl = MovieLab.get().getIconUrl(position);
        holder.bind(mContext, channels.get(position));
        //
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mListener.onClick(position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }

    public class MovieViewHoler extends RecyclerView.ViewHolder {

        private TextView movieName,qingxi;
        private ImageView movieIcon;

        public MovieViewHoler(@NonNull View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movieName);
            movieIcon = itemView.findViewById(R.id.movieicon);
            qingxi = itemView.findViewById(R.id.movieqingxi);
        }

        public void bind(Context context, GetMovie c) {
            movieName.setText(c.getMovie());
            qingxi.setText(c.getqiangxi());

            Glide.with(context).load(c.getIconUrl()).into(movieIcon);

//            this.movieName.setText(movieName);
//            Glide.with(mContext).load(icon).into(movieIcon);
        }
    }
    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
